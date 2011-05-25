package falcons.plugin.exported;

import java.io.Serializable;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeLogic;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeModel;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

@Plugin(pluginID = "TicTacToePlugin", versionID = "0.1")
public class TicTacToePlugin extends AbstractPlugin{

	private TicTacToeModel model;
	private TicTacToeLogic logic;
	private static TicTacToeMainPanel mainPanel;
	private TicTacToeController cont;

	public TicTacToePlugin() {
		mainPanel = new TicTacToeMainPanel();
		model = new TicTacToeModel(mainPanel.getButtons());
		logic = new TicTacToeLogic(model);
		cont = new TicTacToeController(mainPanel, logic);
		mainPanel.addActionListener(cont);
		model.addObserver(mainPanel);
	}
	
	@Override
	public void receiveCall(PluginCall call) {
		int data = (Integer) call.getPluginData().getData();
		
		if (call.getPluginData().getMethodID().equals("turn")){
			cont.turn(data, false);
		}
		else if(call.getPluginData().getMethodID().equals("startGame")){
			logic.setMe(true);
		}
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	public static void main(String[] arg){
		JFrame frame = new JFrame();
		new TicTacToePlugin();
		frame.add(mainPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
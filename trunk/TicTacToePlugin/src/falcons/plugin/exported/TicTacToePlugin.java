package falcons.plugin.exported;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;
import falcons.plugin.exported.ticTacToePlugin.model.ConnectedClientsModel;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeLogic;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeModel;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

@Plugin(pluginID = "TicTacToePlugin", versionID = "0.1")
public class TicTacToePlugin extends AbstractPlugin{

	private TicTacToeModel model;
	private ConnectedClientsModel cModel;
	private TicTacToeLogic logic;
	private static TicTacToeMainPanel mainPanel;
	private TicTacToeController cont;
	
	/**
	 * 
	 * Constructor for TicTacToePlugin, instances view, controller, logic and model
	 * 
	 */
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
		int data = ((Number) call.getPluginData().getData()).intValue();
		
		if (call.getPluginData().getMethodID().equals("turn")){
			cont.changeX(data);
		}
		else if(call.getPluginData().getMethodID().equals("startGame")){
			mainPanel.newGame();
			logic.setMe(true);
		}
		else if(call.getPluginData().getMethodID().equals("getClients")){
			cModel.setClients((HashMap<String, Long>)call.getPluginData().getData());
			System.out.println("Here TicTacToe");
		}
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
}
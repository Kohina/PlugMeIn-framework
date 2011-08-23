package falcons.plugin.exported;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginClientInfo;
import falcons.plugin.Pluggable;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;
import falcons.plugin.exported.ticTacToePlugin.model.ConnectedClientsLogic;
import falcons.plugin.exported.ticTacToePlugin.model.ConnectedClientsModel;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeLogic;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeModel;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

@Plugin(pluginID = "TicTacToePlugin", versionID = "0.1")
public class TicTacToePlugin extends AbstractPlugin{

	private TicTacToeModel model;
	private ConnectedClientsModel cModel;
	private TicTacToeLogic logic;
	private ConnectedClientsLogic clogic;
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
		cModel = new ConnectedClientsModel();
		clogic = new ConnectedClientsLogic(cModel);
		cont = new TicTacToeController(mainPanel, logic, clogic);
		mainPanel.addActionListener(cont);
		model.addObserver(mainPanel);
		cModel.addObserver(mainPanel);
	}
	
	@Override
	public void receiveCall(PluginCall call) {
		
		if (call.getPluginData().getMethodID().equals("end")){
			JOptionPane.showMessageDialog(null, "Your opponent has left the game, your game will be closed");
			mainPanel.connectView();
			cont.reset(false);
		}
		else if (call.getPluginData().getMethodID().equals("turn")){
			System.out.println("turn recieved");
			int data = ((Number) call.getPluginData().getData()).intValue();
			cont.change(data);
			logic.setMe(true);
			mainPanel.setTurnText(true);
		}
		else if(call.getPluginData().getMethodID().equals("invite")){
			if(JOptionPane.showOptionDialog(null, "Do you want to play TicTacToe?", "Game invite", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION){
				mainPanel.newGame();
				logic.setMe(true);
				logic.setIsX(false);
			}
			else{
				AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("end", "0.1", null);
				TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, logic.getDestination(), -2));
			}
		}
		else if(call.getPluginData().getMethodID().equals("receiveClients")){
			List<PluginClientInfo> clients = (List<PluginClientInfo>) call.getPluginData().getData();
			HashMap<Integer, String> hashMap = new HashMap<Integer, String>(); 
			for(PluginClientInfo c: clients){
				hashMap.put(c.getID(), c.getName());
			}
			
			cont.setClients(hashMap);
		}
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
}
package falcons.plugin.exported;

import java.io.Serializable;
import java.util.Observable;

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
	private TicTacToeMainPanel mainPanel;
	private TicTacToeController cont;

	public TicTacToePlugin() {
		model = new TicTacToeModel();
		logic = new TicTacToeLogic(model);
		mainPanel = new TicTacToeMainPanel();
		mainPanel.addActionListener(cont);
	}
	
	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData data = call.getPluginData();
		
		if (data.getMethodID().equals("start") && data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			
		} 
		else if (!data.getMethodID().equals("start") && !data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("Both the methodID and the versionID is not the same as the plugin sending the call.");
		} 
		else if (!data.getMethodID().equals("start")) {
			System.out.println("There doesn't exist a method with that methodID.");
		} 
		else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		}
		
		if (data.getMethodID().equals("turn") && data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
	
		} 
		else if (!data.getMethodID().equals("turn") && !data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("Both the methodID and the versionID is not the same as the plugin sending the call.");
		} 
		else if (!data.getMethodID().equals("turn")) {
			System.out.println("There doesn't exist a method with that methodID.");
		} 
		else if (!data.getVersionID().equals(this.getClass().getAnnotation(Plugin.class).versionID())) {
			System.out.println("The version of the plugin sending the PluginCall is not the same as the one receiving it.");
		}
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}
}
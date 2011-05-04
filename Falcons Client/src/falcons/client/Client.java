package falcons.client;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

import javax.swing.JSeparator;

import falcons.client.model.ClientPreferencesLogic;
import falcons.client.view.ClientSystemTray;
import falcons.client.view.ClientView;
import falcons.client.view.ConnectionView;
import falcons.pluginmanager.DataInterpreter;
import falcons.pluginmanager.PluginModel;

public class Client{
	
	private static ClientView clientView;
	private static ConnectionView connectionView;
	private static PluginModel pluginModel;
	private static DataInterpreter interpreter;
	private static ClientSystemTray systemTray;	
	
	public static final File DIR = new File(System.getProperty("user.dir"));

	public void run(){
		ClientPreferencesLogic.readPreferences();
		pluginModel = PluginModel.getInstance();
		interpreter = DataInterpreter.getInstance(true);
		clientView = new ClientView();
		connectionView = new ConnectionView();
		systemTray = new ClientSystemTray(clientView, connectionView);

		Object[] nameSet = pluginModel.getPluginMap().keySet().toArray();
		
		for(Object o : nameSet){
			String pluginName = o.toString();
			clientView.addTab(pluginName, pluginModel.getPluginMap().get(pluginName).getMainPanel());
		}
	}

	
}

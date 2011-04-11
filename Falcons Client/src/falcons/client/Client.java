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

import javax.swing.JSeparator;

import falcons.client.view.ClientSystemTray;
import falcons.client.view.ClientView;
import falcons.client.view.ConnectionView;
import falcons.pluginmanager.DataInterpreter;
import falcons.pluginmanager.PluginModel;

import simple-xml-2.5.1.jar;

public class Client{
	
	private static ClientView clientView;
	private static ConnectionView connectionView;
	private static PluginModel pluginModel;
	private static DataInterpreter interpreter;
	private static ClientSystemTray systemTray;
	
	public static final File DIR = new File(System.getProperty("user.dir"));

	public void run(){
		pluginModel = pluginModel.getInstance();
		interpreter = interpreter.getInstance(true);
		clientView = new ClientView();
		connectionView = new ConnectionView();
		systemTray = new ClientSystemTray(clientView, connectionView);
		
		clientView.addTab("Send Message", pluginModel.getPluginMap().get("SendMessagePlugin").getMainPanel());
		
	}

	
}

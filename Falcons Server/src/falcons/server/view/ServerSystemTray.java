package falcons.server.view;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import falcons.server.ServerImpl;

public class ServerSystemTray implements ActionListener {

	private static MenuItem mainView = new MenuItem("Main");
	private static MenuItem startButton = new MenuItem("Start server");
	private static MenuItem exitButton = new MenuItem("Exit");
	
	private static ServerImpl server;

	public ServerSystemTray() {
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage("Falcons-Icon.gif");
			
			server = new ServerImpl();
			PopupMenu popup = new PopupMenu();
			popup.add(startButton);
			startButton.addActionListener(this);
			popup.add(exitButton);
			exitButton.addActionListener(this);
			TrayIcon trayIcon = new TrayIcon(image, "Falcons Server", popup);
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("Can't add to tray");
			}
		} else {
			System.err.println("Tray unavailable");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			if(server.isRunning()) {
				server.stop();
				startButton.setLabel("Start server");
			} else {
				server.run();
				startButton.setLabel("Stop server");
			}
		} else if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
}

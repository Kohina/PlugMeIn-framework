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

//import falcons.server.view.ServerView;

public class ServerSystemTray implements ActionListener {

	private static MenuItem mainView = new MenuItem("Main");
	private static MenuItem exitButton = new MenuItem("Exit");
	//private ServerView serverView;

	public ServerSystemTray() {
		//this.serverView = serverView;
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(
					"Falcons-Icon.gif");

			PopupMenu popup = new PopupMenu();
			popup.add(mainView);
			mainView.addActionListener(this);
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
		if (e.getSource() == mainView) {
			//serverView.setLocationRelativeTo(null);
			//serverView.setVisible(true);
		}
		if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
}

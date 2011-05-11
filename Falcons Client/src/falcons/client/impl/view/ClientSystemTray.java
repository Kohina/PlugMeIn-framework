package falcons.client.impl.view;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientSystemTray implements ActionListener {

	private static MenuItem mainView = new MenuItem("Main");
	private static MenuItem settingsView = new MenuItem("Settings");
	private static MenuItem exitButton = new MenuItem("Exit");
	private static ClientView clientView;
	private static ConnectionView connectionView;

	public ClientSystemTray(ClientView clientView, ConnectionView connectionView) {
		this.clientView = clientView;
		this.connectionView = connectionView;
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(
					"Falcons-Icon.gif");
			PopupMenu popup = new PopupMenu();
			popup.add(mainView);
			mainView.addActionListener(this);
			popup.add(settingsView);
			settingsView.addActionListener(this);
			popup.add(exitButton);
			exitButton.addActionListener(this);
			TrayIcon trayIcon = new TrayIcon(image, "Falcons", popup);
			try {
				tray.add(trayIcon);
			} catch (AWTException e) {
				System.err.println("Can't add to tray");
			}
		} else {
			System.err.println("Tray unavailable");
		}
	}

	// TODO Should use controllers.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView) {
			clientView.setLocationRelativeTo(null);
			clientView.setVisible(true);
		} else if (e.getSource() == settingsView) {
			connectionView.setLocationRelativeTo(null);
			connectionView.setVisible(true);
		} else if (e.getSource() == exitButton) {
			System.exit(0);
		}

	}
}

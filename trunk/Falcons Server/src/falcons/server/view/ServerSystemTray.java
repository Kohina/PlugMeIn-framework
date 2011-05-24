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

public class ServerSystemTray implements ActionListener {

	private static MenuItem exitButton = new MenuItem("Exit");

	public ServerSystemTray() {
		if (SystemTray.isSupported()) {
			SystemTray tray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().getImage(
					"Falcons-Icon.gif");

			PopupMenu popup = new PopupMenu();
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
		if(e.getSource() == exitButton){
			System.exit(0);
		}
	}
}

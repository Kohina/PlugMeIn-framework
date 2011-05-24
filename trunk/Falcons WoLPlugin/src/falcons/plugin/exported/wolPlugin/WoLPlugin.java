package falcons.plugin.exported.wolPlugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;

@Plugin(pluginID = "Wake on LAN", versionID = "1.0")
public class WoLPlugin extends AbstractPlugin implements ActionListener {
	private WoLPluginMainPanel mainPanel = WoLPluginMainPanel.getInstance(this);
	
	public WoLPlugin() {
		// Do nasing...
	}

	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData<?> pluginData = call.getPluginData();
		
		if(pluginData.getMethodID() == "wakeClient") {
			wakeClient((Client) pluginData.getData());
		}
	}

	private void wakeClient(Client client) {
		final int PORT = 9;
		
		try {
			DatagramPacket packet = new DatagramPacket(client.getMac(), client.getMac().length, client.getIp(), PORT);
	        DatagramSocket socket = new DatagramSocket();
	        socket.send(packet);
	        socket.close();
	        
	        System.out.println("Wake-on-LAN packet sent.");
		}
		catch(Exception e) {
			System.out.println("Couldn't send wake on LAN-package: + e");
		}
	}

	@Override
	public JPanel getMainPanel() {
		return mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainPanel.getWakeUpButton()) {
			Client client = new Client(mainPanel.getIpAdrStr().getText(), mainPanel.getMacAdrStr().getText());
			AbstractPluginData<Client> pluginData = new AbstractPluginData<Client>("wakeClient", this.getClass().getAnnotation(Plugin.class).versionID(), client);
			PluginCall call = new PluginCall(this, pluginData, -1);
			send(call);
		}
	}

}

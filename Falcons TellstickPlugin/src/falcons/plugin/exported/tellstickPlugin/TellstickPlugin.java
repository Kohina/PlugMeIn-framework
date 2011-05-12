package falcons.plugin.exported.tellstickPlugin;

import javax.swing.*;

import falcons.plugin.*;
import falcons.*;

import falcons.plugin.exported.tellstickPlugin.javatellstickAPI.*;

@Plugin(pluginID = "Tellstick", versionID = "0.1")
public class TellstickPlugin extends AbstractPlugin {
	
	public TellstickPlugin() {
		
	}
	
	@Override
	public void receiveCall(PluginCall call) {
		
	}

	@Override
	public JPanel getMainPanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("IT WORKS"));
		return panel;
	}

}

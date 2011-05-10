package falcons.plugin.exported;

import javax.swing.JLabel;
import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.Plugin;
import falcons.plugin.utils.PluginCall;

@Plugin(pluginID = "Dummy Plugin", versionID = "0.1")
public class DummyPlugin extends AbstractPlugin {

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

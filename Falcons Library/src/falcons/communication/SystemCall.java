package falcons.communication;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginCall;

public class SystemCall extends PluginCall {

	public SystemCall(AbstractPluginData pluginData, long destination) {
		super("SystemPlugin", pluginData, destination);
	}
}

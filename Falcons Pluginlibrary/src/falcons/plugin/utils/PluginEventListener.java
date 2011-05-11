package falcons.plugin.utils;

import java.util.EventListener;

// TODO: Should just expose the interface that PluginEventListener in falcons.client.pluginmanager will use.
public interface PluginEventListener extends EventListener{

	public void actionPerformed(PluginEvent p);
	
	public Object getData(PluginEvent p);
}
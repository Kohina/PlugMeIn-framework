package falcons.plugin.utils;

import java.util.EventListener;

public interface PluginEventListener extends EventListener{

	public void actionPerformed(PluginEvent p);
	
	public Object getData(PluginEvent p);
}
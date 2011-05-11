package falcons.pluginmanager;

import falcons.plugin.utils.PluginEvent;

//TODO Should act like both the MasterController and the Datacontroller
//at the same time, eg. actionPerfomed and getData should exist as methods here.
public class PluginEventListener implements falcons.plugin.utils.PluginEventListener {

	@Override
	public void actionPerformed(PluginEvent p) {
		
	}

	@Override
	public Object getData(PluginEvent p) {
		// TODO Auto-generated method stub
		return null;
	}
}
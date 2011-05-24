package falcons.plugin.alarmplugin.model;

import java.util.TimerTask;

import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.PluginEvent;
import falcons.plugin.PluginEvent.PluginEventType;
import falcons.plugin.alarmplugin.AlarmPlugin;
import falcons.plugin.PluginEventListener;

public class Alarm extends TimerTask implements Pluggable {
	
	private PluginCall call;
	private boolean repeat = false;
	
	public Alarm(PluginCall call, boolean repeat){
		this.call = call;
		this.repeat = repeat;
	}
	
	@Override
	public void run() {
		AlarmPlugin.send(call);
	}

	public boolean getRepeat() {
		return repeat;
	}

}

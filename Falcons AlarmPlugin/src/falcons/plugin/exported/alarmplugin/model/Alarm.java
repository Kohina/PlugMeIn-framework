package falcons.plugin.exported.alarmplugin.model;

import java.util.TimerTask;

import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.alarmplugin.AlarmPlugin;

public class Alarm extends TimerTask implements Pluggable {
	
	private PluginCall call;
	private boolean repeat = false;
	
	public Alarm(){
	}
	
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

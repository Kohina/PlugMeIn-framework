package pkj.no.tellstick.schedule;

import falcons.plugin.Pluggable;
import pkj.no.tellstick.device.TellstickDevice;

abstract public class ScheduleCallback implements Pluggable{
	
	public ScheduleCallback() {
		// TODO Auto-generated constructor stub
	}
	
	abstract public void onTrigger(TellstickDevice device);
	
}

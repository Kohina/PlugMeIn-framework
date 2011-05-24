package pkj.no.tellstick.device;

import java.util.ArrayList;

import falcons.plugin.Pluggable;

abstract public class DeviceChangeListener implements Pluggable{

	public DeviceChangeListener() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This event listener must be implemented.
	 * This is the method that will get called if we got requests.
	 */
	abstract public void onRequest(ArrayList<TellstickDevice> newDevices);
	
}

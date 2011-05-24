package falcons.plugin.exported.tellstickPlugin.model;

import java.io.Serializable;
import java.util.ArrayList;


import falcons.plugin.Pluggable;
import falcons.plugin.exported.pkj.no.tellstick.device.TellstickDevice;

public class TellstickLogic implements Pluggable, Serializable{
	
	TellstickModel model;
	
	public TellstickLogic() {
		// TODO Auto-generated constructor stub
	}
	
	public TellstickLogic(TellstickModel model) {
		this.model = model;
	}
	
	/**
	 * Method that returns all available Tellstick devices on the network. 
	 * @return An ArrayList containing all available Tellstick devices as {@link TellstickDevice}ckDevice objects.
	 */
	public ArrayList<TellstickDevice> getDevices() {
		ArrayList<TellstickDevice> devices = model.getDevices();
		return devices;
	}
	
	/**
	 * Method that turns all Tellstick devices in an ArrayList on.
	 * @param devices ArrayList containing all the {@link TellstickDevice} to turn on.
	 * @throws Exception 
	 */
	public void turnDevicesOn(ArrayList<TellstickDevice> devices) throws Exception {
		model.turnDevicesOn(devices);
	}
	
	/**
	 * Method that turns all Tellstick devices in an ArrayList off.
	 * @param devices ArrayList containing all the {@link TellstickDevice} to turn off.
	 * @throws Exception 
	 */
	public void turnDevicesOff(ArrayList<TellstickDevice> devices) throws Exception {
		model.turnDevicesOff(devices);
	}
	
	/**
	 * Method that turn a particular {@link TellstickDevice}e on.
	 * @param device The {@link TellstickDevice}Device to turn on. 
	 * @throws Exception
	 */
	public void turnDeviceOn(TellstickDevice device) throws Exception {
		model.turnDeviceOn(device);
	}
	
	/**
	 * Method that turns a particular {@link TellstickDevice}e off.
	 * @param device The {@link TellstickDevice} to turn off.
	 * @throws Exception
	 */
	public void turnDeviceOff(TellstickDevice device) throws Exception {
		model.turnDeviceOff(device);
	}
}
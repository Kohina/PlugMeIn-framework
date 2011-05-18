package falcons.plugin.exported.tellstickPlugin.model;

import java.io.Serizable;
import java.util.Observable;
import java.util.Observer;

import falcons.plugin.Pluggable;

public class TellstickModel extends Observable implements Pluggable, Serializable {

	public  TellstickModel() {
		// Nothing to do..
	}
	
	public ArrayList<TellstickDevice> getDevices() {
		return ArrayList<TellstickDevice> devices = TellstickDevice.getDevices();
	}
	
	public void turnDevicesOn(ArrayList<TellstickDevice> devices) {
		for(TellstickDevice device : devices) {
			if (device instanceof Device){
				// Cast to device so we can get the method.
				try{
					((Device) device).on();
				}catch(TellstickException e){
					System.out.println(e.getMessage()); // Prints error right from the tellstick if we get error. Forexample if tellstick is not found this will print " Tellstick not found ". 
				}
			}
		}
	}
	
	public void turnDevicesOff(ArrayList<TellstickDevice> devices) {
		for(TellstickDevice device : devices) {
			if(device intanceof Device) {
					try{
						((Device) device).off();
					}catch(TellstickException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
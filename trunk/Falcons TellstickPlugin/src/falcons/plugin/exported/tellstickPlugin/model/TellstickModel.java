package falcons.plugin.exported.tellstickPlugin.model;

import java.io.Serializable;
import java.util.*;
import pkj.no.tellstick.device.*;

import falcons.plugin.Pluggable;

public class TellstickModel extends Observable implements Pluggable, Serializable {

	private static final long serialVersionUID = 1L;

	public  TellstickModel() {
		// Nothing to do..
	}
	
	public ArrayList<TellstickDevice> getDevices() {
		ArrayList<TellstickDevice> devices = null;
		try {
			devices = TellstickDevice.getDevices();
		} catch (SupportedMethodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devices;
	}
	
	public void turnDevicesOn(ArrayList<TellstickDevice> devices) throws Exception {
		for(TellstickDevice device : devices) {
			if (device instanceof Device || device instanceof DimmableDevice){
				try{
					((Device) device).on();
				}catch(TellstickException e){
					throw new Exception(e.getMessage());
				}
			}
		}
	}
	
	public void turnDeviceOn(TellstickDevice device) throws Exception {
		if(device instanceof Device || device instanceof DimmableDevice) {
			try{
				((Device) device).on();
			}catch(TellstickException e) {
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public void turnDevicesOff(ArrayList<TellstickDevice> devices) throws Exception {
		for(TellstickDevice device : devices) {
			if(device instanceof Device || device instanceof DimmableDevice) {
					try{
						((Device) device).off();
					}catch(TellstickException e){
						throw new Exception(e.getMessage());
					}
				}
			}
		}
	
	public void turnDeviceOff(TellstickDevice device) throws Exception {
		if(device instanceof Device || device instanceof DimmableDevice) {
			try{
				((Device) device).off();
			}catch(TellstickException e) {
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public void dimDevice(TellstickDevice device, int level) throws Exception, IllegalArgumentException {
		if (level > 0 || level < 256) {
			if (device instanceof DimmableDevice) {
				try {
					((DimmableDevice) device).dim(level);
				} catch (TellstickException e) {
					throw new Exception(e.getMessage());
				}
			}
		} else {
			throw new IllegalArgumentException("Level has to be in the range 0-255");
		}
	}
	
	public void epilepsyOrDie(TellstickDevice device) throws TellstickException, InterruptedException {
		if (device instanceof Device) {
			((Device) device).off();
			for (int i = 0; i < 100; i++) {
				((Device) device).on();
				Thread.sleep(1000);
				((Device) device).off();
			}
		}
	}
}
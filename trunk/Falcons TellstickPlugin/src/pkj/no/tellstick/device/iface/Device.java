package pkj.no.tellstick.device.iface;

import falcons.plugin.Pluggable;
import pkj.no.tellstick.device.TellstickException;

/**
 * A generic device.
 * @author peec
 *
 */
public interface Device extends Pluggable{

	
	
	/**
	 * Turns on the device.
	 * @return 
	 */
	public void on() throws TellstickException;
	
	/**
	 * Turns off the device.
	 */
	public void off() throws TellstickException;
	
	
	/**
	 * Returns the name of the device.
	 * @return
	 */
	public String getType();
	
}

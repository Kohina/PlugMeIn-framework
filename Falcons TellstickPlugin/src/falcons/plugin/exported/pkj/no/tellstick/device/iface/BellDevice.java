package falcons.plugin.exported.pkj.no.tellstick.device.iface;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.pkj.no.tellstick.device.TellstickException;

/**
 * Devices that can perform the action bell.
 * Does not implement super interface Device since this should only perform the bell action.
 * @author peec
 *
 */
public interface BellDevice extends Pluggable{

	/**
	 * Bells the bell, meaning a sound will be played from the belling device.
	 * @throws TellstickException 
	 */
	public void bell() throws TellstickException;
	
	/**
	 * Returns the name of the device.
	 * @return
	 */
	public String getType();
	
}

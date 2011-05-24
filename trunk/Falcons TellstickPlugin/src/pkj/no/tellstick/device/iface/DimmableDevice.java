package pkj.no.tellstick.device.iface;

import falcons.plugin.Pluggable;
import pkj.no.tellstick.device.TellstickException;

/**
 * A device that can be dimmed.
 * @author peec
 *
 */
public interface DimmableDevice extends Device, Pluggable{

	/**
	 * Dims lights to a certain level.
	 */
	public void dim(int level) throws TellstickException;
	
	
}

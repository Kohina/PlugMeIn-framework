package pkj.no.tellstick.device;

import falcons.plugin.Pluggable;
import pkj.no.tellstick.JNA;


public class BellDevice extends TellstickDevice implements pkj.no.tellstick.device.iface.BellDevice, Pluggable{

	public BellDevice() throws Exception {
		super(null, null, null);
		// TODO Auto-generated constructor stub
	}
	
	public BellDevice(int deviceId) throws SupportedMethodsException {
		super(deviceId);
	}

	@Override
	public void bell() throws TellstickException {
		int status = JNA.CLibrary.INSTANCE.tdBell(getId());
		if (status != TELLSTICK_SUCCESS)throw new TellstickException(this, status);
	}
	
	public String getType(){
		return "Bell Device";
	}

}

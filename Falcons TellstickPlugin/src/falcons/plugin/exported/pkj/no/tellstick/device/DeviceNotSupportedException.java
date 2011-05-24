package falcons.plugin.exported.pkj.no.tellstick.device;

import falcons.plugin.Pluggable;

public class DeviceNotSupportedException extends Exception implements Pluggable{
	
	public DeviceNotSupportedException() {
		// TODO Auto-generated constructor stub
	}
	
	public DeviceNotSupportedException(String message){
		super(message);
	}
}

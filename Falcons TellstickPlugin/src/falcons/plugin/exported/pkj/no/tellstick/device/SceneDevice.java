package falcons.plugin.exported.pkj.no.tellstick.device;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.pkj.no.tellstick.JNA;

public class SceneDevice extends TellstickDevice implements Pluggable{

	public SceneDevice() throws SupportedMethodsException {
		super(0);
		// TODO Auto-generated constructor stub
	}
	
	public SceneDevice(int deviceId) throws SupportedMethodsException {
		super(deviceId);
	}
	
	/**
	 * Executes Scene.
	 * 
	 * @throws TellstickException
	 */
	public void execute() throws TellstickException{
		int status = JNA.CLibrary.INSTANCE.tdExecute(getId());
		if (status != TELLSTICK_SUCCESS)throw new TellstickException(this, status);
	}
	
	public String getType(){
		return "Scene";
	}
}

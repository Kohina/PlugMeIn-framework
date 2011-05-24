package pkj.no.tellstick.device;

import falcons.plugin.Pluggable;

public class SupportedMethodsException extends Exception implements Pluggable{
	
	public SupportedMethodsException() {
		// TODO Auto-generated constructor stub
	}
	
	public SupportedMethodsException(String message){
		super(message);
	}
}

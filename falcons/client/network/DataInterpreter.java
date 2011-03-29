package falcons.client.network;

public class DataInterpreter {

	private PluginModel model;
	
	public DataInterpreter(PluginModel model){
		this.model = model;
	}
	
	interpret(AbstractPluginCall call){
		String plugin = call.getPluginID;
		AbstractPluginData data = call.getPluginData;
	}
}

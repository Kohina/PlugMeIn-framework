package falcons.plugin.alarmplugin;

import java.util.Date;
import java.util.HashMap;

import javax.swing.JPanel;

import falcons.plugin.AbstractPlugin;
import falcons.plugin.AbstractPluginData;
import falcons.plugin.Plugin;
import falcons.plugin.PluginCall;
import falcons.plugin.alarmplugin.model.Alarm;
import falcons.plugin.alarmplugin.model.Clock;

@Plugin(pluginID = "Alarm", versionID = "1.0")
public class AlarmPlugin extends AbstractPlugin {

	@Override
	public void receiveCall(PluginCall call) {
		AbstractPluginData<HashMap<Date, Alarm>> data = call.getPluginData();
		Date key = (Date) data.getData().keySet().toArray()[0];
		
		if(data.getMethodID().equals("AddAlarm")){
			Clock.addAlarm(data.getData().get(key), key);
		}else if(data.getMethodID().equals("RemoveAlarm")){
			Clock.removeAlarm(data.getData().get(key));
		}else if(data.getMethodID().equals("Ring")){
			Clock.ring(data.getData().get(key));
		}else {
			System.out.println("There doesn't exist a method with that methodID.");
		}
	}

	@Override
	public JPanel getMainPanel() {
		// TODO Auto-generated method stub
		return null;
	}
}

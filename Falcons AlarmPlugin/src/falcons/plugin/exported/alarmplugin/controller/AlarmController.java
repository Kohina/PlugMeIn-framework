package falcons.plugin.exported.alarmplugin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.alarmplugin.AlarmPlugin;
import falcons.plugin.exported.alarmplugin.model.Alarm;
import falcons.plugin.exported.alarmplugin.model.Clock;
import falcons.plugin.exported.alarmplugin.view.AlarmMainPanel;

public class AlarmController implements ActionListener{

	private AlarmMainPanel view;
	private Clock clock;
	
	public AlarmController(){
	}
	
	public AlarmController(AlarmMainPanel view, Clock clock){
		this.view = view;
		this.clock = clock;
	}
	
	public void addAlarm(HashMap<Date, Alarm> pluginData){
		Object[] keys = pluginData.keySet().toArray();
		clock.addAlarm(pluginData.get(keys[0]), (Date)keys[0]);
	}
	
	public void removeAlarm(HashMap<Date, Alarm> pluginData){
		Object[] keys = pluginData.keySet().toArray();
		clock.removeAlarm(pluginData.get(keys[0]));
	}
	
	public void setAlarm(HashMap<Date, Alarm> data) {
		AbstractPluginData<HashMap<Date, Alarm>> pluginData = new AbstractPluginData<HashMap<Date, Alarm>>(
				"AddAlarm", "1.0", data);
		AlarmPlugin.send(new PluginCall("Alarm", pluginData, -1L));
	}
	
	public void ring(HashMap<Date, Alarm> pluginData){
		Object[] keys = pluginData.keySet().toArray();
		clock.ring(pluginData.get(keys[0]));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}

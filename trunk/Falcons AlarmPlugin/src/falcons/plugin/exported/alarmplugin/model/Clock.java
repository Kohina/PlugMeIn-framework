package falcons.plugin.exported.alarmplugin.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;

import javax.swing.JOptionPane;

import falcons.plugin.Pluggable;

public class Clock implements Pluggable {

	private static Timer timer;
	private static HashMap<Date, Alarm> alarms = new HashMap<Date, Alarm>();

	public Clock() {
		timer = new Timer();
	}

	public static void addAlarm(Alarm alarm, Date time) {
		alarms.put(time, alarm);
		timer.schedule(alarm, time);
	}

	public static void removeAlarm(Alarm alarm) {
		alarms.remove(alarm);
		timer.purge();

		Date[] dates = (Date[]) alarms.keySet().toArray();
		for (Date d : dates) {
			timer.schedule(alarms.get(d), d);
		}
	}

	public static void ring(Alarm alarm) {
		if (!alarm.getRepeat()) {
			removeAlarm(alarm);
		}
		JOptionPane.showMessageDialog(null, "Här kan det låta");
	}
}

package falcons.plugin.exported.pkj.no.tellstick.device;

import java.util.ArrayList;
import java.util.Collections;


import com.sun.jna.Pointer;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.pkj.no.tellstick.JNA;

/**
 * This listener will update / add objects automatically to a list of tellstick devices.
 * This will use the C# Library to find out if devices has changed anything.
 * 
 * It will make your list of devices updated all the time.
 * 
 * Remember to do remove() when exit of the application.
 * 
 * 
 * Usage can be:
 * 
		// Create a listener, to keep in track of live statuses.
		final TellstickDeviceListener listener = new TellstickDeviceListener(devices, new DeviceChangeListener(){
			public void onRequest(ArrayList<TellstickDevice> newDevices) {
				devices = newDevices;
				// Create async request.
				Application.display.syncExec(new Runnable() {
					public void run() {
						table.removeAll();
						printDevices();
					}
				});

			}			
		});

 * 
 * 
 * @author peec
 *
 */
public class TellstickDeviceListener extends Thread implements Runnable, Pluggable{

	public TellstickDeviceListener() {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<TellstickDevice> list;
	DeviceChangeListener changeListener;
	
	private boolean run = true;
	
	
	public TellstickDeviceListener(ArrayList<TellstickDevice> list, DeviceChangeListener changeListener){
		
		this.list = list;
		this.changeListener = changeListener;
		this.start();
	}
	
	
	
	public void remove(){
		run = false;
	}
	
	
	@Override
	public void run() {
		JNA.CLibrary.INSTANCE.tdInit();

		// / First register DeviceEvent callback!
		JNA.CLibrary.TDDeviceEvent fn = new JNA.CLibrary.TDDeviceEvent() {
			@Override
			public void invoke(int deviceId, int method, Pointer data,int callbackId, Pointer context) throws SupportedMethodsException {


				try{
					TellstickDevice ts = TellstickDevice.getDevice(deviceId);
					
					int idx = Collections.binarySearch(list, ts);
					if (idx > -1){
						list.set(idx, ts);
					}
					
					changeListener.onRequest(list);
				// The device is not supported.
				}catch(DeviceNotSupportedException e){
					e.printStackTrace();
				}

			}
		};

		JNA.CLibrary.INSTANCE.tdRegisterDeviceEvent(fn, null);

		// Do not exit!
		while (run) {
			
			try {
				Thread.sleep(100); // 100 ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}

	
	
}

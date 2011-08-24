package falcons.plugin;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import falcons.plugin.PluginEvent.PluginEventType;

@Plugin
public abstract class AbstractPlugin implements Serializable, Pluggable {

	private static PluginEventListener listener = null;
	
	/**
	 * Default Constructor. Should not be used.
	 */
	public AbstractPlugin() {
	}
	
	/**
	 * Receives a call from the server and checks what it is that it is supposed
	 * to do. Checks that the version of the plugin sending the call is the same
	 * as the receiving one and that there actually exists a method with that ID.
	 * 
	 * @param call
	 *            The PluginCall from the server.
	 */
	public abstract void receiveCall(PluginCall call);
	
	/**
	 * Has to return a JPanel that the client or server can add to it's Frame. 
	 * @return The main JPanel that of the plugin.
	 */
	public abstract JPanel getMainPanel();
	
	/**
	 * This method is called when the plugins are loaded so that we have a link 
	 * between the server/client and the plugin.
	 * @param p
	 * 			The PluginEventListener that will listen to the plugin.
	 */
 	public void addEventListener(PluginEventListener p){
		listener = p;
	}
 	
 	/**
 	 * This method is called when the plugin wants to send a PluginCall somewhere.
 	 * @param call
 	 * 				The PluginCall that is to be sent.
 	 */
 	public static void send(PluginCall call){
 		listener.actionPerformed(new PluginEvent(PluginEventType.SEND, call));
 	}
 	
 	/**
 	 * This method is called when a plugin needs to get data from the client or server.
 	 * @param e
 	 * 			A PluginEvent that tells the server/client what data it needs.
 	 * @return
 	 * 			Returns the data that the server/client sends back.
 	 */
 	public static Object getData(PluginEvent e){
 		return listener.getData(e);
 	}
}
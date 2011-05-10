package falcons.plugin;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import falcons.plugin.utils.PluginCall;
import falcons.plugin.utils.PluginEventListener;

@Plugin
public abstract class AbstractPlugin implements Serializable, Pluggable {

	private PluginEventListener listener = null;
	
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
	
	public abstract JPanel getMainPanel();
	
	// TODO: edit
	public void addEventListener(PluginEventListener p){
		listener = p;
	}
}
package falcons.plugin.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;

//TODO Implement in the same type of way as ClientEvent, to be used by PluginEventListener
// Should inclued commands such as SEND and GET_<DATA>.
// F�rmodligen helt fel, jag ger upp lite nu d� jag inte riktigt f�rst�r vad jag ska g�ra
public class PluginEvent {
	
	private ObjectOutputStream out;

	/**
	 * Sends a PluginCall to the connected client. Takes the PluginCall as a
	 * parameter.
	 * 
	 * @param call
	 *            The PluginCall which should be sent to the client.
	 * @throws IOException
	 */
	public void send(PluginCall call) {
		try {
			out.writeObject(call);
		} catch (IOException e) {
			System.err.print("Could not write to the output stream.");
		}
	}
}
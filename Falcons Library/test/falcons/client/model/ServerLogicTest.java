package falcons.client.model;

import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import falcons.utils.ClientInfo;

public class ServerLogicTest {

	long id = 123456789L;
	String name = "test";
	HashMap<String, String> map = new HashMap();
	boolean added = false;
	
	@Test
	public void testAddClientLongStringHashMapOfStringString() {
		ServerLogic serverlogic = new ServerLogic();
		map.put("2", "two");
	    map.put("4", "four" );
		
		serverlogic.addClient(id, name, map);
		
		if(serverlogic.getClients().size() > 0){
			added = true;
		}
		Assert.assertTrue(added);
	}
}
package falcons.utils;

import java.util.*;

public class ClientTree {
	private HashMap<Long, HashMap<String, String>> clientTree;
	
	public ClientTree() {
		
	}
	
	public ClientTree(Set<Long> clients) {
		Iterator<Long> iterator = clients.iterator();
		
		while(iterator.hasNext()) {
			clientTree.put(iterator.next(), null);
		}
	}
	
	public ClientTree(Set<Long> clients, HashMap<String, String> plugins) {
		Iterator<Long> iterator = clients.iterator();
		
		clientTree.put(iterator.next(), plugins);
		
		while(iterator.hasNext()) {
			clientTree.put(iterator.next(), null);
		}
	}
	
	public ClientTree(ClientTree clientTree) {
		this.clientTree.putAll(clientTree.getTree());
	}
	
	public void add(long id, HashMap<String, String> plugins) {
		clientTree.put(id, plugins);
	}
	
	public void add(long id) {
		clientTree.put(id, null);
	}
	
	public Iterator<Long> iterator() {
		return clientTree.keySet().iterator();
	}
	
	public Iterator<String> iterator(long id) {
		return clientTree.get(id).values().iterator();
	}
	
	private HashMap<Long, HashMap<String, String>> getTree() {
		return clientTree;
	}
}

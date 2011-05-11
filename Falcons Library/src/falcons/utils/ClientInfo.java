package falcons.utils;

public class ClientInfo {
	private long id;
	private String name;
	
	public ClientInfo(long id, String name) {
		this.id = id;
		this.name = new String(name);
	}
	
	public long getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}

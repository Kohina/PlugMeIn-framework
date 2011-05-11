package falcons.client;

public class Main {

	private static ClientImpl client;

	public static void main(String args[]) {
		client = new ClientImpl();
		client.run();
	}

}

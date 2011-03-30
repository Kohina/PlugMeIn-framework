package falcons.server.network;


public class ConnectionThread extends Thread{

	private ServerSocket socket = null;
	
	/*
	 *Contructor that sets the instace variable
	 * 
	 */
	public ConnectionThread(ServerSocket socket){
		this.socket = socket;
	}
	
	@Override
	public void run() {
		Socket clientSocket = null;
		while(){
			clientSocket = socket.accept();
		}
	}
}

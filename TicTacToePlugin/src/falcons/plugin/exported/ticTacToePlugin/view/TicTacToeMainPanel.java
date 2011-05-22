package falcons.plugin.exported.ticTacToePlugin.view;

public class TicTacToeMainPanel {
	
	private static TicTacToeMainPanel instance = null;
	
	// TODO: possible wrong here
	public static TicTacToeMainPanel getInstance(){
		if(instance == null){
			instance = new TicTacToeMainPanel();
		}
		return instance;
	}
}

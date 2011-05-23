package falcons.plugin.exported.ticTacToePlugin.controller;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeController implements Pluggable{

	private TicTacToeMainPanel view;
	
	public TicTacToeController(TicTacToeMainPanel view) {
		this.view = view;
	}
	
	public void played(int i){
		
	}
}

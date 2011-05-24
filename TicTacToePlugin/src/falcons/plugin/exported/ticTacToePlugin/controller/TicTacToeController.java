package falcons.plugin.exported.ticTacToePlugin.controller;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.model.TicTacToeLogic;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeController implements Pluggable{

	private TicTacToeMainPanel view;
	private TicTacToeLogic logic;
	
	public TicTacToeController(){
		
	}
	
	public TicTacToeController(TicTacToeMainPanel view, TicTacToeLogic logic) {
		this.view = view;
		this.logic = logic;
	}
	
	public void turn(int i, boolean b){
		logic.turn(i, b);
	}
}

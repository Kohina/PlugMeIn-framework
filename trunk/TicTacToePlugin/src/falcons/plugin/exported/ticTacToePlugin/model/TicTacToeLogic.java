package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;

import falcons.plugin.Pluggable;

public class TicTacToeLogic implements Pluggable, Serializable{

	TicTacToeModel model;
	
	public TicTacToeLogic(TicTacToeModel model){
		this.model = model;
	}
}

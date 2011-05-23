package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;

import falcons.plugin.Pluggable;

public class TicTacToeLogic implements Pluggable, Serializable{

	TicTacToeModel model;
	
	public TicTacToeLogic(TicTacToeModel model){
		this.model = model;
	}
	
	public void turn(int i, boolean b){
		if(b){
			model.changeO(i);
		}
		else{
			model.changeX(i);
		}
		
	}
}

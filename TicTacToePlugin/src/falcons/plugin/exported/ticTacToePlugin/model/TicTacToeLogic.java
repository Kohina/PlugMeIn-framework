package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;

import javax.print.attribute.standard.Destination;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import falcons.plugin.AbstractPluginData;
import falcons.plugin.Pluggable;
import falcons.plugin.PluginCall;
import falcons.plugin.exported.TicTacToePlugin;

public class TicTacToeLogic implements Pluggable, Serializable{
	
	private TicTacToeModel model;
	private boolean win = false;
	private boolean fullBoard = true;
	private String winner = null;
	private JButton[] board;
	private boolean me = false;
	private boolean isX = true;
	
	public TicTacToeLogic(){
		
	}
	
	public TicTacToeLogic(TicTacToeModel model){
		this.model = model;
		board = model.getBoard();
	}
		
	public void change(int i) {
		if(me){
			if(model.getBoard()[i].getText() == "" && isX){
				model.changeX(i);
				me = false;
			}
			else if(model.getBoard()[i].getText() == "" && !isX){
				model.changeO(i);
				me = false;
			}
			AbstractPluginData<Integer> pluginData = new AbstractPluginData<Integer>("turn", "0.1", i);
			TicTacToePlugin.send(new PluginCall("TicTacToePlugin", pluginData, getDestination(), 0));
			System.out.println("turn sent");
		}
		else if(model.getBoard()[i].getText() == "" && !me && isX){
			model.changeO(i);
		}
		else if(model.getBoard()[i].getText() == "" && !me && !isX){
			model.changeX(i);
		}
		win();
	}
	
	public void setMe(boolean b){
		me = b;
	}
	
	public boolean getMe(){
		return me;
	}
	
	public void setIsX(boolean b){
		isX = b;
	}
	
	public int getDestination(){
		return model.getDestination();
	}
	
	public void setDestination(int dest){
		model.setDestination(dest);
	}
	
	public void win(){
		
		int[][] winCombinations = new int[][] {
			    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
			    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
			    {0, 4, 8}, {2, 4, 6}             //diagonal wins
		};
		
		for(int i=0; i<=7; i++){
		    if( board[winCombinations[i][0]].getText().equals(board[winCombinations[i][1]].getText()) && 
		        board[winCombinations[i][1]].getText().equals(board[winCombinations[i][2]].getText()) && 
		        board[winCombinations[i][0]].getText() != ""){
		        win = true;
		        winner = board[winCombinations[i][0]].getText();
		    }
		}
		if(win){
			JOptionPane.showMessageDialog(null, winner + " har vunnit!");
		}
		restart();
	}
	
	public void restart(){
		for(int i=0; i<9; i++){
			if(board[i].getText() == ""){
				fullBoard = false;
				break;
			}
			else{
				fullBoard = true;
			}
		}
		if(win || fullBoard){
			if(win){
				fullBoard = false;
			}
			else if(fullBoard){
				JOptionPane.showMessageDialog(null, "Oavgjort!");
			}
			model.reset();
			win = false;
			fullBoard = true;
		}
	}
	
	public void reset(){
		setMe(false);
		setIsX(true);
		model.reset();
	}
}

package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.Observable;
import javax.swing.*;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeModel implements Pluggable, Serializable{
	
	private JButton buttons[] = new JButton[9];
	
	public TicTacToeModel(){
		
	}
	
	public void changeO(int i){
		buttons[i].setText("O");
		TicTacToeMainPanel.update(buttons.clone());
	}
	
	public void changeX(int i){
		buttons[i].setText("X");
		TicTacToeMainPanel.update(buttons.clone());
	}
	
	public JButton[] getBoard(){
		return buttons;
	}
	
	public void reset(){
		for(int i=0; i<9; i++){
			buttons[i].setText(null);
		}
		TicTacToeMainPanel.update(buttons.clone());
	}
}

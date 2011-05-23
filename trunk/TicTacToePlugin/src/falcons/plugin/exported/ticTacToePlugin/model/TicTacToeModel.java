package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.Observable;
import javax.swing.*;
import falcons.plugin.Pluggable;

public class TicTacToeModel extends Observable implements Pluggable, Serializable{
	
	private JButton buttons[] = new JButton[9];
	
	public TicTacToeModel(){
		
	}
	
	public void changeO(int i){
		buttons[i].setText("O");
	}
	
	public void changeX(int i){
		buttons[i].setText("X");
	}
	
	public JButton[] getBoard(){
		return buttons;
	}
}

package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.Observable;
import javax.swing.*;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeModel extends Observable implements Pluggable, Serializable{
	
	private JButton buttons[];
	
	public TicTacToeModel(){
	}
	
	public TicTacToeModel(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void changeO(int i){
		buttons[i].setText("O");
		setChanged();
		notifyObservers(buttons.clone());
	}
	
	public void changeX(int i){
		buttons[i].setText("X");
		setChanged();
		notifyObservers(buttons.clone());
	}
	
	public JButton[] getBoard(){
		return buttons;
	}
	
	public void reset(){
		for(int i=0; i<9; i++){
			buttons[i].setText(null);
		}
		setChanged();
		notifyObservers(buttons.clone());
	}
}

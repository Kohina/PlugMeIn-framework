package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.Observable;
import javax.swing.*;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeModel extends Observable implements Pluggable, Serializable{
	
	private JButton buttons[];
	private long destination;
	private Icon mario, luigi;
	
	public TicTacToeModel(){
	}
	
	public TicTacToeModel(JButton[] buttons) {
		this.buttons = buttons;
		mario = new ImageIcon("ticTacToePlugin/mario.jpg");
	}

	public void changeO(int i){
		buttons[i].setIcon(mario);
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
	
	public long getDestination(){
		return destination;
	}
	
	public void setDestination(long dest){
		destination = dest;
	}
	
	public void reset(){
		for(int i=0; i<9; i++){
			buttons[i].setText("");
		}
		setChanged();
		notifyObservers(buttons.clone());
	}
}

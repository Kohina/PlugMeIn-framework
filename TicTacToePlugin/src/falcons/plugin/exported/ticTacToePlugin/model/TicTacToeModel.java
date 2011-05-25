package falcons.plugin.exported.ticTacToePlugin.model;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.Serializable;
import java.util.Observable;
import javax.swing.*;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.view.TicTacToeMainPanel;

public class TicTacToeModel extends Observable implements Pluggable, Serializable{
	
	private JButton buttons[];
	private long destination;
	
	public TicTacToeModel(){
	}
	
	public TicTacToeModel(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void changeO(int i){
		buttons[i].setForeground(Color.black);
		buttons[i].setFont(new Font("Verdana", Font.BOLD, 58));
		buttons[i].setText("O");
		setChanged();
		notifyObservers(buttons.clone());
	}
	
	public void changeX(int i){
		buttons[i].setForeground(Color.red);
		buttons[i].setFont(new Font("Verdana", Font.BOLD, 58));
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

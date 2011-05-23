package falcons.plugin.exported.ticTacToePlugin.model;

import java.io.Serializable;
import java.util.Observable;
import javax.swing.*;
import falcons.plugin.Pluggable;

public class TicTacToeModel extends Observable implements Pluggable, Serializable{
	
	private JButton buttons[] = new JButton[9];
	
	public void changeO(int i){
		
	}
	
	public void changeX(int i){
		
	}
}

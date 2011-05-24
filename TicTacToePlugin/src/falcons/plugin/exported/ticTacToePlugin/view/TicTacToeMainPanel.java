package falcons.plugin.exported.ticTacToePlugin.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;

public class TicTacToeMainPanel extends JPanel implements Pluggable, ActionListener{

	private static JButton buttons[] = new JButton[9];
	private TicTacToeController controller;
	
	public TicTacToeMainPanel(){
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI(){
		this.setLayout(new GridLayout(3,3));
		this.setSize(600, 600);
		
		for(int i=0; i<=8; i++){
		    buttons[i] = new JButton();
		    this.add(buttons[i]);
		    buttons[i].addActionListener(this);
		}
	}
	
	public static void update(JButton[] b) {
		buttons = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]){
			controller.turn(0, true);
		}
		else if(e.getSource() == buttons[1]){
			controller.turn(1, true);
		}
		else if(e.getSource() == buttons[2]){
			controller.turn(2, true);
		}
		else if(e.getSource() == buttons[3]){
			controller.turn(3, true);
		}
		else if(e.getSource() == buttons[4]){
			controller.turn(4, true);
		}
		else if(e.getSource() == buttons[5]){
			controller.turn(5, true);
		}
		else if(e.getSource() == buttons[6]){
			controller.turn(6, true);
		}
		else if(e.getSource() == buttons[7]){
			controller.turn(7, true);
		}
		else if(e.getSource() == buttons[8]){
			controller.turn(8, true);
		}
		else if(e.getSource() == buttons[9]){
			controller.turn(9, true);
		}
		else{
			System.out.print("Invalid button");
		}
	}
	
	public void addActionListener(TicTacToeController cont){
		controller = cont;
	}
}
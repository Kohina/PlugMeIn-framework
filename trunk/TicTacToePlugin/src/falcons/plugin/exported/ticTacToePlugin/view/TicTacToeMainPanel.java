package falcons.plugin.exported.ticTacToePlugin.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;

public class TicTacToeMainPanel extends JPanel implements Observer, Pluggable, ActionListener{

	private JButton buttons[] = new JButton[9];
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]){
			controller.turn(0);
		}
		else if(e.getSource() == buttons[1]){
			controller.turn(1);
		}
		else if(e.getSource() == buttons[2]){
			controller.turn(2);
		}
		else if(e.getSource() == buttons[3]){
			controller.turn(3);
		}
		else if(e.getSource() == buttons[4]){
			controller.turn(4);
		}
		else if(e.getSource() == buttons[5]){
			controller.turn(5);
		}
		else if(e.getSource() == buttons[6]){
			controller.turn(6);
		}
		else if(e.getSource() == buttons[7]){
			controller.turn(7);
		}
		else if(e.getSource() == buttons[8]){
			controller.turn(8);
		}
		else if(e.getSource() == buttons[9]){
			controller.turn(9);
		}
		else{
			System.out.print("Invalid button");
		}
	}
	
	public void addActionListener(TicTacToeController cont){
		controller = cont;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		buttons = (JButton[]) arg1;
	}
	
	public JButton[] getButtons(){
		return buttons.clone();
	}
}
package falcons.plugin.exported.ticTacToePlugin.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import falcons.plugin.Pluggable;

public class TicTacToeMainPanel extends JPanel implements Observer, Pluggable, ActionListener{

	private JButton buttons[] = new JButton[9];
	
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
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}

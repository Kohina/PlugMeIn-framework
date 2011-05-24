package falcons.plugin.exported.ticTacToePlugin.view;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;
import falcons.plugin.exported.ticTacToePlugin.model.ConnectedClientsLogic;

public class TicTacToeMainPanel extends JPanel implements Observer, Pluggable, ActionListener{

	private JButton buttons[] = new JButton[9];
	private JPanel gamePanel, connectPanel;
	private JList clientList;
	private JButton go, update;
	private TicTacToeController controller;
	private ConnectedClientsLogic logic;
	
	public TicTacToeMainPanel(){
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI(){
		this.setLayout(new CardLayout());
		this.setSize(600, 600);
		
		connectPanel = new JPanel();
		connectPanel.setLayout(new GridLayout(2,1));
		
		ListModel clientListModel = new DefaultComboBoxModel(logic.getClients().keySet().toArray());
		clientList = new JList();
		connectPanel.add(clientList, new GridBagConstraints(0, 0, 1, 4, 0.0,0.0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0,0));
		clientList.setModel(clientListModel);
		
		update.setText("Update list");
		update.addActionListener(this);
		connectPanel.add(update);
		
		go.setText("Play");
		go.addActionListener(this);
		connectPanel.add(go);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		
		for(int i=0; i<=8; i++){
		    buttons[i] = new JButton();
		    gamePanel.add(buttons[i]);
		    buttons[i].addActionListener(this);
		}
		
		this.add(connectPanel);
		this.add(gamePanel);
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
		else if(e.getSource() == go){
			controller.connect(clientList.getSelectedIndex());
		}
		else if(e.getSource() == update){
			controller.updateClients();
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
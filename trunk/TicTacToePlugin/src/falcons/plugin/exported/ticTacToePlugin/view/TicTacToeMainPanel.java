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
	private CardLayout m;
	private TicTacToeController controller;
	private ConnectedClientsLogic logic;
	
	public TicTacToeMainPanel(){
		initGUI();
		this.setVisible(true);
	}
	
	private void initGUI(){
		m = new CardLayout();
		this.setLayout(m);
		this.setSize(600, 600);
		
		connectPanel = new JPanel();
		
		clientList = new JList();
		clientList.setSize(600,200);
		connectPanel.add(clientList);
		
		update = new JButton("Update list");
		update.addActionListener(this);
		connectPanel.add(update);
		
		go = new JButton("Play");
		go.addActionListener(this);
		connectPanel.add(go);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		
		for(int i=0; i<=8; i++){
		    buttons[i] = new JButton();
		    gamePanel.add(buttons[i]);
		    buttons[i].addActionListener(this);
		}
		
		this.add("connect", connectPanel);
		this.add("game", gamePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]){
			controller.changeO(0);
		}
		else if(e.getSource() == buttons[1]){
			controller.changeO(1);
		}
		else if(e.getSource() == buttons[2]){
			controller.changeO(2);
		}
		else if(e.getSource() == buttons[3]){
			controller.changeO(3);
		}
		else if(e.getSource() == buttons[4]){
			controller.changeO(4);
		}
		else if(e.getSource() == buttons[5]){
			controller.changeO(5);
		}
		else if(e.getSource() == buttons[6]){
			controller.changeO(6);
		}
		else if(e.getSource() == buttons[7]){
			controller.changeO(7);
		}
		else if(e.getSource() == buttons[8]){
			controller.changeO(8);
		}
		else if(e.getSource() == go){
			controller.connect(clientList.getSelectedIndex());
			m.show(this, "game");
		}
		else if(e.getSource() == update){
			controller.updateClients();
			
			if (!controller.getClients().isEmpty()) {
				ListModel clientListModel = new DefaultComboBoxModel(controller.getClients().keySet().toArray());
				clientList.setModel(clientListModel);
			} else {
				System.out.println("There are no other clients to play against");
			}
		}
		else{
			System.out.print("Invalid button");
		}
	}
	
	public void newGame(){
		m.show(this, "game");
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
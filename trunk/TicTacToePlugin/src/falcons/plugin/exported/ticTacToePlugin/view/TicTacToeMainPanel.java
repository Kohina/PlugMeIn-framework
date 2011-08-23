package falcons.plugin.exported.ticTacToePlugin.view;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.*;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.ticTacToePlugin.controller.TicTacToeController;

public class TicTacToeMainPanel extends JPanel implements Observer, Pluggable, ActionListener{

	private JButton[] buttons;
	private JPanel gamePanel, connectPanel, gameContentPanel, optionsPanel;
	private JList clientList;
	private JLabel turn;
	private JButton go, update, endGame;
	private int[] key;
	private CardLayout m;
	private TicTacToeController controller;
	
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
		
		gameContentPanel = new JPanel();
		gameContentPanel.setLayout(new FlowLayout());
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		gamePanel.setSize(600, 600);
		optionsPanel = new JPanel();
		optionsPanel.setLayout(new FlowLayout());
		endGame = new JButton("End game");
		endGame.setSize(200, 50);
		endGame.addActionListener(this);
		turn = new JLabel();
		turn.setSize(300, 50);
		optionsPanel.add(turn);
		optionsPanel.add(endGame);
		gameContentPanel.add(gamePanel);
		gameContentPanel.add(optionsPanel);
		
		buttons = new JButton[9];
		              
		for(int i=0; i<=8; i++){
		    buttons[i] = new JButton();
		    gamePanel.add(buttons[i]);
		    buttons[i].addActionListener(this);
		}
		
		this.add("connect", connectPanel);
		this.add("game", gameContentPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == go){
			controller.connect(key[clientList.getSelectedIndex()]);
			setTurnText(false);
			m.show(this, "game");
		}
		else if(e.getSource() == update){
			controller.updateClients();
		}
		else if(e.getSource() == endGame){
			controller.reset(true);
			m.show(this, "connect");
		}
		if(controller.getMe()){
			if(e.getSource() == buttons[0]){
				controller.change(0);
			}
			else if(e.getSource() == buttons[1]){
				controller.change(1);
			}
			else if(e.getSource() == buttons[2]){
				controller.change(2);
			}
			else if(e.getSource() == buttons[3]){
				controller.change(3);
			}
			else if(e.getSource() == buttons[4]){
				controller.change(4);
			}
			else if(e.getSource() == buttons[5]){
				controller.change(5);
			}
			else if(e.getSource() == buttons[6]){
				controller.change(6);
			}
			else if(e.getSource() == buttons[7]){
				controller.change(7);
			}
			else if(e.getSource() == buttons[8]){
				controller.change(8);
			}
			else{
				System.out.print("Invalid button");
				return;
			}
			setTurnText(false);
		}
	}
	
	public void newGame(){
		setTurnText(true);
		m.show(this, "game");
	}
	
	public void connectView(){
		m.show(this, "connect");
	}
	
	public void setTurnText(boolean b){
		if(b){
			turn.setText("It's your turn");
		}
		else{
			turn.setText("It's not your turn");
		}
	}
	
	private void updateList(){
		if (!controller.getClients().isEmpty()) {
			Set<Integer> keys = controller.getClients().keySet();
			key = new int[keys.size()];
			String[] name = new String[keys.size()];
			int i = 0;
			for(Integer k: keys){
				key[i] = k;
				name[i] = controller.getClients().get(k);
				i++;
			}
			ListModel clientListModel = new DefaultComboBoxModel(name);
			clientList.setModel(clientListModel);
		} else {
			System.out.println("There are no other clients to play against");
		}
	}
	
	public void addActionListener(TicTacToeController cont){
		controller = cont;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 == null){
			updateList();
		}
		else if(arg1 != null){
			buttons = (JButton[]) arg1;
		}
	}
	
	public JButton[] getButtons(){
		return buttons.clone();
	}
}
package falcons.plugin.exported.tellstickPlugin.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import falcons.plugin.Pluggable;
import falcons.plugin.exported.tellstickPlugin.view.TellstickMainPanel;

public class TellstickController extends AbstractAction implements Pluggable{

	private TellstickMainPanel view;
	
	public TellstickController() {
		// TODO Auto-generated constructor stub
	}
	
	public  TellstickController(TellstickMainPanel view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

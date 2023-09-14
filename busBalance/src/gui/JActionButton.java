package gui;

import java.awt.Color;
import javax.swing.JButton;

public class JActionButton extends JButton{
	private ButtonAction action;
	
	public JActionButton(ButtonAction pAction, String pLabel) {
		super(pLabel);
		this.setBackground(Color.LIGHT_GRAY);
		action = pAction;
	}

}

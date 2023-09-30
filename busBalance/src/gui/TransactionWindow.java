package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TransactionWindow extends JFrame{
	
	/*
	 * un sistema como de caja donde se le puede cargar X monto a dicho usuario para viajes
	 */
	
	public TransactionWindow() {
		setTitle("Recargas");
        setSize(600, 350); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocation(200, 300);
        
        JLabel labelTitle = new JLabel("Recargas");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 28)); 
        labelTitle.setForeground(Color.BLACK); 
        labelTitle.setBounds(240, 30, 150, 40);
        
        Integer[] options = {1000, 2000, 5000,6000, 10000};
        JComboBox<Integer> paymentBox = new JComboBox<>(options);
        paymentBox.setBounds(230, 80, 150, 40);
        
        JActionButton payButton = new JActionButton(ButtonAction.PAY,"Recargar monto");
        payButton.setBounds(218, 220, 180, 70);
        
        getContentPane().setLayout(null);
        getContentPane().add(labelTitle);
        getContentPane().add(paymentBox);
        getContentPane().add(payButton);
	}

}

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.TransactionController;
import jsonConfig.UserManager;

public class TransactionWindow extends JFrame{
	
	private int IdToLookfor;
	

	public TransactionWindow(UserManager pUserManager) {
		TransactionController tranControl = new TransactionController();
		
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
        
        payButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selection = (int) paymentBox.getSelectedItem();
                System.out.println("tranWindow"+ pUserManager.getUsersRegistered().elementAt(1).getId());
                tranControl.addDeposit(selection, pUserManager, IdToLookfor);	
            }
        });
        
        getContentPane().setLayout(null);
        getContentPane().add(labelTitle);
        getContentPane().add(paymentBox);
        getContentPane().add(payButton);
	}

	public void setIdToLookfor(int idToLookfor) {
		IdToLookfor = idToLookfor;
	}

}

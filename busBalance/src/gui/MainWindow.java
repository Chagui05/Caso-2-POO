package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import Controller.HistoryController;
import jsonConfig.UserManager;

public class MainWindow extends JFrame {
	private TransactionWindow TransactionWindow;
	private HistoryWindow HistoryWindow;
	private JActionButton buttonShowTransactionWindow;
	private JActionButton buttonShowHistoryWindow;
	private JTextField userIDToConsult;
	private UserManager usermanager;
	private HistoryController historyController;
	
	public MainWindow(UserManager pUsermanager) {
		historyController = new HistoryController();
		this.usermanager = pUsermanager;
		System.out.println("creando ventana");
		
		/*
		 * creación de un usuario basado en la identificación del usuario
		 */

		setTitle("Recarga Saldo");
        setSize(895, 405); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
      //parte de creacion de usuario  
        
        JLabel labelCreateUser = new JLabel("Crear Usuario");
        labelCreateUser.setFont(new Font("Arial", Font.BOLD, 18)); 
        labelCreateUser.setForeground(Color.BLACK); 
        labelCreateUser.setBounds(90, 30, 150, 40);

        JTextField userID = new JTextField();
        userID.setBounds(40, 100, 220, 30);
        JTextField userName = new JTextField();
        userName.setBounds(40, 160, 220, 30);

        this.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
            	userID.setText("escriba aqui su ID");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
            	userName.setText("escriba aqui su Nombre");
            }
        });
        
        JActionButton buttonCreateUSer = new JActionButton(ButtonAction.CREATE_USER,"Crear");
        buttonCreateUSer.setBounds(65, 210, 170, 60);

        ImageIcon imageIcon = new ImageIcon("blackLine.png");
        JLabel imageBlackLine = new JLabel(imageIcon);
        imageBlackLine.setBounds(300, 18, 30, 330);
        
        getContentPane().setLayout(null);
        getContentPane().add(labelCreateUser);
        getContentPane().add(imageBlackLine);
        getContentPane().add(buttonCreateUSer);
        getContentPane().add(userName);
        getContentPane().add(userID);
        
        //parte para llamar a history y transaction
        
        
        JLabel userToConsult = new JLabel("Usuario a Consultar");
        userToConsult.setFont(new Font("Arial", Font.BOLD, 18)); 
        userToConsult.setForeground(Color.BLACK); 
        userToConsult.setBounds(515, 30, 200, 40);
        
        userIDToConsult = new JTextField();
        userIDToConsult.setBounds(500, 70, 202, 30);
        
        ImageIcon imageIcon2 = new ImageIcon("blackLine.png");
        JLabel imageBlackLine2 = new JLabel(imageIcon2);
        imageBlackLine2.setBounds(520, 110, 150, 230);
        
        buttonShowTransactionWindow = new JActionButton(ButtonAction.SHOW_HISTORY,"Recargas");
        buttonShowTransactionWindow.setBounds(370, 210, 170, 80);
        
        buttonShowHistoryWindow = new JActionButton(ButtonAction.OPEN_PAYMENT,"Mostar Historial");
        buttonShowHistoryWindow.setBounds(650, 210, 170, 80);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
            	userIDToConsult.setText("Escriba ID a consultar");
            }
        });
        
        // action listener de los botones
        buttonShowHistoryWindow.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id = userIDToConsult.getText();
                int IdInt = Integer.parseInt(Id);
  
                historyController.proccesTask(IdInt, HistoryWindow, usermanager);
                System.out.println("Trabajando con: " + IdInt);
            }
        });
        
        buttonShowTransactionWindow.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = userIDToConsult.getText();
                transWindow();
                System.out.println("Trabajando con: " + text);
            }
        });
        
        //los metodos son provisionales, solo los uso para poder invocar las otras ventanas
        
        
        TransactionWindow = new TransactionWindow();
        HistoryWindow = new HistoryWindow();
        
        getContentPane().add(imageBlackLine2);
        getContentPane().add(userToConsult);
        getContentPane().add(userIDToConsult);
        getContentPane().add(buttonShowTransactionWindow);
        getContentPane().add(buttonShowHistoryWindow);
	}
	private void transWindow() {
		TransactionWindow.setVisible(true);
	}
	private void hisWindow() {
		HistoryWindow.setVisible(true);
	}
	

}

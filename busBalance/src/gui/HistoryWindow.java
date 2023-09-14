package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class HistoryWindow extends JFrame{
	
	/*
	 * metamos le historial de pagos hechos, que se vean los refills y los viajes de la persona
	 */

	public HistoryWindow() {
		setTitle("Historial");
        setSize(600, 500); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocation(200, 300);
        
        JLabel labelTitle = new JLabel("Historial");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 28)); 
        labelTitle.setForeground(Color.BLACK); 
        labelTitle.setBounds(240, 30, 150, 40);
        
        JTextArea historyArea = new JTextArea();
        historyArea.setLineWrap(true); // Enable line wrapping
        historyArea.setWrapStyleWord(true); // Wrap at word boundaries

        Rectangle textAreaBounds = new Rectangle(120, 80, 330, 350);
        historyArea.setBounds(textAreaBounds);
      
        this.addWindowListener(new WindowAdapter() {
        	
            public void windowActivated(WindowEvent e) {
            	historyArea.setText("EN ESTE ESPACIO SE MOSTRARA EN EL FUTURO EL HISTORIAL");
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(labelTitle);
        getContentPane().add(historyArea);  
	}

}

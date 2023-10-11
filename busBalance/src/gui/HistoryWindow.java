package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class HistoryWindow extends JFrame{
	
	/*
	 * metamos le historial de pagos hechos, que se vean los refills y los viajes de la persona
	 */
	private Vector<String> viajesHechos;
	private Vector<String> depositosHechos;
	private JList<String> tripList;
	private JList<String> depositList;

	public HistoryWindow() {
		setTitle("Historial");
        setSize(750, 500); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocation(200, 300);
        
        this.viajesHechos = new Vector<>();
        this.depositosHechos = new Vector<>();
        
        JLabel labelTitle = new JLabel("Historial");
        labelTitle.setFont(new Font("Arial", Font.BOLD, 28)); 
        labelTitle.setForeground(Color.BLACK); 
        labelTitle.setBounds(320, 30, 150, 40);
        
        JLabel depositSubTitle = new JLabel("Depósitos hechos");
        depositSubTitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        depositSubTitle.setForeground(Color.BLACK); 
        depositSubTitle.setBounds(80, 70, 200, 40);
        
        depositList = new JList<>(depositosHechos);
        JScrollPane scrollPane = new JScrollPane(depositList);
        scrollPane.setBounds(50, 120, 200, 210);
        
        
        JLabel tripSubtitle = new JLabel("Viajes hechos");
        tripSubtitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        tripSubtitle.setForeground(Color.BLACK); 
        tripSubtitle.setBounds(530, 70, 150, 40);
        
        tripList = new JList<>(viajesHechos);
        JScrollPane scrollPane2 = new JScrollPane(tripList);
        scrollPane2.setBounds(490, 120, 200, 200);
        
        
        getContentPane().setLayout(null);
        getContentPane().add(labelTitle);
        getContentPane().add(depositSubTitle);
        getContentPane().add(tripSubtitle);
        getContentPane().add(scrollPane);
        getContentPane().add(scrollPane2);
	}

	

	public void setTripList(Vector<String> pTripList) {
		tripList.setListData(pTripList);
	}
	
	public void setDepositList(Vector<String> pDepositList) {
		depositList.setListData(pDepositList);
	}

}

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HistoryWindow extends JFrame{
	
	 private JTable table;
	 private Vector<String> columnNames;
	 private DefaultTableModel model; 
	 
	 public HistoryWindow() {
		    setTitle("Historial");
		    setSize(1000, 500);
		    setResizable(false);
		    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    setLocation(200, 300);

		    Vector<Vector<String>> userData = new Vector<Vector<String>>();
		    List<String> columnNamesList = Arrays.asList("id", "Descripcion", "Tipo", "Fecha", "Precio");
		    Vector<String> columnNames = new Vector<>(columnNamesList);
		    model = new DefaultTableModel(userData, columnNames);

		    JLabel labelTitle = new JLabel("Historial");
		    labelTitle.setFont(new Font("Arial", Font.BOLD, 28));
		    labelTitle.setForeground(Color.BLACK);

		    table = new JTable(model);
		    JScrollPane scroll = new JScrollPane(table);

		    getContentPane().setLayout(new BorderLayout());
		    getContentPane().add(labelTitle, BorderLayout.NORTH);
		    getContentPane().add(scroll, BorderLayout.CENTER);
		}

	public void setTable(Vector<Vector<String>> pHistory) {
		model.setRowCount(0);
		for(Vector<String> event : pHistory) {
			model.addRow(event);
		}
	}
}

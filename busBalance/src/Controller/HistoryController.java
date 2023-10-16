package Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;

import gui.HistoryWindow;
import jsonConfig.UserManager;
import modelo.Transaction;
import modelo.TransactionType;

public class HistoryController {
	private HistoryWindow HistoryWindow;
	
	public HistoryController() {
		// TODO Auto-generated constructor stub
	}
	public void proccesTask(String Id, HistoryWindow HistoryWindow, UserManager usermanager) {
		this.HistoryWindow = HistoryWindow;
		try {
			int IdInt = Integer.parseInt(Id);
			Vector<Transaction> history = usermanager.getUser(IdInt).getTransactions();
			HistoryWindow.setVisible(true);
			showHistory(history);
			System.out.println("Historial de: "+ usermanager.getUser(IdInt).getName());

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			if(!HistoryWindow.isVisible())
				System.out.println("usuario no econtrado");	
		}
	}
	
	public void showHistory(Vector<Transaction> history) {
	
		Vector<Vector<String>> historyEvents = new Vector<>();
		for (Transaction tran : history) {
			List<String> eventList = Arrays.asList(
			            String.valueOf(tran.getUserId()),
			            tran.getName(),
			            tran.getTransactionType().name(),
			            tran.getDate().toString(),
			            String.valueOf(tran.getAmount())
			        );
			
			Vector<String> event = new Vector<>(eventList);
			historyEvents.add(event);
		}
		HistoryWindow.setTable(historyEvents);
	}
		
}

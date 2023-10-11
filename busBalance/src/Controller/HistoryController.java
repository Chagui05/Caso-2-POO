package Controller;

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
	public void proccesTask(int Id, HistoryWindow HistoryWindow, UserManager usermanager) {
		this.HistoryWindow = HistoryWindow;
		try {
			Vector<Transaction> history = usermanager.getUser(Id).getTransactions();
			HistoryWindow.setVisible(true);
			System.out.println(Id+" con ruta "+history.get(0).getName());
			showHistory(history);

		} catch (NullPointerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			if(!HistoryWindow.isVisible())
				System.out.println("usuario no econtrado");	
		}
	}
	
	public void showHistory(Vector<Transaction> history) {
	
		Vector<String> viajesHechos = new Vector<>();
		Vector<String> depositosHechos = new Vector<>();
		
		for (Transaction tran : history) {
			if(tran.getTransactionType() == TransactionType.DEPOSIT ) {
				System.out.println("buscando depositos");
				depositosHechos.add(tran.getName());
				
			}
			else {
				System.out.println("buscando viajes");
				viajesHechos.add(tran.getName());	
			}
		}
		HistoryWindow.setTripList(viajesHechos);
		HistoryWindow.setDepositList(depositosHechos);
		
		
	}
		
}

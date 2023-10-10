package Controller;

import java.util.Vector;

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
		HistoryWindow.setVisible(true);
		this.HistoryWindow = HistoryWindow;
		
		System.out.println(Id);
		
		Vector<Transaction> history = usermanager.getUser(Id).getTransactions();
		
		showHistory(history);
	}
	
	public void showHistory(Vector<Transaction> history) {
		
		Vector<String> viajesHechos = new Vector<>();
		Vector<String> depositosHechos = new Vector<>();
		
		for (Transaction tran : history) {
			if(tran.getTransactionType() == TransactionType.DEPOSIT ) {
				depositosHechos.add(tran.getName());
				
			}
			else {
				viajesHechos.add(tran.getName());
				
			}
		}
		HistoryWindow.setDepositosHechos(depositosHechos);
		HistoryWindow.setViajesHechos(viajesHechos);
	}
}

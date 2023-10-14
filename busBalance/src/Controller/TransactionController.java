package Controller;

import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JOptionPane;

import gui.TransactionWindow;
import jsonConfig.UserManager;
import modelo.Deposit;
import modelo.Transaction;
import modelo.User;

public class TransactionController {
	private TransactionWindow transactionWIndow;
	private User user;

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}
	
	public void proccesTask(String Id, TransactionWindow pTransactionWIndow, UserManager pUserManager) {
		this.transactionWIndow = pTransactionWIndow;
		try {
			int IdInt = Integer.parseInt(Id);
			user = pUserManager.getUser(IdInt);
			transactionWIndow.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			if(!transactionWIndow.isVisible())
				System.out.println("usuario no econtrado");	
		}
		
	}
	
	public void addDeposit(int pAmount, UserManager pUserManager, int Id) {
		user = pUserManager.getUser(Id);
		Transaction transa = new Deposit(pAmount,"Deposito de: "+pAmount,user.getId(), LocalDate.now());
		user.addTransaction(transa);
		user.addMoreMoney(pAmount);
	}

}

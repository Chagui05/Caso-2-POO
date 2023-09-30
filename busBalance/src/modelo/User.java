package modelo;

import java.io.Serializable;
import java.util.Vector;

public class User implements Serializable {
	private String name;
	private Vector<Transaction> transactions;
	private int balance;//saldo
	private int id;

	public User(String pName,int pId ) {
		this.transactions = new Vector<Transaction>();
		this.name = pName;
		this.balance = 0;
		this.id = pId;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Vector<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

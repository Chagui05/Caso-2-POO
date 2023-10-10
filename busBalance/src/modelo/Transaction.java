package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Transaction implements Serializable{
	private int amount;//plata que entro o salio
	private String name;//
	private int userId;
	private LocalDate date;
	private TransactionType transactionType;
	
	public Transaction(int pAmount, String pName, int pUserId, LocalDate pDate, TransactionType pTransactionType) {
		this.amount = pAmount;
		this.name = pName;
		this.userId = pUserId;
		this.date = pDate;
		this.transactionType = pTransactionType;
	}

	public LocalDate getDate() {
		return date;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

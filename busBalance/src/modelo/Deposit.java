package modelo;

import java.time.LocalDate;

public class Deposit extends Transaction {
	
	public Deposit(int pAmount, String pName, int pUserId, LocalDate pDate){
		super(pAmount,pName,pUserId, pDate, TransactionType.DEPOSIT);
	}

}
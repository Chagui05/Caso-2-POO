package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Deposit extends Transaction implements Serializable{
	
	public Deposit(int pAmount, String pName, int pUserId, LocalDate pDate){
		super(pAmount,pName,pUserId, pDate, TransactionType.DEPOSIT);
	}

}
package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Trip extends Transaction implements Serializable{
	private Route route;
	
	public Trip(int pAmount, String pName, int pUserId, LocalDate pDate, Route pRoute){
		super(pAmount,pName,pUserId, pDate, TransactionType.TRIP);
		this.route = pRoute;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}

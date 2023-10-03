package modelo;

import java.time.LocalDate;

public class Trip extends Transaction {
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

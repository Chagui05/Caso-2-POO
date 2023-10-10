package jsonConfig;

import java.time.LocalTime;

public class TransactionConfig {
	private int newTransactionPeriod;
	private float porcentageOfTravel;
	private int initialUsersCount;
	private LocalTime serviceOpen;
	private LocalTime serviceClose;
	private LocalTime everyOneTravels;
	
	public int getInitialUsersCount() {
		return initialUsersCount;
	}
	public void setInitialUsersCount(int initialUsersCount) {
		this.initialUsersCount = initialUsersCount;
	}
	public float getPorcentageOfTravel() {
		return porcentageOfTravel;
	}
	public void setPorcentageOfTravel(float porcentageOfTravel) {
		this.porcentageOfTravel = porcentageOfTravel;
	}
	public void setNewTransactionPeriod(int newTransactionPeriod) {
		this.newTransactionPeriod = newTransactionPeriod;
	}
	public void setServiceOpen(LocalTime serviceOpen) {
		this.serviceOpen = serviceOpen;
	}
	public void setServiceClose(LocalTime serviceClose) {
		this.serviceClose = serviceClose;
	}
	public int getNewTransactionPeriod() {
		return newTransactionPeriod;
	}
	public LocalTime getServiceOpen() {
		return serviceOpen;
	}
	public LocalTime getEveryOneTravels() {
		return everyOneTravels;
	}
	public void setEveryOneTravels(LocalTime everyOneTravels) {
		this.everyOneTravels = everyOneTravels;
	}
	public LocalTime getServiceClose() {
		return serviceClose;
	}

	

}
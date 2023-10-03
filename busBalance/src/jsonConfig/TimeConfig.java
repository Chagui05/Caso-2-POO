package jsonConfig;

import java.time.LocalTime;

public class TimeConfig {
	private int newTransactionPeriod;
	private LocalTime serviceOpen;
	private LocalTime serviceClose;
	
	
	public void setNewTransactionPeriod(int newTransactionPeriod) {
		this.newTransactionPeriod = newTransactionPeriod;
	}
	public void setServiceOpen(LocalTime serviceOpen) {
		this.serviceOpen = serviceOpen;
	}
	public void setServiceClose(LocalTime serviceClose) {
		this.serviceClose = serviceClose;
	}

	

}
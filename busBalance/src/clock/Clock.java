package clock;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import jsonConfig.ConfigLoader;

public class Clock extends Thread{
	private LocalTime opens;
	private LocalTime closes;
	private LocalTime actualTime;
	private boolean running = true;
	

	public Clock() {
		this.opens = new ConfigLoader().getTimeConfig().getServiceOpen();
		this.opens = new ConfigLoader().getTimeConfig().getServiceClose();
	}
	public void stopRunning() {
		this.running = false;
	}
	@Override
	public void run() {
		actualTime = opens;
		while(running) {

			try {
				actualTime.plus(30, ChronoUnit.MINUTES);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	public LocalTime getActualTime() {
		return actualTime;
	}
	
	

}

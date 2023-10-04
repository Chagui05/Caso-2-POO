package clock;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import jsonConfig.ConfigLoader;

public class Clock extends Thread{
	private LocalTime opens;
	private LocalTime actualTime;
	private boolean running = true;
	

	public Clock() {
		this.opens = new ConfigLoader().getTimeConfig().getServiceOpen();
		this.actualTime = opens;
	}
	
	public void stopRunning() {
		this.running = false;
	}
	
	@Override
	public void run() {
		while(running) {

			try {
				actualTime = actualTime.plus(30, ChronoUnit.MINUTES);
				System.out.println(actualTime);
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	public LocalTime getActualTime() {
		return actualTime;
	}
	
	

}

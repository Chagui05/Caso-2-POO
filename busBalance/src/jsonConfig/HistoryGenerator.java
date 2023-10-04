package jsonConfig;

import java.time.LocalDate;
import java.util.Vector;

import clock.Clock;
import modelo.*;

public class HistoryGenerator implements Runnable{
	private boolean running = true;
	private Vector<User> usersRegistered;
	private RouteConfig routeConfig;
	private Route asignedRoute;
	private TimeConfig timeConfig;
	private Clock clock;

	public HistoryGenerator(Clock pClock) {
		this.routeConfig = new ConfigLoader().getRouteConfig();
		this.usersRegistered = new UserManager().unSerializeUsersRegistered();
		this.timeConfig = new ConfigLoader().getTimeConfig();
		this.clock = pClock;
	}
	
	public void generateTransaction(User pUser) {
		
		int balance = pUser.getBalance();
		int size = usersRegistered.size();
		int whatTrip = (int) Math.floor(Math.random()*(size+1));
		asignedRoute = routeConfig.getRoutes().elementAt(whatTrip);
		int price =asignedRoute.getCost();
		
		if (balance >= price) {
			pUser.addTransaction(new Trip(price, asignedRoute.getName(),pUser.getId(),LocalDate.now() , asignedRoute));	
			System.out.println(asignedRoute);
			System.out.println(" asignada a ");
			System.out.println(pUser);
		}
		else {
			System.out.println("no suficiente dinero");
		}
	}
	public void addTransactionToUser() {
		for(User lookFor: usersRegistered) {
			generateTransaction(lookFor);
		}
	}
	
	
	public void stopRunning() {
		this.running = false;
	}

	@Override
	public void run() {
		addTransactionToUser();
		while(running) {
			
			try {
				Thread.sleep(timeConfig.getNewTransactionPeriod()*1000);
				if(clock.getActualTime().isAfter(timeConfig.getServiceOpen()) && clock.getActualTime().isBefore(timeConfig.getServiceClose())) {
					addTransactionToUser();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}

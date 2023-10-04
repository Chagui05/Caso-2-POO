package jsonConfig;

import java.time.LocalDate;
import java.util.Vector;
import modelo.*;

public class HistoryGenerator implements Runnable{
	private boolean running = true;
	private Vector<User> usersRegistered;
	private RouteConfig routeConfig;
	private Route asignedRoute;
	private TimeConfig timeConfig;

	public HistoryGenerator() {
		this.routeConfig = new ConfigLoader().getRouteConfig();
		this.usersRegistered = new UserManager().unSerializeUsersRegistered();
		this.timeConfig = new ConfigLoader().getTimeConfig();
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
		while(running) {
			
			try {
				addTransactionToUser();
				Thread.sleep(timeConfig.getNewTransactionPeriod());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}

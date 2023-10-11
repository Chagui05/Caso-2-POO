package jsonConfig;

import java.time.LocalDate;
import java.util.Random;
import java.util.Vector;

import clock.Clock;
import modelo.*;

public class HistoryGenerator implements Runnable{
	private boolean running = true;
	private UserManager userManager; //cuidado con esto
	private RouteConfig routeConfig;
	private Route asignedRoute;
	private TransactionConfig transactionConfig;
	private Clock clock;

	public HistoryGenerator(Clock pClock, UserManager pUserManager) {
		this.routeConfig = new ConfigLoader().getRouteConfig();
		this.userManager = pUserManager;
		this.transactionConfig = new ConfigLoader().getTransactionConfig();
		this.clock = pClock;
	}
	
	public void generateTransaction(User pUser) {
		
		int balance = pUser.getBalance();
		int size = routeConfig.getRoutes().size();
		Random random = new Random();
		int whatTrip = random.nextInt(size); ///TODO problema con ese numero random
		asignedRoute = routeConfig.getRoutes().elementAt(whatTrip);
		int price = asignedRoute.getCost();
		
		System.out.println("User: "+ pUser.getId()+"Plata: "+pUser.getBalance());
		
		if (balance >= price) {
			pUser.addTransaction(new Trip(price, asignedRoute.getName(),pUser.getId(),LocalDate.now() , asignedRoute));
			pUser.eliminateAmountOfMoney(price);
			System.out.println(asignedRoute);
			System.out.println(" asignada a ");
			System.out.println(pUser);
		}
		else {
			System.out.println("no suficiente dinero");
			System.out.println();
		}
	}
	
	public void addTransactionToUsers() {
		for(User lookFor: userManager.getUsersRegistered()) {
			generateTransaction(lookFor);
		}
	}
	
	// determina segun el json cuantos viaja
	public void howManyTravel() {
		
		Random random = new Random();
        float randomNum;
        
        for (User lookFor: userManager.getUsersRegistered()) {
        	randomNum = random.nextFloat();
        	if (randomNum <= transactionConfig.getPorcentageOfTravel()) {
        		generateTransaction(lookFor);
            }
        }
	}
	
	//crea usuarios de "mentira" al inicio con parametros del json
	public void generateInitialUsers() {
		
		if(userManager.getUsersRegistered().isEmpty()) {
			
			Vector<User> usersRegistered = new Vector<User>();
			int usersCount = transactionConfig.getInitialUsersCount();
			for(int i = 0; i < usersCount; i++ ) {
				User newUser = new User("persona"+i,i);
				usersRegistered.add(newUser);
				System.out.println("se creo Usuario "+newUser.getId());
			}
			userManager.setUsersRegistered(usersRegistered);
			System.out.println("en la funcion "+userManager.getUser(2));
		}
	}
	
	public void stopRunning() {
		this.running = false;
	}

	@Override
	public void run() {
		generateInitialUsers();
		addTransactionToUsers();
		
		User pUser = userManager.getUser(1);
		int size = routeConfig.getRoutes().size();
		Random random = new Random();
		int whatTrip = random.nextInt(size); ///TODO problema con ese numero random
		asignedRoute = routeConfig.getRoutes().elementAt(whatTrip);
		int price = asignedRoute.getCost();
			pUser.addTransaction(new Trip(price, asignedRoute.getName(),pUser.getId(),LocalDate.now() , asignedRoute));	
			System.out.println(asignedRoute.getName()+" asignada a "+pUser.getId());
			System.out.println();
			
		while(running) {
			
			try {
				System.out.println("en el hilo "+userManager.getUser(2).getName()+" "+userManager.getUser(2).getBalance());
				Thread.sleep(transactionConfig.getNewTransactionPeriod()*1000);
				System.out.println(clock.getActualTime());
				
				if(clock.getActualTime().isAfter(transactionConfig.getServiceOpen()) && clock.getActualTime().isBefore(transactionConfig.getServiceClose())) {
					
					howManyTravel();
				}
				
				if(clock.getActualTime() == transactionConfig.getEveryOneTravels()) {
					addTransactionToUsers();
				}
				

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			///
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			///
		}
	}

}

package main;

import javax.swing.SwingUtilities;
import clock.Clock;
import gui.MainWindow;
import jsonConfig.ConfigLoader;
import jsonConfig.HistoryGenerator;
import jsonConfig.UserManager;

public class Main {

	public static void main(String args[]) {
		
		
		UserManager userManager = new UserManager();
		userManager.unSerializeUsersRegistered();
		System.out.println("Usuarios hallados");
        userManager.getUsersRegistered().forEach(elemento -> System.out.println( "Nombre: "+ elemento.getName()+" Saldo: "+elemento.getBalance()));
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
		Clock clock = new Clock();
		HistoryGenerator historyGenerator = new HistoryGenerator(clock,userManager);
        
        Thread historyThread = new Thread(historyGenerator);
        clock.start();
        historyThread.start();
        
      	MainWindow frame = new MainWindow(userManager);
        SwingUtilities.invokeLater(() -> {
			
	        frame.setVisible(true);
	        
	    }); 
        
    
	}
}

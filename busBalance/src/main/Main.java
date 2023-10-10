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
		Clock clock = new Clock();
		HistoryGenerator historyGenerator = new HistoryGenerator(clock,userManager);
        
        Thread historyThread = new Thread(historyGenerator);
        clock.start();
        historyThread.start();
        
       System.out.println(userManager.getUser(2));
        
        SwingUtilities.invokeLater(() -> {
			MainWindow frame = new MainWindow(userManager);
	        frame.setVisible(true);
	    }); 
		

	}
}

package Controller;

import javax.swing.JOptionPane;

import gui.HistoryWindow;
import jsonConfig.UserManager;
import modelo.User;

public class MainCreateUserController {

	public MainCreateUserController() {
		// TODO Auto-generated constructor stub
	}

	public void proccesTask(String Id, String name, UserManager usermanager) {
		int IdInt;
		
		try {
			IdInt = Integer.parseInt(Id);
			System.out.println("Valor entero: " + IdInt);
			
			if(usermanager.getUser(IdInt) != null) {
				JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
			}
			usermanager.AddUser(new User(name, IdInt));
				
			
			} 
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El ID debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}

}

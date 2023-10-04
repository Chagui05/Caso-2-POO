package jsonConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import modelo.User;

public class UserManager implements Serializable {
	
	private /*Static*/Vector<User> usersRegistered;

	public UserManager() {
		usersRegistered = null;
	}
	
	public void serializeUsersRegistered() {
		Vector<User> usersToSerialize = new Vector<>();
		usersToSerialize = usersRegistered;

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serializedUsers.ser"))) {
			out.writeObject(usersToSerialize);
			out.close();
            System.out.println("Vector serializado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public Vector<User> unSerializeUsersRegistered() {
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("serializedUsers.ser"))) {
			usersRegistered = (Vector<User>) in.readObject();
			in.close();
            System.out.println("Vector deserializado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		return usersRegistered;
		
	}
	
	public void AddUser(User pUser) {
		this.usersRegistered.add(pUser);
	}
	
	public User getUser(int pId) {
		for(User search: usersRegistered) {
			if(search.getId() == pId) {
				return search;
			}
		}
		return null;
	}

}
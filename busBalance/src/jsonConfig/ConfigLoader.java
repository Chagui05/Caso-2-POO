package jsonConfig;

import java.io.FileReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import modelo.Route;

public class ConfigLoader {
	private JsonObject jsonparser;
	private RouteConfig routeConfig;
	private TransactionConfig transactionConfig;

	public ConfigLoader() {
		loadJson();
	}


	private void loadJson() {
		String pathtofile = "C:\\Users\\santi\\OneDrive\\Desktop\\TEC-UCR\\TEC\\II-Semestre\\POO\\caso-2-POO\\busBalance\\config.json";


		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
			jsonparser = reader.readObject();
			System.out.println("Loaded JSON: " + jsonparser);            
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public RouteConfig getRouteConfig() {
		if (routeConfig == null) {
			this.routeConfig = new RouteConfig();
			Vector<Route> result = new Vector<Route>();
			JsonArray jsonRoutes = jsonparser.getJsonArray("routes");

			for (JsonValue routejson : jsonRoutes) {
				JsonObject routeobject = (JsonObject) routejson;

				Route task = new Route(routeobject.getInt("price"), routeobject.getString("name"));
				result.add(task);
			}
			routeConfig.setRoutes(result);
		}
		return routeConfig;
	}
	
	public TransactionConfig getTransactionConfig(){
		if (transactionConfig == null) {
			transactionConfig = new TransactionConfig();
			
			transactionConfig.setNewTransactionPeriod(jsonparser.getInt("newTransactionPeriod"));
			transactionConfig.setInitialUsersCount(jsonparser.getInt("initialUsersCount"));
			
			
			String porcentage = jsonparser.getString("porcentageOfTravel");
			Float floatPorcentage = Float.parseFloat(porcentage);
			transactionConfig.setPorcentageOfTravel(floatPorcentage);
			
			String horaString = jsonparser.getString("serviceOpen");
			LocalTime hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
			transactionConfig.setServiceOpen(hora);
			
			horaString = jsonparser.getString("serviceClose");
			hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
			transactionConfig.setServiceClose(hora);
			
			horaString = jsonparser.getString("everyOneTravels");
			hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
			transactionConfig.setEveryOneTravels(hora);
		}
		return transactionConfig;
	}
}
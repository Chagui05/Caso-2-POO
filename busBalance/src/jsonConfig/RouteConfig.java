package jsonConfig;

import java.util.Vector;

import modelo.Route;

public class RouteConfig {
	private Vector<Route> routes;
	
	void addRoute(Route pRoute) {
		routes.add(pRoute);
	}

	public void setRoutes(Vector<Route> routes) {
		this.routes = routes;
	}
	
	
	
}

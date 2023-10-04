package jsonConfig;

import java.util.Vector;

import modelo.Route;

public class RouteConfig {

	private Vector<Route> routes;
	
	
	public RouteConfig() {
		routes = null;
	}
	void addRoute(Route pRoute) {
		routes.add(pRoute);
	}

	public void setRoutes(Vector<Route> routes) {
		this.routes = routes;
	}
	
	public Vector<Route> getRoutes() {
		return routes;
	}
	
	
	
}

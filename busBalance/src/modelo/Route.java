package modelo;

public class Route {
	int price;
	String name;
	//TODO ConfigRuta configuration;
	
	public Route(int pPrice, String pName){
		this.price = pPrice;
		this.name = pName;
	}

	public int getCost() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package test;

public class BuyCar {
	
	private Driver bestDriver;
	private Car carType;
	
	public BuyCar(Driver d) {
		this.carType = new Benz();
		this.bestDriver = d;
	}

}

package entities;

public class Motorcycle extends Vehicle {
	final private int wheels = 2;
	private double kilometers;

	
	public Motorcycle(int idVehicule, String name, String color, String brand, String model, double kilometers, Person owner) {
		super(idVehicule, name, brand, model, color, owner);
		this.kilometers = kilometers;
	}
	
	public int getWheels(){
		return wheels;
	}
	
	public double getKilometers() {
		return kilometers;
	}

	public void setKilometers(double kilometers) {
		this.kilometers = kilometers;
	}
	
	@Override
	public String toString() {
		return "\n"+"Motorcycle: "+ "\n" + "     ID: " + idVehicule + "\n" + "     Name: " + name + "\n" +  "     Brand: " + brand + "\n" + "     Model: " + model + "\n" + "     Kilometers: " + kilometers + "\n" + "     Color: " + color + "\n" + "     Owner: " + owner.name + "\n";

	}
	

}

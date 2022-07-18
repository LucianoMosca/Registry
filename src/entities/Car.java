package entities;

public class Car extends Vehicle {
	final private int wheels = 4;
	private double kilometers;
	
	
	
	public Car(int idVehicule, String name, String color, String brand, String model, double kilometers, Person owner) {
		super(idVehicule, name, brand, model, color, owner);
		this.kilometers = kilometers;
		this.vehicleType = "Car";
	}

	

	public int getWheels() {
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
		return "\n"+"Car: "+ "\n" + "     ID: " + idVehicle + "\n" + "     Name: " + name + "\n" +  "     Brand: " + brand + "\n" + "     Model: " + model + "\n" + "     Kilometers: " + kilometers + "\n" + "     Color: " + color + "\n" + "     Owner: " + owner.name + "\n";

	}

}

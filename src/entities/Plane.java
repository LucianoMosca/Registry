package entities;

public class Plane extends Vehicle{
		
	public int passengers;
	
	public Plane(int idVehicule, String name, String brand, String model, String color, int passengers, Person owner) {
		super(idVehicule, name, brand, model, color, owner);
		this.passengers = passengers;
		this.brand = brand;
		this.model = model;
		this.vehicleType = "Plane";
		
		
	}

	public int getmxmPassangers() {
		return passengers;
	}

	public void setMxmPassangers(int mxmPassangers) {
		this.passengers = mxmPassangers;
	}

	@Override
	public String toString() {
		return "\n"+"Plane: "+ "\n" + "     ID: " + idVehicle + "\n" + "     Name: " + name + "\n" +  "     Brand: " + brand + "\n" + "     Model: " + model + "\n" + "     Color: " + color + "\n" + "     Owner: " + owner.name + "\n";

	}

}

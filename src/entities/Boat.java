package entities;

public class Boat extends Vehicle{
		
	public Boat(int idVehicule, String name, String brand, String model, String color, Person owner) {
		super(idVehicule, name, brand, model, color, owner);
		this.vehiculeType = "Boat";
		 
	}

	@Override
	public String toString() {
		return "\n"+"Boat: "+ "\n" + "     ID: " + idVehicule + "\n" + "     Name: " + name + "\n" +  "     Brand: " + brand + "\n" + "     Model: " + model + "\n" + "     Color: " + color + "\n" + "     Owner: " + owner.name + "\n";

	}
	
	
	

}

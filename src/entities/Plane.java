package entities;

public class Plane extends Vehicle{
			
	public Plane(int idVehicule, String name, String brand, String model, String color,  Person owner) {
		super(idVehicule, name, brand, model, color, owner);
		this.brand = brand;
		this.model = model;
		this.vehicleType = "Plane";
		
		
	}



	@Override
	public String toString() {
		return "\n"+"Plane: "+ "\n" + "     ID: " + idVehicle + "\n" + "     Name: " + name + "\n" +  "     Brand: " + brand + "\n" + "     Model: " + model + "\n" + "     Color: " + color + "\n" + "     Owner: " + owner.name + "\n";

	}

}

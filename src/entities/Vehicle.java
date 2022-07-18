package entities;

public class Vehicle {
	
	protected int idVehicle;
	protected String name;
	protected String brand;
	protected String model;
	protected String color;
	protected Person owner;
    protected String vehicleType;
	
	public Vehicle (int idVehicle, String name, String brand, String model, String color, Person owner) {
		this.idVehicle = idVehicle;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.owner = owner;
	}

	public int getIdVehicule() {
		return idVehicle;
	}

	public void setIdVehicule(int idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	
	public String getVehicleType(){
		return vehicleType;
	}
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehicle + ", nombre=" + name + ", color=" + color + ", owner=" + owner
				+ "]";
	}
}

package entities;

public class Vehicle {
	
	protected int idVehicule;
	protected String name;
	protected String brand;
	protected String model;
	protected String color;
	protected Person owner;
    protected String vehiculeType;
	
	public Vehicle (int idVehicule, String name, String brand, String model, String color, Person owner) {
		this.idVehicule = idVehicule;
		this.name = name;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.owner = owner;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
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

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehicule + ", nombre=" + name + ", color=" + color + ", owner=" + owner
				+ "]";
	}
}

package entidades;

public class Plane extends Vehicule{
		
	public double length;
	public int passengers;
	
	public Plane(int idVehicule, String name, String color, double length, int passengers, Person owner) {
		super(idVehicule, name, color,owner);
		this.passengers = passengers;
		this.length = length;
		this.vehiculeType = "Plane";
		
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getmxmPassangers() {
		return passengers;
	}

	public void setMxmPassangers(int mxmPassangers) {
		this.passengers = mxmPassangers;
	}

	@Override
	public String toString() {
		return "\n"+"Plane: "+ "\n" + "     ID: " + idVehicule + "\n" + "     Name: " +name + "\n" + "     Color: " + color + "\n" +  "     Length: " + length + "\n" + "     Maximum amount of passangers: " + passengers + "\n" + "     Owner: " + owner.name + "\n";

	}

}

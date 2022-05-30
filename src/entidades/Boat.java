package entidades;

public class Boat extends Vehicule{
	
	
	public double length;
	public double beam;
	
	public Boat(int idVehicule, String name, String color, double length, double beam, Person owner) {
		super(idVehicule, name, color,owner);
		this.length = length;
		this.beam = beam;	
		this.vehiculeType = "Boat";
		 
	}



	public double getEslora() {
		return length;
	}

	public void setEslora(double eslora) {
		this.length = eslora;
	}

	public double getManga() {
		return beam;
	}

	public void setManga(double manga) {
		this.beam = manga;
	}



	@Override
	public String toString() {
		return "\n"+"Boat: "+ "\n" + "     ID: " + idVehicule + "\n" + "     Name: " +name + "\n" + "     Color: " + color + "\n" +  "     Length: " + length + "\n" + "     Beam: " + beam + "\n" + "     Owner: " + owner.name + "\n";

	}
	
	
	

}

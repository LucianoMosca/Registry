package entidades;
//he
public class Vehicule {
	public int idVehicule;
	public String name;
	public String color;
	public Person owner;
	public String vehiculeType;
	
	public Vehicule (int idVehicule, String name, String color, Person owner) {
		this.idVehicule = idVehicule;
		this.name = name;
		this.color = color;
		this.owner = owner;
	}

	public int getIdVehiculo() {
		return idVehicule;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehicule = idVehiculo;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
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

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehicule + ", nombre=" + name + ", color=" + color + ", owner=" + owner
				+ "]";
	}
}

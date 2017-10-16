package tp1j;

public class Producto {
	private String nombre;
	private double precio;
	
	public Producto(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String toString(){
		return String.format("%s a %s", this.nombre, this.precio);
	}
}

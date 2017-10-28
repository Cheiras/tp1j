package tp1j;

public class Garantia {
	private double precioGarantia = 1.1;
	
	public double modificarPrecio(double unPrecio){
		return unPrecio * precioGarantia;
	}
}

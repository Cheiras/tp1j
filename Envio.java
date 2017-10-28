package tp1j;

public class Envio {
	private int precioEnvio = 100;
	
	public double modificarPrecio(double unPrecio){
		if(unPrecio < 5000){
			return unPrecio + precioEnvio;
		}
		return unPrecio;
	}
}

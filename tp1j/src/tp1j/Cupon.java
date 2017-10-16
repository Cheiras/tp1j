package tp1j;

public class Cupon {
	private int porcentaje = 0;
	
	public void setPorcentaje(int unPorcentaje){
		porcentaje = unPorcentaje;
	}
	
	public int getPorcentaje(){
		return porcentaje;
	}
	
	public double calcularNuevoPrecio(double unPrecio){
		return unPrecio * ((100 - porcentaje) / 100);
	}
}

package tp1j;

public class Cupon {
	private double porcentaje = 0;
	
	public Cupon(int porcentaje){
		this.porcentaje = porcentaje;
	}
	
	public void setPorcentaje(int unPorcentaje){
		porcentaje = unPorcentaje;
	}
	
	public double getPorcentaje(){
		return porcentaje;
	}
	
	public double modificarPrecio(double unPrecio){
		return unPrecio * ((100 - porcentaje) / 100);
	}
}

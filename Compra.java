package tp1j;

import java.util.ArrayList;

public class Compra {
	private double precioTotal = 0;
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	private boolean envio = false;
	private boolean garantia = false;
	private Cupon cupon = null;
	
	public void añadir (Producto unProducto){
		listaProductos.add(unProducto);
	}
	
	public void calcularPrecioTotal(){
		for(Producto producto : listaProductos){
			precioTotal = precioTotal + producto.getPrecio();
		}
		if (garantia){
			Garantia nuevaGarantia = new Garantia();
			precioTotal = nuevaGarantia.agregarPrecioGarantia(precioTotal);			
		}
		if (envio){
			Envio nuevoEnvio = new Envio();
			precioTotal = nuevoEnvio.agregarPrecioEnvio(precioTotal);
		}
		if (cupon != null){
			precioTotal = cupon.calcularNuevoPrecio(precioTotal);
		}
	}
	
	public void setEnvio(boolean unValor){
		envio = true;
	}
	
	public void setGarantia(boolean unValor){
		garantia = true;
	}
	
	public void setCupon(Cupon unCupon){
		if (this.reemplazarCupon(unCupon)){
			cupon = unCupon;
		}
	}
	
	private boolean reemplazarCupon(Cupon unCupon){
		if(cupon != null){
			if (unCupon.getPorcentaje() < cupon.getPorcentaje()){
				return false;
			}
		}
		return true;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

}

package tp1j;

import java.util.ArrayList;

import tp1j.Compra;
import tp1j.Producto;

public class AlgoBay {
	private int cantidadDeProductos = 0;
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	
	public Producto agregarProductoConPrecio (String nombre, int precio) throws PrecioNegativoError{
		if(precio < 0){
			throw new PrecioNegativoError("El precio del producto no puede ser negativo");
		}
		Producto producto = new Producto (nombre, precio);
		cantidadDeProductos++;
		return producto;
	}
	
	public int getCantidadDeProductos(){
		return cantidadDeProductos;
	}
	
	public Producto getProducto(String nombreProducto) throws ProductoNoEncontradoError{
		for(Producto producto : listaProductos){
			if (producto.getNombre() == nombreProducto)
				return producto;
		}
		throw new ProductoNoEncontradoError("No se ha encontrado el producto.");
	}
	
	public Compra crearNuevaCompra(){
		Compra nuevaCompra = new Compra();
		return nuevaCompra;
	}
	
	public Compra crearNuevaCompraConEnvio(){
		Compra nuevaCompraConEnvio = new Compra();
		nuevaCompraConEnvio.setEnvio(true);
		return nuevaCompraConEnvio;
	}
	
	public Compra crearNuevaCompraConGarantia(){
		Compra nuevaCompraConGarantia = new Compra();
		nuevaCompraConGarantia.setGarantia(true);
		return nuevaCompraConGarantia;
	}
	
	public Compra crearNuevaCompraConEnvioYGarantia(){
		Compra nuevaCompraConEnvioYGarantia = new Compra();
		nuevaCompraConEnvioYGarantia.setEnvio(true);
		nuevaCompraConEnvioYGarantia.setGarantia(true);
		return nuevaCompraConEnvioYGarantia;
	}
	
	public void agregarProductoEnCompra(Producto unProducto, Compra unaCompra){
		unaCompra.añadir(unProducto);
	}
	
	public Cupon crearCuponConPorcentaje(int unPorcentaje) throws PorcentajeFueraDeRangoError{
		if(unPorcentaje < 0 || unPorcentaje > 100){
			throw new PorcentajeFueraDeRangoError("El porcentaje del cupón debe estar entre 0 y 100");
		}
		Cupon nuevoCupon = new Cupon();
		nuevoCupon.setPorcentaje(unPorcentaje);
		return nuevoCupon;
	}
	
	public void agregarCuponEnCompra(Cupon unCupon, Compra unaCompra){
		unaCompra.setCupon(unCupon);
	}
		
	public double getPrecioTotalDe (Compra unaCompra){
		return unaCompra.getPrecioTotal();
	}
}
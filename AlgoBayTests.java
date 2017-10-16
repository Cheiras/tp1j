package fiuba.algo3.tp1;

import org.junit.Assert;
import org.junit.Test;

import tp1j.AlgoBay;
import tp1j.Compra;
import fiuba.algo3.tp1.Cupon;
import tp1j.Producto;

public class AlgoBayTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01AgregarProductos() {
		
		AlgoBay algoBay = new AlgoBay();
		
		Assert.assertEquals(algoBay.getCantidadDeProductos(),0);
		
		Producto producto = algoBay.agregarProductoConPrecio("Spinner fluo",83);
		
		Assert.assertEquals(algoBay.getCantidadDeProductos(),1);
		
		Assert.assertNotNull(producto);
	}
	
	
	@Test
	public void test02GetProducto() {
		
		AlgoBay algoBay = new AlgoBay();
				
		algoBay.agregarProductoConPrecio("Moto 5G",4399);
		
		Producto productoMotoG = algoBay.getProducto("Moto 5G");
		
		Assert.assertNotNull(productoMotoG);
	}
	
	
	@Test
	public void test03CompraSimple() {
		
		AlgoBay algoBay = new AlgoBay();
				
		Producto productoZapatillaNike = algoBay.agregarProductoConPrecio("Zapatilla Nike Air",2100);
		algoBay.agregarProductoConPrecio("Moto 5G",4300);
		algoBay.agregarProductoConPrecio("Cable usb",200);

		Producto productoMotoG = algoBay.getProducto("Moto 5G");
		
		Compra compra = algoBay.crearNuevaCompra();
		
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compra);
		algoBay.agregarProductoEnCompra(productoMotoG,compra);

		int precio = algoBay.getPrecioTotalDe(compra);
		
		Assert.assertEquals(precio,6400);
	}
	
	
	@Test
	public void test04EnvioCuesta100() {
		
		AlgoBay algoBay = new AlgoBay();
				
		Producto productoZapatillaNike = algoBay.agregarProductoConPrecio("Zapatilla Nike Air",2100);
		
		Compra compraSimple = algoBay.crearNuevaCompra();
		Compra compraConEnvio = algoBay.crearNuevaCompraConEnvio();
		
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compraSimple);
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compraConEnvio);

		int precioSimple = algoBay.getPrecioTotalDe(compraSimple);
		int precioConEnvio = algoBay.getPrecioTotalDe(compraConEnvio);

		Assert.assertEquals(precioSimple+100,precioConEnvio);
	}
 
	
	@Test
	public void test05GarantiaCuesta10Porciento() {
		
		AlgoBay algoBay = new AlgoBay();
				
		Producto productoZapatillaNike = algoBay.agregarProductoConPrecio("Zapatilla Nike Air",2000);
		
		Compra compraSimpleConGarantia = algoBay.crearNuevaCompraConGarantia();
		Compra compraConEnvioYGarantia = algoBay.crearNuevaCompraConEnvioYGarantia();
		
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compraSimpleConGarantia);
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compraConEnvioYGarantia);

		int precioSimpleConGarantia = algoBay.getPrecioTotalDe(compraSimpleConGarantia);
		int precioConEnvioYGarantia = algoBay.getPrecioTotalDe(compraConEnvioYGarantia);

		Assert.assertEquals(precioSimpleConGarantia,2000*1.1,DELTA);
		Assert.assertEquals(precioConEnvioYGarantia,(2000*1.1)+100,DELTA);

	}
	
	@Test
	public void test06EnvioBonificadoComprasMayoresA5000() {
		
		AlgoBay algoBay = new AlgoBay();
				
		Producto productoZapatillaNike = algoBay.agregarProductoConPrecio("Zapatilla Nike Air",2000);
		Producto productoMotoG = algoBay.agregarProductoConPrecio("Moto 5G",4000);

		Compra compraConEnvioYGarantia = algoBay.crearNuevaCompraConEnvioYGarantia();
		
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compraConEnvioYGarantia);
		algoBay.agregarProductoEnCompra(productoMotoG,compraConEnvioYGarantia);

		int precioConEnvioYGarantia = algoBay.getPrecioTotalDe(compraConEnvioYGarantia);

		Assert.assertEquals(precioConEnvioYGarantia,(6000*1.1)+0,DELTA);
	}
	
	@Test
	public void test07CuponDescuento() {
		
		AlgoBay algoBay = new AlgoBay();
				
		Producto productoZapatillaNike = algoBay.agregarProductoConPrecio("Zapatilla Nike Air",2000);

		Compra compraConEnvio = algoBay.crearNuevaCompraConEnvio();
		Cupon cupon20Porciento = algoBay.crearCuponConPorcentaje(20);
		
		algoBay.agregarCuponEnCompra(cupon20Porciento,compraConEnvio);
		algoBay.agregarProductoEnCompra(productoZapatillaNike,compraConEnvio);

		int precioConDescuento = algoBay.getPrecioTotalDe(compraConEnvio);

		Assert.assertEquals(precioConDescuento,(2000+100)*0.8,DELTA);
	}
	
	@Test
	public void test08CuponesNoSonAcumulablesValeElMayor() {
		
		AlgoBay algoBay = new AlgoBay();
				
		Producto productoZapatillaNike = algoBay.agregarProductoConPrecio("Zapatilla Nike Air",2000);

		Compra compra = algoBay.crearNuevaCompra();
		Cupon cupon20Porciento = algoBay.crearCuponConPorcentaje(20);
		Cupon cupon25Porciento = algoBay.crearCuponConPorcentaje(25);
		Cupon cupon30Porciento = algoBay.crearCuponConPorcentaje(30);

		algoBay.agregarCuponEnCompra(cupon20Porciento,compra);
		algoBay.agregarCuponEnCompra(cupon25Porciento,compra);
		algoBay.agregarCuponEnCompra(cupon30Porciento,compra);

		algoBay.agregarProductoEnCompra(productoZapatillaNike,compra);

		int precioConDescuento = algoBay.getPrecioTotalDe(compra);

		Assert.assertEquals(precioConDescuento,2000*0.7,DELTA);
	}
}

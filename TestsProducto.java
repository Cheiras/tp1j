package pruebas;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tp1j.AlgoBay;
import tp1j.PrecioNegativoError;
import tp1j.Producto;
import tp1j.ProductoNoEncontradoError;



public class TestsProducto {
	
	private static final double DELTA = 1e-15;
	
	@Test
	public void testCrearProducto() throws PrecioNegativoError{
		AlgoBay algoBay = new AlgoBay();
		Producto producto1 = algoBay.agregarProductoConPrecio("Ebook", 100);
		Assert.assertNotNull(producto1);
	}

	@Test
	public void testGetProducto() throws PrecioNegativoError, ProductoNoEncontradoError {
		
		AlgoBay algoBay = new AlgoBay();
		algoBay.agregarProductoConPrecio("Ebook", 100);
		Producto producto1 = algoBay.getProducto("Ebook");
		Assert.assertNotNull(producto1);
	}
	
	@Test
	public void testCantidadDeProductos() throws PrecioNegativoError{
		AlgoBay algoBay = new AlgoBay();
		algoBay.agregarProductoConPrecio("Ebook", 100);
		algoBay.agregarProductoConPrecio("Cable USB", 200);
		algoBay.agregarProductoConPrecio("Zapatilla Nike Air", 2100);
		Assert.assertEquals(3, algoBay.getCantidadDeProductos());
	}
	
	@Test
	public void testAgregarProductoConElMismoNombreCambiaPrecio() throws PrecioNegativoError, ProductoNoEncontradoError{
		AlgoBay algoBay = new AlgoBay();
		algoBay.agregarProductoConPrecio("Ebook", 100);
		algoBay.agregarProductoConPrecio("Ebook", 200);
		Producto producto1 = algoBay.getProducto("Ebook");
		Assert.assertEquals(200, producto1.getPrecio(), DELTA);
	}
	
	@Test
	public void testAgregarProductoConElMismoNombreNoCambiaCantidad() throws PrecioNegativoError, ProductoNoEncontradoError{
		AlgoBay algoBay = new AlgoBay();
		algoBay.agregarProductoConPrecio("Ebook", 100);
		algoBay.agregarProductoConPrecio("Ebook", 200);
		Assert.assertEquals(1, algoBay.getCantidadDeProductos());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testBuscarProductoQueNoExiste() throws ProductoNoEncontradoError{
		AlgoBay algoBay = new AlgoBay();
		
		thrown.expect(ProductoNoEncontradoError.class);
		algoBay.getProducto("Ebook");
	}
	
	@Test
	public void testAgregarProductoConPrecioNegativo() throws PrecioNegativoError{
		AlgoBay algoBay = new AlgoBay();
		thrown.expect(PrecioNegativoError.class);
		algoBay.agregarProductoConPrecio("Ebook", -100);
	}

}

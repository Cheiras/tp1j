package pruebas;

import org.junit.Assert;
import org.junit.Test;

import tp1j.AlgoBay;
import tp1j.Compra;
import tp1j.PrecioNegativoError;
import tp1j.Producto;

public class TestsCompra {
	
	private static final double DELTA = 1e-15;
		
	@Test
	public void testGetPrecioTotalDeUnaCompra() throws PrecioNegativoError {
		AlgoBay algoBay = new AlgoBay();
		 
		Producto zapatilla = algoBay.agregarProductoConPrecio("Zapatilla", 2100);
		Compra compra = algoBay.crearNuevaCompra();
		compra.añadir(zapatilla);
		
		Assert.assertEquals(zapatilla.getPrecio(), algoBay.getPrecioTotalDe(compra), DELTA);
	}
}

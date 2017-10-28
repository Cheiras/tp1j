package pruebas;

import org.junit.Assert;
import org.junit.Test;

import tp1j.AlgoBay;
import tp1j.Compra;
import tp1j.PrecioNegativoError;
import tp1j.Producto;

public class TestsCompraConEnvio {
	
	private static final double DELTA = 1e-15;
	
	@Test
	public void testCrearCompraConEnvioCuesta100Mas() throws PrecioNegativoError{
		AlgoBay algoBay = new AlgoBay();
		Producto zapatilla = algoBay.agregarProductoConPrecio("Zapatilla", 2100);
		Compra compraConEnvio = algoBay.crearNuevaCompraConEnvio();
		algoBay.agregarProductoEnCompra(zapatilla, compraConEnvio);
		Assert.assertEquals(zapatilla.getPrecio() + 100, algoBay.getPrecioTotalDe(compraConEnvio), DELTA);
	}
	
	@Test
	public void testEnvioNoSeCobraEnComprasMayoresA5000() throws PrecioNegativoError{
		 AlgoBay algoBay = new AlgoBay();

	        Producto zapatilla = algoBay.agregarProductoConPrecio("Zapatilla", 2000);
	        Producto celular = algoBay.agregarProductoConPrecio("Moto 5G", 4000);

	        Compra compraConEnvio = algoBay.crearNuevaCompraConEnvio();

	        algoBay.agregarProductoEnCompra(zapatilla, compraConEnvio);
	        algoBay.agregarProductoEnCompra(celular, compraConEnvio);

	        Assert.assertEquals(6000 + 0, algoBay.getPrecioTotalDe(compraConEnvio), DELTA);
	}
}

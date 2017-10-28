package pruebas;

import org.junit.Assert;
import org.junit.Test;

import tp1j.AlgoBay;
import tp1j.Compra;
import tp1j.PrecioNegativoError;
import tp1j.Producto;

public class TestsCompraConGarantia {
	
private static final double DELTA = 1e-15;
	
	@Test
	public void testCrearCompraConEnvioCuesta10PorcientoMas() throws PrecioNegativoError{
		AlgoBay algoBay = new AlgoBay();
		Producto zapatilla = algoBay.agregarProductoConPrecio("Zapatilla", 2100);
		Compra compraConGarantia = algoBay.crearNuevaCompraConGarantia();
		algoBay.agregarProductoEnCompra(zapatilla, compraConGarantia);
		Assert.assertEquals(zapatilla.getPrecio()* 1.1, algoBay.getPrecioTotalDe(compraConGarantia), DELTA);
	}
}

package pruebas;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tp1j.AlgoBay;
import tp1j.Compra;
import tp1j.Cupon;
import tp1j.PorcentajeFueraDeRangoError;
import tp1j.PrecioNegativoError;
import tp1j.Producto;

public class TestsCupon {

	private static final double DELTA = 1e-15;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testCrearCuponConPorcentajeFueraDeRango() throws PorcentajeFueraDeRangoError {
		AlgoBay algoBay = new AlgoBay();
		thrown.expect(PorcentajeFueraDeRangoError.class);
		algoBay.crearCuponConPorcentaje(-20);
	}
	
	@Test
	public void testAplicarCuponModificaPrecioCorrectamente() throws PrecioNegativoError, PorcentajeFueraDeRangoError {
		
		AlgoBay algoBay = new AlgoBay();
        Producto zapatilla = algoBay.agregarProductoConPrecio("Zapatilla", 2000);
        Compra compra = algoBay.crearNuevaCompra();
        Cupon cupon20Porciento = algoBay.crearCuponConPorcentaje(20);
        algoBay.agregarCuponEnCompra(cupon20Porciento, compra);
        algoBay.agregarProductoEnCompra(zapatilla, compra);
        Assert.assertEquals(2000 * 0.8, algoBay.getPrecioTotalDe(compra), DELTA);
	}
	
	@Test
	public void testCuponesNoAcumulablesYValeElMayor() throws PorcentajeFueraDeRangoError, PrecioNegativoError{
	      AlgoBay algoBay = new AlgoBay();

	      Producto zapatilla = algoBay.agregarProductoConPrecio("Zapatilla", 2000);
	      Compra compra = algoBay.crearNuevaCompra();
	      Cupon cupon20Porciento = algoBay.crearCuponConPorcentaje(20);
	      Cupon cupon25Porciento = algoBay.crearCuponConPorcentaje(25);
	      Cupon cupon30Porciento = algoBay.crearCuponConPorcentaje(30);
	      
	      algoBay.agregarCuponEnCompra(cupon20Porciento, compra);
	      algoBay.agregarCuponEnCompra(cupon25Porciento, compra);
	      algoBay.agregarCuponEnCompra(cupon30Porciento, compra);
	      algoBay.agregarProductoEnCompra(zapatilla,compra);
	      
	      Assert.assertEquals(2000 * 0.7, algoBay.getPrecioTotalDe(compra), DELTA);
	}

}

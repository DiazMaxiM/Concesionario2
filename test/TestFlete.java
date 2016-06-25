import static org.junit.Assert.*;

import org.junit.Test;

public class TestFlete 
{

	/**
	 * Dado un flete con costo 1 por metro recorrido, le pregunto por su costo por metro.
	 */
	@Test
	public void testObtenerCostoPorMetro() 
	{
		Flete flete = new Flete(1);
		assertEquals(flete.obtenerCostoPorMetro(), 1);
	}

	/**
	 * Dado un flete con costo 1 por metro recorrido, le pregunto por el costo de recorrer 15000m.
	 */
	@Test
	public void testCostoCasoPositivo() 
	{
		Flete flete = new Flete(1);
		assertEquals(flete.costo(15000), 15000);
	}
	
	/**
	 * Dado un flete con costo 1 por metro recorrido, le pregunto por el costo de recorrer 15000m.
	 */
	@Test
	public void testCostoCasoNegativo() 
	{
		Flete flete = new Flete(1);
		assertNotEquals(flete.costo(15000), 10000);
	}
	
}

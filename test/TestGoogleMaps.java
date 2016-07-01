import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class TestGoogleMaps {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws ExceptionErrorAlObtenerDistancia {
		String direccion1 ="Luciano Valette 1755,Luis Guillon,Buenos Aires,Argentina";
		String direccion2 ="Saenz Peña 300,Bernal,Buenos Aires,Argentina";
		GoogleMap miMapa = new GoogleMap();
		Integer distancia = miMapa.obtenerDistancia(direccion1, direccion2);

		assertTrue(distancia.equals(43615));
		
		
	}
	@Test(expected=ExceptionErrorAlObtenerDistancia.class)
	public void testErrorAlObtenerDireccionGoogle() throws ExceptionErrorAlObtenerDistancia {
		String direccion1 ="";
		String direccion2 ="";
		GoogleMap miMapa = new GoogleMap();
		Integer distancia = miMapa.obtenerDistancia(direccion1, direccion2);		
	}
}

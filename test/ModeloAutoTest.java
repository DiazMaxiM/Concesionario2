import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class ModeloAutoTest {

	private Modelo miModelo;

	@Before
	public void setUp() throws Exception {
		miModelo = new Modelo("Ka", 2016, 5, true, (float)1000);
	}

	@Test
	public void testModeloAutoConsistente() {
		assertTrue(miModelo.obtenerNombreDeModelo().equals("Ka"));
		assertTrue(miModelo.getAnio().equals(2016));
		assertTrue(miModelo.getCantidadDePuertas().equals(5));
		assertTrue(miModelo.esBase());;
	}
	
	@Test
	public void testDadoUnModeloConPrecio1000SiLePreguntoSuPrecioDevuelve1000(){
		assertTrue(miModelo.precioMovil() == 1000);
	}

}

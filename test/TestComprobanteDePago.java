import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestComprobanteDePago {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testComprobanteDePago() {
	ComprobanteDePago miComprobanteDePago= new ComprobanteDePago(1,1500,144,45);
	assertTrue(miComprobanteDePago.obtenerNumeroDeCuota().equals(1));
	assertTrue(miComprobanteDePago.obtenerAlicuota()==1500);
	assertTrue(miComprobanteDePago.obtenerGastosAdministrativos()==144);
	assertTrue(miComprobanteDePago.obtenerSeguroDeVida()==45);
	
	}

}

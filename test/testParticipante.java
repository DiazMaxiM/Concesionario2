import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;



public class testParticipante {
	Cliente cliente1= mock(Cliente.class);
	Cliente cliente2= mock(Cliente.class);
	Cliente cliente3= mock(Cliente.class);
	
	
	Participante miParticipante=new Participante(cliente1);
	Participante miParticipante2=new Participante(cliente2);
	Participante miParticipante3=new Participante(cliente3);
	ComprobanteDePago comprobante50 = mock (ComprobanteDePago.class);
	ComprobanteDePago comprobante300 = mock (ComprobanteDePago.class);
	
	@Before
	public void setUp() throws Exception {
		when(cliente1.obtenerFechaDeIngreso()).thenReturn(new DateTime(1988,05,29,0,0));
		when(cliente2.obtenerFechaDeIngreso()).thenReturn(new DateTime(1990,05,29,0,0));
		when(cliente3.obtenerFechaDeIngreso()).thenReturn(new DateTime(2000,05,29,0,0));
		when(comprobante50.montoPagado()).thenReturn((float)50);
		when(comprobante300.montoPagado()).thenReturn((float)300);
		miParticipante.agregarComprobante(comprobante50);
		miParticipante2.agregarComprobante(comprobante300);
		miParticipante3.agregarComprobante(comprobante300);
		
	}

	@Test
	public void test() {
		//float numero =0;
		assertEquals(miParticipante.estaAdjudicado(), false);
		assertEquals(miParticipante.obtenerCliente(), cliente1);
		//assertTrue(miParticipante.plataPagada().equals(0));
		miParticipante.Adjudico();
		assertEquals(miParticipante.estaAdjudicado(), true);
		assertEquals(miParticipante.compararQuienPagoMas(miParticipante2),new Integer(-1));
		assertEquals(miParticipante2.compararQuienPagoMas(miParticipante),new Integer(1));
		assertEquals(miParticipante2.compararQuienPagoMas(miParticipante3),new Integer(1));
		}

}

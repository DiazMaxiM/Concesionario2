import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class CompaniaAseguradoraTest {

	private CompaniaAseguradora companiaAseguradora;
	private Participante participanteMock ;
	private PlanDeAhorro planDeAhorroMock ;

	@Before
	public void setUp() throws Exception {
		participanteMock  = mock(Participante.class);
		planDeAhorroMock = mock(PlanDeAhorro.class);
		companiaAseguradora = new CompaniaAseguradora(participanteMock,planDeAhorroMock);
		}
	
	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad20Es50() {
		when(participanteMock.obtenerCliente().obtenerEdad()).thenReturn(22);
		when(planDeAhorroMock.precioDelVehiculo()).thenReturn((float)0);
		assertTrue(companiaAseguradora.montoAAbonarPorParticipante().equals((float)50));
	}
	
	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad50Es60(){	
		assertFalse(companiaAseguradora.montoAAbonarPorParticipante().equals(60));
	}

}

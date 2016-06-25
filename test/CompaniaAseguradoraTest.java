import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class CompaniaAseguradoraTest {

	private CompaniaAseguradora companiaAseguradora;
	private Participante participanteMock ;
	PlanDeAhorro planDeAhorroMock ;

	@Before
	public void setUp() throws Exception {
		participanteMock  = mock(Participante.class);
		planDeAhorroMock = mock(PlanDeAhorro.class);
		companiaAseguradora = new CompaniaAseguradora(participanteMock,planDeAhorroMock);
		}

	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad20Es50() {
		assertTrue(companiaAseguradora.montoAAbonarPorParticipante().equals(50.00));
	}
	
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad50Es60(){	
		assertTrue(companiaAseguradora.montoAAbonarPorParticipante().equals(60.00));
	}

}

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
	private Cliente clienteMock = mock (Cliente.class);
	@Before
	public void setUp() throws Exception {
		participanteMock  = mock(Participante.class);
		planDeAhorroMock = mock(PlanDeAhorro.class);
		companiaAseguradora = new CompaniaAseguradora(participanteMock,planDeAhorroMock);
		when(participanteMock.obtenerCliente()).thenReturn(clienteMock);
		when(clienteMock.obtenerEdad()).thenReturn(22);
		when(planDeAhorroMock.precioDelVehiculo()).thenReturn((float)0);
		}
	
	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad22Es50() {
		when(clienteMock.obtenerEdad()).thenReturn(22);
		assertEquals(companiaAseguradora.montoAAbonarPorParticipante(), new Float(50));
	}
	
	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad22NoEs60(){	
		when(clienteMock.obtenerEdad()).thenReturn(22);
		assertNotEquals(companiaAseguradora.montoAAbonarPorParticipante(), new Float(60));
	}
	
	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad51Es60(){	
		when(clienteMock.obtenerEdad()).thenReturn(51);
		assertEquals(companiaAseguradora.montoAAbonarPorParticipante(), new Float(60));
	}
	
	@Test
	public void testDadoUnaCompaniaAseguradoraElMontoAAbonarPorUnParticipanteDeEdad51YPlaDeAhorroConVehiculoDe1000Es110(){
		when(clienteMock.obtenerEdad()).thenReturn(51);
		when(planDeAhorroMock.precioDelVehiculo()).thenReturn((float)1000);	
		assertEquals(companiaAseguradora.montoAAbonarPorParticipante(), new Float(110));
	}

	
}

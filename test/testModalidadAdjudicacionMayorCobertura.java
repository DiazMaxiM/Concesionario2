import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class testModalidadAdjudicacionMayorCobertura {

	ModalidadDeAdjudicacion modalidadMayorCobertura= new ModalidadMayorCobertura();	
	PlanDeAhorro plan= mock (PlanDeAhorro.class);
	PlanDeAhorro planSinParticipantes= mock (PlanDeAhorro.class);
	Cliente cliente1 = mock (Cliente.class);
	Cliente cliente2 = mock (Cliente.class);
	Cliente cliente3 = mock (Cliente.class);
	Participante participante1 = mock (Participante.class);
	Participante participante2 = mock (Participante.class);
	Participante participante3 = mock (Participante.class);
	List<Participante> participantesPosibles= new ArrayList<Participante>();
	@Before
	public void setUp() throws Exception {
		participantesPosibles.add(participante1);
		participantesPosibles.add(participante2);
		participantesPosibles.add(participante3);
		when(participante1.plataPagada()).thenReturn((float)1000);
		when(participante2.plataPagada()).thenReturn((float)500);
		when(participante3.plataPagada()).thenReturn((float)1000);
		when(participante1.obtenerCliente()).thenReturn(cliente1);
		when(participante2.obtenerCliente()).thenReturn(cliente2);
		when(participante3.obtenerCliente()).thenReturn(cliente3);
		when(cliente1.obtenerFechaDeIngreso()).thenReturn(new DateTime(1988,05,29,0,0));
		when(cliente2.obtenerFechaDeIngreso()).thenReturn(new DateTime(1990,05,29,0,0));
		when(cliente3.obtenerFechaDeIngreso()).thenReturn(new DateTime(2000,05,29,0,0));
		when(plan.clientesQueNoAdjudicaron()).thenReturn(participantesPosibles);
			
	}
@Test
public void testAdjudicarConParticipantes() throws ExceptionAdjudicarPlanSinParticipantes {
	Participante participante=modalidadMayorCobertura.adjudicar(plan);
	assertTrue(participantesPosibles.contains(participante));
	assertEquals(participante, participante1);
}
@Test (expected =  ExceptionAdjudicarPlanSinParticipantes.class)
public void testAdjudicarSinPlanConParticipantes() throws ExceptionAdjudicarPlanSinParticipantes {	 
	when(planSinParticipantes.clientesQueNoAdjudicaron()).thenReturn(new ArrayList<Participante>());
	modalidadMayorCobertura.adjudicar(planSinParticipantes);
}
}

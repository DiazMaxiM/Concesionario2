import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class testPlanDeAhorro {
	ModalidadDeAdjudicacion modalidad= mock (ModalidadSorteo.class);
	Modelo modelo = mock(Modelo.class);
	PlanDeAhorro miPlan= new PlanDeAhorro(modalidad, 1, new Financiacion100(), modelo,50);
	
	Cliente cliente1= mock(Cliente.class);
	Cliente cliente2= mock(Cliente.class);
	Cliente cliente3= mock(Cliente.class);
	
	Participante miParticipante=mock (Participante.class);
	Participante miParticipante2=mock (Participante.class);
	Participante miParticipante3=mock (Participante.class);
	@Before
	public void setUp() throws Exception {
			}

	@Test
	public void testPlanSinParticipantes() {
		assertEquals(miPlan.cantidadDeParticipantes(),(Integer)0);
	}
	@Test
	public void testParaConstructor() {
		when(modelo.precioMovil()).thenReturn(1000f);
		assertEquals(miPlan.cantidadDeParticipantes(),(Integer)0);
		assertEquals(miPlan.cantidadDeCuotas(),(Integer)50);
		assertEquals(miPlan.obtenerModelo(),modelo);
		assertTrue(miPlan.precioDelVehiculo()==1000f);
		assertTrue(miPlan.montoAPagarPorAdjudicacion()==0f);
		
	}
	@Test
	public void testClientesQueNoAdjudicaron(){
		List<Participante> listaDeParticipantesQueNoAdjudicaron = new ArrayList<Participante>();
		listaDeParticipantesQueNoAdjudicaron.add(miParticipante2);
		listaDeParticipantesQueNoAdjudicaron.add(miParticipante3);

		miPlan.agregarParticipante(miParticipante);
		miPlan.agregarParticipante(miParticipante2);
		miPlan.agregarParticipante(miParticipante3);
		
		
		assertTrue(miPlan.clientesQueNoAdjudicaron().containsAll(listaDeParticipantesQueNoAdjudicaron));
	}
	@Test
	public void testClientesQueAdjudicaron(){
		when(miParticipante.estaAdjudicado()).thenReturn(true);
		miPlan.agregarParticipante(miParticipante);
		
		List<Participante> listaDeParticipantesQueAdjudicaron = new ArrayList<Participante>();
		listaDeParticipantesQueAdjudicaron.add(miParticipante);
		
		assertTrue(miPlan.listaDeClientesAdjudicados().containsAll(listaDeParticipantesQueAdjudicaron));
	}
	@Test
	public void testPlanConParticipantes(){
		miPlan.agregarParticipante(miParticipante);
		miPlan.agregarParticipante(miParticipante2);
		miPlan.agregarParticipante(miParticipante3);
		
		List<Participante> listaDeParticipantes = new ArrayList<Participante>();
		listaDeParticipantes.add(miParticipante);
		listaDeParticipantes.add(miParticipante2);
		listaDeParticipantes.add(miParticipante3);

		
		assertEquals(miPlan.cantidadDeParticipantes(),(Integer)3);
		assertTrue(miPlan.listaDeParticipantes().equals(listaDeParticipantes));
		
	}
@Test
public void testAdjudicar() throws ExceptionAdjudicarPlanSinParticipantes{
	when(modalidad.adjudicar(miPlan)).thenReturn(miParticipante);
	Participante resultado = miPlan.adjudicar();
	verify(modalidad).adjudicar(miPlan);
	assertEquals(miParticipante, resultado);
}
@Test( expected = ExceptionAdjudicarPlanSinParticipantes.class)
public void testAdjudicarEnUnPlanSinParticipantes()throws ExceptionAdjudicarPlanSinParticipantes{
	doThrow(new ExceptionAdjudicarPlanSinParticipantes()).when(modalidad).adjudicar(miPlan);
	Participante resultado = miPlan.adjudicar();
	verify(modalidad).adjudicar(miPlan);
	assertEquals(miParticipante, resultado);
}
}

import static org.junit.Assert.*;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class testClientes 
{
	Cliente liza;
	DateTime fechaIngresoLiza;
	DateTime fechaNacimientoLiza;
	
	@Before
	public void setUp()
	{
		this.fechaIngresoLiza = new DateTime(2015,05,03, 0, 0);
		this.fechaNacimientoLiza = new DateTime(1994, 5, 10, 0, 0);
		this.liza = new Cliente("Liza", "Chambi",38354056, "Av. Valette 1755", fechaNacimientoLiza, "liza.chambi@gmail.com", fechaIngresoLiza);
	}
	
	@Test
	/**
	 * Dado un Cliente, le pregunto por su DNI.
	 */
	public void testDniDelCliente() 
	{
		assertTrue (liza.obtenerDni().equals(38354056));
	}
	
	@Test
	/**
	 * Dado un Cliente, le pregunto por su fechaDeIngreso.
	 */
	public void testFechaDeIngresoDelCliente()
	{	
		assertTrue (liza.obtenerFechaDeIngreso().equals(fechaIngresoLiza));
	}
	
	@Test
	/**
	 * Dado un Cliente, le pregunto por su nombre.
	 */
	public void testNombreDelCliente()
	{	
		assertTrue(liza.obtenerNombre().equals("Liza"));
	}
	
	@Test
	/**
	 * Dado un Cliente, le pregunto por su apellido.
	 */
	public void testApellidoDelCliente()
	{	
		assertTrue(liza.obtenerApellido().equals("Chambi"));
	}
	
	@Test
	/**
	 * Dado un Cliente, le pregunto por su direccion.
	 */
	public void testDireccionDelCliente()
	{	
		assertTrue(liza.obtenerDireccion().equals("Av. Valette 1755"));
	}

	@Test
	/**
	 * Dado un Cliente, le pregunto por su apellido.
	 */
	public void testFechaDeNacimientoDelCliente()
	{	
		assertTrue(liza.obtenerFechaDeNacimiento().equals(fechaNacimientoLiza));
	}
	
	@Test
	/**
	 * Dado un Cliente, le pregunto por su direccion de correo electronico.
	 */
	public void testCorreoElectronicoDelCliente()
	{	
		assertTrue(liza.obtenerCorreoElectronico().equals("liza.chambi@gmail.com"));
	}
	
	@Test
	public void testPruebaCalculoDeEdadesDadoUnaPersonaDeEdad22SiLePreguntoSiSuEdadEs22RespondeTrue(){
		assertTrue(this.liza.obtenerEdad().equals(22));
	}
	
	@Test
	public void testPruebaCalculoDeEdadesDadoUnaPersonaDeEdad22SiLePreguntoSiSuEdadEs23RespondeFalse(){
		assertFalse(this.liza.obtenerEdad().equals(23));
	}
	
}

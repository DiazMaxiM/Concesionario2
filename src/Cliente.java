/**
 * Esta es la clase Cliente
 */

import org.joda.time.DateTime;

/**
 * @author Chambi orellana, Liza Melody
 *
 */
public class Cliente 
{
	// Variables de instancia.
	
	private String nombre;
	private String apellido;
	private Integer dni;
	private String direccion;
	private DateTime fechaDeNacimiento;
	private String mail;
	private DateTime fechaDeIngreso;
	
	// Contructor
	/**
	 * @param unNombre = Es el nombre del nuevo cliente.
	 * @param unApellido = Es el apellido del nuevo cliente.
	 * @param unDni = Es el DNI del nuevo cliente.
	 * @param unaDireccion = Es la direccion del nuevo cliente.
	 * @param fechaNacimiento = Es la fecha de nacimiento del nuevo cliente.
	 * @param unMail = Es el correo electronico del nuevo cliente.
	 * @param fechaIngreso = Es la fecha en la que el nuevo cliente ingresa en la base de datos de la concesionaria.
	 */
	public Cliente (String unNombre, String unApellido, Integer unDni, String unaDireccion, DateTime fechaNacimiento, String unMail, DateTime fechaIngreso)
	{
		this.cambiarNombre(unNombre);
		this.cambiarApellido(unApellido);
		this.cambiarDni(unDni);
		this.cambiarDireccion(unaDireccion);
		this.cambiarFechaDeNacimiento(fechaNacimiento);
		this.cambiarMail(unMail);
		this.cambiarFechaDeIngreso(fechaIngreso);
	}
	
	// Metodos
	
	/**
	 * PROPOSITO: Modifica el nombre del cliente.
	 * @param unNombre: Es el nuevo nombre que tendra el cliente.
	 */
	private void cambiarNombre(String unNombre)
	{
		this.nombre = unNombre;
	}
	
	/**
	 * PROPOSITO: Cambia el apellido del cliente.
	 * @param unApellido: Es el nuevo apellido que tendra el cliente.
	 */
	private void cambiarApellido(String unApellido)
	{
		this.apellido = unApellido;
	}
	
	/**
	 * PROPOSITO: Modifica el numero de DNI del cliente.
	 * @param unDni: Es el nuevo DNI que tendra el cliente.
	 */
	private void cambiarDni(Integer unDni)
	{
		this.dni = unDni;
	}
	
	/**
	 * PROPOSITO: Cambia la direccion del cliente.
	 * @param unaDireccion: Es la nueva direccion que tendra el cliente.
	 */
	private void cambiarDireccion(String unaDireccion)
	{
		this.direccion = unaDireccion;
	}
	
	/**
	 * PROPOSITO: Cambia la fecha de nacimiento del cliente.
	 * @param unaFechaNacimiento: Es la nueva fecha de nacimiento que tendra el cliente.
	 */
	private void cambiarFechaDeNacimiento(DateTime unaFechaNacimiento)
	{
		this.fechaDeNacimiento = unaFechaNacimiento;
	}
	
	/**
	 * PROPOSITO: Cambia la direccion de correo electronico del cliente.
	 * @param unMail: Es la nueva direccion de correo del cliente.
	 */
	private void cambiarMail(String unMail)
	{
		this.mail = unMail;
	}
	
	/**
	 * PROPOSITO: Cambia la fecha de ingreso del cliente en la base de datos de la concesionaria.
	 * @param unaFechaIngreso: Es la nueva fecha que indica el ingreso del cliente.
	 */
	private void cambiarFechaDeIngreso(DateTime unaFechaIngreso)
	{
		this.fechaDeIngreso = unaFechaIngreso;
	}
	
	/**
	 * @return Devuelve el numero de DNI del cliente.
	 */
	public Integer obtenerDni()
	{
		return this.dni;
	}
	
	/**
	 * @return Devuelve la fecha de ingreso del cliente a la base de datos de la concesionaria.
	 */
	public DateTime obtenerFechaDeIngreso()
	{
		return this.fechaDeIngreso;
	}

	/**
	 * @return Devuelve el nombre del cliente.
	 */
	public String obtenerNombre() 
	{
		return this.nombre;
	}

	/**
	 * @return Devuelve el apellido del cliente.
	 */
	public String obtenerApellido() 
	{
		return this.apellido;
	}

	/**
	 * @return Devuelve la direccion del cliente.
	 */
	public String obtenerDireccion() 
	{
		return this.direccion;
	}

	/**
	 * @return Devuelve la fecha de nacimiento del cliente.
	 */
	public DateTime obtenerFechaDeNacimiento() 
	{
		return this.fechaDeNacimiento;
	}

	/**
	 * @return Devuelve el correo electronico del cliente.
	 */
	public String obtenerCorreoElectronico() 
	{
		return this.mail;
	}
	
}

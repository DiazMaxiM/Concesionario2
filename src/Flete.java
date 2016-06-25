/**
 * Aca esta modelado la clase Flete
 */

/**
 * @author Chambi Orellana Liza
 */
public class Flete
{
	private int costoPorMetro;

	/**
	 * @param unCostoPorMetro:Es el costo que se cobrara por cada metro recorrido.
	 * ¡unCostoPorMetro > 0 !
	 */
	public Flete (int unCostoPorMetro)
	{
		this.cambiarCostoPorMetro(unCostoPorMetro);
	}

	private void cambiarCostoPorMetro(int unCostoPorMetro) 
	{
		this.costoPorMetro = unCostoPorMetro;
	}

	public int costo(int distanciaVial) 
	{
		return (distanciaVial * obtenerCostoPorMetro());
	}
	
	public int obtenerCostoPorMetro() 
	{
		return this.costoPorMetro;
	}
	
}

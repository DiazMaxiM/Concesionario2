
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@SuppressWarnings("unused")

/**
 * Esta Clase representa al plan de ahorro de una concesionaria
 * @author MaxiDiaz
 *
 */
public class PlanDeAhorro {
	
private ModalidadDeAdjudicacion modalidadDeAdjudacion;
private List<Participante> listaDeParticipantes= new ArrayList<Participante>();
private Integer numeroDeGrupo;
private TipoDeFinanciacion porcentajeDeFinanciacion;
private Modelo modelo;
private Integer cantidadDeCuotas;
	/**
	 * 
	 * @param modalidad = modalidad de adjudicacion que puede ser cualquier sub clase de la interfaz ModalidadDeAdjudicacion
	 * @param numeroDeGrupo = numero que representa al grupo (Integer)
	 * @param financiacion100 = String que representa el tipo de plan
	 * @param modelo = modelo del vehiculo por el cual se crea el plan
	 */
public PlanDeAhorro(ModalidadDeAdjudicacion modalidad,Integer numeroDeGrupo,TipoDeFinanciacion financiacion100,Modelo modelo,Integer cantidadDeCuotas) {
	this.modalidadDeAdjudacion= modalidad;
	this.numeroDeGrupo=numeroDeGrupo;
	this.porcentajeDeFinanciacion=financiacion100;
	this.modelo = modelo;
	this.cantidadDeCuotas=cantidadDeCuotas;
}
	/**
	 * 
	 * @return la lista de participantes
	 */
	public List<Participante> listaDeClientesAdjudicados() {
		/*List<Participante> listaAux = new ArrayList<Participante>();
		for (Participante participante : listaDeParticipantes) {
			if (participante.estaAdjudicado()){
				listaAux.add(participante);
			}
		}*/
		return listaDeParticipantes.stream().filter(p1->p1.estaAdjudicado()).collect(Collectors.toList());
	}

	/**
	 * 
	 * @return lista de Participantes
	 */
	public List<Participante> listaDeParticipantes() {
		return listaDeParticipantes;
	}
	
	/**
	 * 
	 * @return devuelve el Participante que salio adjudicado en este plan
	 */
	public Participante adjudicar() throws ExceptionAdjudicarPlanSinParticipantes{
		Participante ganador = modalidadDeAdjudacion.adjudicar(this);
		ganador.Adjudico();
		return ganador ;
	}
	/**
	 * 
	 * @return devuelve clientes que nunca adjudicaron
	 */
	
	public List<Participante> clientesQueNoAdjudicaron() {
		 return listaDeParticipantes.stream().filter(p1->!(p1.estaAdjudicado())).collect(Collectors.toList());
		
	}
	/**
	 * 
	 * @return la cantidad de participantes
	 */
	public Integer cantidadDeParticipantes (){
		return this.listaDeParticipantes.size();
	}
	/**
	 * 
	 * @param participante = participante que se va a agregar al plan 
	 */
	public void agregarParticipante(Participante participante) {
		listaDeParticipantes.add(participante);
	}
	public Integer cantidadDeCuotas() {
	
		return this.cantidadDeCuotas;
	}
	public float precioDelVehiculo() {
		return (float)this.modelo.precioMovil();
	}
		   
}

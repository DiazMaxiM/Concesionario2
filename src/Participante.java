
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
/**
 * 
 * @author MaxiDiaz
 *
 */
public class Participante {
private Cliente cliente;
private List<ComprobanteDePago> listaDeComprobantesDePago= new ArrayList<ComprobanteDePago>();
private boolean adjudico=false;
/**
 * 	
 * @param cliente = Cliente que representa al participante
 */
public Participante(Cliente cliente) {
	this.cliente= cliente;
	
}
/**
 * 
 * @return devuelve el cliente del participante
 */
	public Cliente obtenerCliente(){
		return this.cliente;
	}
	/**
	 * 
	 * @return devuelve el monto total pagado por el participante
	 */
	public float plataPagada() {
		double montoPagado=0;
		montoPagado= listaDeComprobantesDePago.stream().mapToDouble(comprobante -> comprobante.montoPagado()).sum();
		return (float)montoPagado;
	}
	/**
	 * @return devuelve si ya salio adjudicado este Participante
	 */
	public boolean estaAdjudicado() {
		return adjudico;
	}
	/**
	 * @param cambia el estado de adjudicacion del Participante
	 */
	public void Adjudico() {
		this.adjudico = true;
	}
	/**
	 * 
	 * @param p2 = Participante sobre el que se va a comparar
	 * @return -1,0,1 dependiendo que pago mas y quien es el mas antiguo
	 */
	public Integer compararQuienPagoMas(Participante p2) {
		if (this.plataPagada() > p2.plataPagada())
		{return 1;}
		else
		{
		if (this.plataPagada() < p2.plataPagada())
		{return -1;}
		if (this.plataPagada() == p2.plataPagada()){
			DateTime fechap1 =this.obtenerCliente().obtenerFechaDeIngreso();//getFechaDeIngreso();
			DateTime fechap2 =p2.obtenerCliente().obtenerFechaDeIngreso();
			
			if (fechap1.isBefore(fechap2) ){
				return 1;
			}
		}
		}
		return -1;
		
		}
	public void agregarComprobante(ComprobanteDePago comprobante) {
		listaDeComprobantesDePago.add(comprobante);
		
	}
	
}

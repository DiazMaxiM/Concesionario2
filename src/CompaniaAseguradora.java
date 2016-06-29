public class CompaniaAseguradora {

	private Participante participante;
	private PlanDeAhorro planDeAhorro;

	public CompaniaAseguradora(Participante participante, PlanDeAhorro planDeAhorro) {
		this.participante = participante;
		this.planDeAhorro = planDeAhorro;
	}

	public Float montoAAbonarPorParticipante() {
		return this.montoPorParticipante() + this.montoPorVehiculo();
	}

	private Float montoPorVehiculo() {
		return new Float(this.planDeAhorro.precioDelVehiculo() * 0.05);
	}

	private Float montoPorParticipante() {
		Integer edadParticipante = this.participante.obtenerCliente().obtenerEdad();
		if(edadParticipante >= 50){
			return new Float(((edadParticipante -50 )*10)+50);
		}
		else
		{
		return new Float(50);
		}
	}

	
}

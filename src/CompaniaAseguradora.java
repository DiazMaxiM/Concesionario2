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
		return this.planDeAhorro.precioDelVehiculo() * (float)0.5;
	}

	private Float montoPorParticipante() {
		Integer edadParticipante = this.participante.obtenerCliente().obtenerEdad();
		Float dineroAPagar=new Float(50);
		if(edadParticipante >= 50){
			Integer plusPorEdad = edadParticipante - 50;
			dineroAPagar+=(10 * (float)plusPorEdad);
		}
		return dineroAPagar;
	}

	
}


public class Financiacion100 implements TipoDeFinanciacion {

	public float montoDeLaCuota(PlanDeAhorro plan) {
		int cantidadDeCuotas = plan.cantidadDeCuotas();
		float valorVehiculo = plan.precioDelVehiculo();
		return (valorVehiculo/cantidadDeCuotas);
	}

}

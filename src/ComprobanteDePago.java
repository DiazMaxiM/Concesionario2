
public class ComprobanteDePago {

	private Integer numeroDeCuota;
	private float alicuota;
	private float gastosAdministrativos;
	private float seguroDeVida;
	
	public ComprobanteDePago(Integer numeroDeCuota, float alicuota, float gastosAdministrativos, float seguroDeVida) {
		numeroDeCuota(numeroDeCuota);
		alicuota(alicuota);
		gastosAdministrativos(gastosAdministrativos);
		seguroDeVida(seguroDeVida);
	}

	/**
	 * @return the numeroDeCuota
	 */
	public Integer obtenerNumeroDeCuota() {
		return numeroDeCuota;
	}

	/**
	 * @param numeroDeCuota the numeroDeCuota to set
	 */
	private void numeroDeCuota(Integer numeroDeCuota) {
		this.numeroDeCuota = numeroDeCuota;
	}

	/**
	 * @return the alicuota
	 */
	public float obtenerAlicuota() {
		return alicuota;
	}

	/**
	 * @param alicuota the alicuota to set
	 */
	private void alicuota(float alicuota) {
		this.alicuota = alicuota;
	}

	/**
	 * @return the gastosAdministrativos
	 */
	public float obtenerGastosAdministrativos() {
		return gastosAdministrativos;
	}

	/**
	 * @param gastosAdministrativos the gastosAdministrativos to set
	 */
	private void gastosAdministrativos(float gastosAdministrativos) {
		this.gastosAdministrativos = gastosAdministrativos;
	}

	/**
	 * @return the seguroDeVida
	 */
	public float obtenerSeguroDeVida() {
		return seguroDeVida;
	}

	/**
	 * @param seguroDeVida the seguroDeVida to set
	 */
	private void seguroDeVida(float seguroDeVida) {
		this.seguroDeVida = seguroDeVida;
	}

	public float montoPagado() {
		// TODO Auto-generated method stub
		return 0;
	}

}

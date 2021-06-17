
public class Persona {
	private Long numeroDocumento;
	private String nombre;

	public Persona(Long numeroDocumento, String nombre) {
		this.numeroDocumento = numeroDocumento;
		this.nombre = nombre;
	}
	
	/**
	 * @return the numeroDocumento
	 */
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}

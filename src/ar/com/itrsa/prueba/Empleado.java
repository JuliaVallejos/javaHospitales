public class Empleado extends Persona implements Cloneable {
	private Boolean activo;
	private Integer idEmpleado;
	
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}	
	
	public Empleado(String nombre, Boolean activo, Integer idEmpleado, Long numeroDocumento) {
		super(numeroDocumento, nombre);
		this.activo = activo;
		this.idEmpleado = idEmpleado;
	}
	
	public void procesar() throws Exception {
		System.out.println("******" + getNombre() + "*********");
		if(!this.activo) {
			throw new Exception("El empleado está inactivo");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Empleado) {
			Empleado other = (Empleado) obj;
			if(this.idEmpleado.equals(other.idEmpleado))
				return true;
			else
				return false;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return idEmpleado.intValue();
	}
}

package ClasesTP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
	
	private String nombre;
	private String direccion;
	private BigDecimal presupuesto;
	private Long idHospital;
	private List<Medico> listaMedicos= new ArrayList<Medico>();
	private List<Especialidad> listaEspecialidades = new ArrayList<Especialidad>();
	


	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}
	

	/*public Hospital(String nombre, String direccion, BigDecimal presupuesto) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.presupuesto = presupuesto;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Long getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(Long idHospital) {
		this.idHospital = idHospital;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Hospital) {
			Hospital other = (Hospital) obj;
			if(this.idHospital==null||other.idHospital==null) {
				return false;
			}
			if(this.idHospital.equals(other.idHospital))
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
		return idHospital.intValue();
	}

	public List<Especialidad> getListaEspecialidades() {
		return listaEspecialidades;
	}

	public void setListaEspecialidades(List<Especialidad> listaEspecialidades) {
		this.listaEspecialidades = listaEspecialidades;
	}

	

}

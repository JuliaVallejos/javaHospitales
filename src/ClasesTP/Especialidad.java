package ClasesTP;

import java.util.ArrayList;
import java.util.List;

public class Especialidad {
	private String nombre;
	private Long idEspecialidad;
	private List<Medico> listaMedicos= new ArrayList<Medico>();
	
	public Especialidad() {
		
		}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Long idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Especialidad) {
			Especialidad other = (Especialidad) obj;
			if(this.idEspecialidad==null||other.idEspecialidad==null) {
				return false;
			}
			else if(this.idEspecialidad.equals(other.idEspecialidad))
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
		return idEspecialidad.intValue();
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}
}

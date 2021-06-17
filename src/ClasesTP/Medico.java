package ClasesTP;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medico {
	
	private String nombre;
	private String apellido;
	private Integer dni;
	private BigDecimal sueldo;	
	private Date fechaNacimiento;
	private Especialidad especialidad;
	private Long idMedico;
	private List<Hospital> listaHospitales= new ArrayList<Hospital>();
	private List<Vacaciones> listaVacaciones = new ArrayList<Vacaciones>();
	
/*	public Medico(String nombre, String apellido, Integer dni, BigDecimal sueldo, Date fechaNacimiento,
			Especialidad especialidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sueldo = sueldo;
		this.fechaNacimiento = fechaNacimiento;
		this.especialidad = especialidad;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public List<Hospital> getListaHospitales() {
		return listaHospitales;
	}

	public void setListaHospitales(List<Hospital> listaHospitales) {
		this.listaHospitales = listaHospitales;
	}

	public List<Vacaciones> getListaVacaciones() {
		return listaVacaciones;
	}

	public void setListaVacaciones(List<Vacaciones> listaVacaciones) {
		this.listaVacaciones = listaVacaciones;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Medico) {
			Medico other = (Medico) obj;
			if(this.idMedico==null||other.idMedico==null) {
				return false;
			}
			else if(this.idMedico.equals(other.idMedico))
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
		return idMedico.intValue();
	}
	
}

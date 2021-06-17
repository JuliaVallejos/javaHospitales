package ClasesTP;

import java.util.Date;

public class Vacaciones {
	
	private Medico medico;
	private Hospital hospital;
	private Date fechaInicio;
	private Date fechaFin;
	private Long idVacaciones;
	
	public Vacaciones(Medico medico, Hospital hospital, Date fechaInicio, Date fechaFin) {
			super();
			this.medico = medico;
			this.hospital = hospital;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
		}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setIdHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Long getIdVacaciones() {
		return idVacaciones;
	}

	public void setIdVacaciones(Long idVacaciones) {
		this.idVacaciones = idVacaciones;
	}
}

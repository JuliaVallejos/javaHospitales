package ClasesTP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Prueba {
	public static void main(String[] args) {
		Prueba prueba = new Prueba();
		prueba.mostrarHospitales();
		
	//prueba.mostrarHospitalesPorMedico();
		
	//	prueba.mostrarVacaciones();
		
	//	prueba.promedioEspecialidades();
		
	//	prueba.mostrarPresupuestosInsuficientes();
	
	
	}

	public void mostrarHospitales() {
		DBConnection db = new DBConnection();
		List<Hospital> listaHospitales = db.getListaHospitales();
		
		for(Hospital hos : listaHospitales) {
			System.out.println("------------------------------------");
			System.out.println(hos.getNombre());
			System.out.println("Medicos: ");
			for(Medico med:hos.getListaMedicos()) {
				System.out.println("       * " + med.getNombre() + " " + med.getApellido() +" DNI: "+med.getDni() +" Sueldo: "+med.getSueldo());
			}
		}
	}
	public void mostrarHospitalesPorMedico() {
		DBConnection db = new DBConnection();
		Medico esclavo = new Medico();
		System.out.println(esclavo.getNombre());
		esclavo.setIdMedico(Long.valueOf(9));
		
		List<Hospital> listaHospitales = db.getHospitalesByIdMedico(esclavo);
		System.out.println(esclavo.getNombre());
		System.out.println("El médico " + esclavo.getNombre()+ " " +esclavo.getApellido() + " DNI: " + esclavo.getDni() +" trabaja en los siguientes hospitales:");
		for(Hospital hos:listaHospitales) {
	
			System.out.println("*  " +hos.getNombre());
		}
	}
	public void mostrarVacaciones() {
		DBConnection db = new DBConnection();
		List<Hospital> listaHospitales = db.getVacaciones();
		for(Hospital hos:listaHospitales){
			System.out.println("--------------------------------------------");
			System.out.println(hos.getNombre());
			for(Medico med:hos.getListaMedicos()) {
				System.out.println(" * " +med.getNombre() + " " + med.getApellido());
				for(Vacaciones vac:med.getListaVacaciones()) {
					System.out.println("    Desde: " + vac.getFechaInicio() + " Hasta: " + vac.getFechaFin());
				}
			}
		}
	}
	public void promedioEspecialidades() {
		DBConnection db = new DBConnection();
		 List<Hospital> listaHospitales = db.getSueldos();
	
			for(Hospital hos:listaHospitales) {
				System.out.println("------------------------------------");
				System.out.println(hos.getNombre());
				for(Especialidad esp:hos.getListaEspecialidades()) {
					System.out.println("-Especialidad: " + esp.getNombre());
					BigDecimal sumaSueldos = BigDecimal.valueOf(0);
				
			
					for(Medico med:esp.getListaMedicos()) {
					
						sumaSueldos=sumaSueldos.add(med.getSueldo());
						
					}
					BigDecimal promedio =sumaSueldos.divide(BigDecimal.valueOf(esp.getListaMedicos().size()));
					System.out.println("--------Suma sueldos: "+sumaSueldos);
					System.out.println("           *Promedio: "+promedio);
				}
				
				
			
			}
	}
	public void mostrarPresupuestosInsuficientes() {
		DBConnection db= new DBConnection();
		List<Hospital> listaHospitales = db.presupuestosInsuficientes();
		System.out.println("Hospitales con presupuesto menor a la suma de los sueldos de sus médicos");
		System.out.println();
		for(Hospital hos:listaHospitales) {
			BigDecimal suma = BigDecimal.valueOf(0);
			
			for(Medico med:hos.getListaMedicos()) {
				suma=suma.add(med.getSueldo());
	
			}
			if(hos.getPresupuesto().compareTo(suma)==-1) {
				System.out.println(hos.getNombre() + ". Presupuesto: $" + hos.getPresupuesto() + " Suma sueldos: $ "+suma);
			}

			
		}
	}
}

package ClasesTP;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBConnection {

	//Todos los hospitales y sus médicos
	public List<Hospital>  getListaHospitales(){
		List<Hospital> listaHospitales = new ArrayList<Hospital>();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection conn= null;

	try {
		conn= DriverManager.getConnection("jdbc:mysql://localhost/pruebaitr","root","12345");		

		
		PreparedStatement ps= conn.prepareStatement("select hos.ID_HOSPITAL ID_HOSPITAL,hos.NOMBRE HOSPITAL,hos.PRESUPUESTO PRESUPUESTO,hos.DIRECCION DIRECCION, med.ID_MEDICO ID_MEDICO,med.NOMBRE NOMBRE,med.APELLIDO APELLIDO,med.DNI DNI,med.SUELDO SUELDO "
				+ "from relacion_medico_hospital rel "
				+ "inner join hospital hos on rel.ID_HOSPITAL=hos.ID_HOSPITAL "
				+ "inner join medico med on rel.ID_MEDICO=med.ID_MEDICO "
				+ "order by rel.ID_HOSPITAL");

		ResultSet result = ps.executeQuery();

		
		
		while(result.next()) {
			Long IdMedico = result.getLong("ID_MEDICO");
			String nombreMedico = result.getString("NOMBRE");
			String apellidoMedico = result.getString("APELLIDO");
			Integer dniMedico = result.getInt("DNI");
			BigDecimal sueldo = result.getBigDecimal("SUELDO");
			Long IdHospital = result.getLong("ID_HOSPITAL");
			String hospital = result.getString("HOSPITAL");
			String direccion = result.getString("DIRECCION");
			BigDecimal presupuesto = result.getBigDecimal("PRESUPUESTO");
			
			
			Medico medico1=new Medico();
			medico1.setIdMedico(IdMedico);
			medico1.setNombre(nombreMedico);
			medico1.setApellido(apellidoMedico);
			medico1.setDni(dniMedico);
			medico1.setSueldo(sueldo);
			
			Hospital hospital1= new Hospital();
			hospital1.setIdHospital(IdHospital);
			hospital1.setNombre(hospital);
			hospital1.setDireccion(direccion);
			hospital1.setPresupuesto(presupuesto);
			
			if(!listaHospitales.contains(hospital1)) {
				hospital1.getListaMedicos().add(medico1);
				listaHospitales.add(hospital1);
			
			}else {
				int indice = listaHospitales.indexOf(hospital1);
				listaHospitales.get(indice).getListaMedicos().add(medico1);
			}
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	return listaHospitales;
	
	}
	
	//Todos los hospitales a los que pertenece un médico en particular
	public List<Hospital>  getHospitalesByIdMedico(Medico med){
		
	List<Hospital> listaHospitales = new ArrayList<Hospital>();
	

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection conn= null;

	try {
		conn= DriverManager.getConnection("jdbc:mysql://localhost/pruebaitr","root","12345");		

		PreparedStatement ps= conn.prepareStatement(" select med.ID_MEDICO, med.NOMBRE,med.APELLIDO,med.DNI,med.SUELDO,hos.ID_HOSPITAL ID_HOSPITAL, hos.NOMBRE HOSPITAL \r\n"
				+ "	from relacion_medico_hospital rel \r\n"
				+ "	inner join hospital hos on rel.ID_HOSPITAL=hos.ID_HOSPITAL \r\n"
				+ "	inner join medico med on rel.ID_MEDICO=med.ID_MEDICO \r\n"
				+ "	where rel.ID_MEDICO=?");
		ps.setLong(1, med.getIdMedico());
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			Long IdMedico = result.getLong("ID_MEDICO");
			String nombreMedico = result.getString("NOMBRE");
			String apellidoMedico = result.getString("APELLIDO");
			Integer dniMedico = result.getInt("DNI");
			BigDecimal sueldo = result.getBigDecimal("SUELDO");
			Long IdHospital = result.getLong("ID_HOSPITAL");
			String hospital = result.getString("HOSPITAL");
		
		
			med.setIdMedico(IdMedico);
			med.setNombre(nombreMedico);
			med.setApellido(apellidoMedico);
			med.setDni(dniMedico);
			med.setSueldo(sueldo);
			
			Hospital hospital1= new Hospital();
			hospital1.setIdHospital(IdHospital);
			hospital1.setNombre(hospital);

		
			
			if(!med.getListaHospitales().contains(hospital1)) {
				med.getListaHospitales().add(hospital1);
		
			}
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	return med.getListaHospitales();
	
	}
	//Lista de hospitales con sus médicos y vacaciones
	
	public List<Hospital>  getVacaciones(){
		
	List<Hospital> listaHospitales = new ArrayList<Hospital>();


	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection conn= null;

	try {
		conn= DriverManager.getConnection("jdbc:mysql://localhost/pruebaitr","root","12345");		

		PreparedStatement ps= conn.prepareStatement(" select hos.ID_HOSPITAL ID_HOSPITAL,hos.NOMBRE HOSPITAL,med.ID_MEDICO ID_MEDICO,med.NOMBRE NOMBRE,med.APELLIDO APELLIDO,vac.FECHA_INICIO FECHA_INICIO,vac.FECHA_FIN FECHA_FIN \r\n"
				+ "	from vacaciones vac \r\n"
				+ "	inner join hospital hos on vac.ID_HOSPITAL=hos.ID_HOSPITAL \r\n"
				+ " inner join  medico med on vac.ID_MEDICO=med.ID_MEDICO \r\n"
				+ " order by vac.FECHA_INICIO desc;");

		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			Long IdMedico = result.getLong("ID_MEDICO");
			String nombreMedico = result.getString("NOMBRE");
			String apellidoMedico = result.getString("APELLIDO");
			Date vacFechaInicio = result.getTimestamp("FECHA_INICIO");
			Date vacFechaFin = result.getTimestamp("FECHA_FIN");
			Long idHospital = result.getLong("ID_HOSPITAL");
			String hospital = result.getString("HOSPITAL");
		
			Medico med =new Medico();
			med.setIdMedico(IdMedico);
			med.setNombre(nombreMedico);
			med.setApellido(apellidoMedico);
	
	
			Hospital hos= new Hospital();
			hos.setIdHospital(idHospital);
			hos.setNombre(hospital);

			Vacaciones vacaciones = new Vacaciones(med,hos,vacFechaInicio,vacFechaFin);
		
			if(listaHospitales.contains(hos)) {
				int index = listaHospitales.indexOf(hos);
				if(listaHospitales.get(index).getListaMedicos().contains(med)) {
					int indMed = listaHospitales.get(index).getListaMedicos().indexOf(med);
					listaHospitales.get(index).getListaMedicos().get(indMed).getListaVacaciones().add(vacaciones);
					
				}else {
					med.getListaVacaciones().add(vacaciones);
					listaHospitales.get(index).getListaMedicos().add(med);
				}
			
			
			}else {
				med.getListaVacaciones().add(vacaciones);
				hos.getListaMedicos().add(med);
				listaHospitales.add(hos);
			}
			
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	return listaHospitales;
	
	}
	//Lista de hospitales con sus médicos y especialidad
	public List<Hospital>  getSueldos(){
		
		List<Hospital> listaHospitales = new ArrayList<Hospital>();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn= null;

		try {
			conn= DriverManager.getConnection("jdbc:mysql://localhost/pruebaitr","root","12345");		

			PreparedStatement ps= conn.prepareStatement("select hos.ID_HOSPITAL ID_HOSPITAL,hos.NOMBRE HOSPITAL, med.ID_MEDICO ID_MEDICO,med.NOMBRE NOMBRE,med.APELLIDO APELLIDO,med.DNI DNI,med.SUELDO SUELDO, esp.ID_ESPECIALIDAD ID_ESPECIALIDAD, esp.NOMBRE ESPECIALIDAD\r\n"
					+ "from relacion_medico_hospital rel\r\n"
					+ "inner join hospital hos on rel.ID_HOSPITAL=hos.ID_HOSPITAL\r\n"
					+ "inner join medico med on rel.ID_MEDICO=med.ID_MEDICO\r\n"
					+ "inner join especialidad esp on esp.ID_ESPECIALIDAD=med.ID_ESPECIALIDAD\r\n"
					+ "order by rel.ID_HOSPITAL");

			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				Long IdMedico = result.getLong("ID_MEDICO");
				String nombreMedico = result.getString("NOMBRE");
				String apellidoMedico = result.getString("APELLIDO");
				BigDecimal sueldo = result.getBigDecimal("SUELDO");
				Long idEspecialidad = result.getLong("ID_ESPECIALIDAD");
				String especialidad = result.getString("ESPECIALIDAD");
				Long idHospital = result.getLong("ID_HOSPITAL");
				String hospital = result.getString("HOSPITAL");
			
				Medico med =new Medico();
				med.setIdMedico(IdMedico);
				med.setNombre(nombreMedico);
				med.setApellido(apellidoMedico);
				med.setSueldo(sueldo);
		
		
				Hospital hos= new Hospital();
				hos.setIdHospital(idHospital);
				hos.setNombre(hospital);

				Especialidad esp = new Especialidad();
				esp.setNombre(especialidad);
				esp.setIdEspecialidad(idEspecialidad);
	
				
				if(listaHospitales.contains(hos)) {
					int index = listaHospitales.indexOf(hos);
					if(listaHospitales.get(index).getListaEspecialidades().contains(esp)) {
					
						int indEsp = listaHospitales.get(index).getListaEspecialidades().indexOf(esp);
						listaHospitales.get(index).getListaEspecialidades().get(indEsp).getListaMedicos().add(med);
						listaHospitales.get(index).getListaMedicos().add(med);	
					}else {
						esp.getListaMedicos().add(med);
						listaHospitales.get(index).getListaEspecialidades().add(esp);
						
					}
							
				}else {
				
					esp.getListaMedicos().add(med);
					hos.getListaEspecialidades().add(esp);
					listaHospitales.add(hos);
				
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}
		return listaHospitales;
		
		}
	
	//Lista de hospitales cuyo presupuesto sea menor a la suma del salario de sus médicos
	public List<Hospital>  presupuestosInsuficientes(){
		
		List<Hospital> listaHospitales = new ArrayList<Hospital>();


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn= null;

		try {
			conn= DriverManager.getConnection("jdbc:mysql://localhost/pruebaitr","root","12345");		

			PreparedStatement ps= conn.prepareStatement("select hos.ID_HOSPITAL ID_HOSPITAL,hos.NOMBRE HOSPITAL,hos.PRESUPUESTO PRESUPUESTO,med.ID_MEDICO ID_MEDICO,med.NOMBRE NOMBRE, med.APELLIDO APELLIDO, med.SUELDO SUELDO\r\n"
					+ "	from relacion_medico_hospital rel \r\n"
					+ "	inner join medico med on rel.ID_MEDICO=med.ID_MEDICO \r\n"
					+ "	inner join hospital hos on rel.ID_HOSPITAL=hos.ID_HOSPITAL \r\n"
					+ "	order by hos.ID_HOSPITAL;");

			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				Long idHospital = result.getLong("ID_HOSPITAL");
				String hospital = result.getString("HOSPITAL");
				Long IdMedico = result.getLong("ID_MEDICO");
				String nombre = result.getString("NOMBRE");
				String apellido = result.getString("APELLIDO");
				BigDecimal sueldo = result.getBigDecimal("SUELDO");
				BigDecimal presupuesto = result.getBigDecimal("PRESUPUESTO");
			
				
		
				Hospital hos= new Hospital();
				hos.setIdHospital(idHospital);
				hos.setNombre(hospital);
				hos.setPresupuesto(presupuesto);

				
				Medico med = new Medico();
				med.setIdMedico(IdMedico);
				med.setNombre(nombre);
				med.setApellido(apellido);
				med.setSueldo(sueldo);

				if(!listaHospitales.contains(hos)) {
					hos.getListaMedicos().add(med);
					listaHospitales.add(hos);
				}else {
					int indice=listaHospitales.indexOf(hos);
					listaHospitales.get(indice).getListaMedicos().add(med);
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}
		return listaHospitales;
		
		}
}

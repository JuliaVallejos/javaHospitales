
public class Prueba1 {
	
	public static void main(String[] args) {
		Empleado e1 = new Empleado("Martin", Boolean.TRUE, 1, Long.valueOf(12121));
		Empleado e2 = new Empleado("Jose", null, 2, Long.valueOf(22222));
		Empleado e3 = new Empleado("Juan", Boolean.FALSE, 3, Long.valueOf(3333));
		
		int[] numeros = new int[3];
		numeros[0] = 1;
		numeros[1] = 544;
		numeros[2] = 334;
		
		Empleado[] empleados = new Empleado[3];
		empleados[0] = e1;
		empleados[1] = e2;
		empleados[2] = e3;
//		empleados[3] = new Empleado("asdasd", Boolean.FALSE, 1121, 123123L);

		System.out.println("Array cargado");

		for (int i = 0; i < empleados.length; i++) {
			if(empleados[i].getActivo() == null) {
				System.out.println("Nombre: " + empleados[i].getNombre() + ". Activo: NULL");
			}
			else if(empleados[i].getActivo() == false) { // igual if(!empleados[i].getActivo())
				System.out.println("Nombre: " + empleados[i].getNombre() + ". Activo: FALSE");
			}
			else {
				System.out.println("Nombre: " + empleados[i].getNombre() + ". Activo: TRUE");
			}
		}
		
		//Si Null implica que sea false en la logica de la app
		for (int i = 0; i < empleados.length; i++) {
			
			boolean activo = (empleados[i].getActivo() == null || !empleados[i].getActivo()) ? false : true;
			
			if(activo) {
				System.out.println("Nombre22: " + empleados[i].getNombre() + ". Activo: FALSE");
			}
			else { 
				System.out.println("Nombre22: " + empleados[i].getNombre() + ". Activo: TRUE");
			}
			
		}

		int j = 0;
		while(j == 10) {
			System.out.println(j);
			j++;
		}
		System.out.println("-------------");
		j = 0;
		do {
			System.out.println(j);
			j++;
		} while(j == 0);
		
		//Quiero buscar el Empleado de ID 2
		Integer idBuscar = Integer.valueOf(2);
		for (int i = 0; i < empleados.length; i++) {
			Empleado e = empleados[i];
			
			if(idBuscar.equals(e.getIdEmpleado())) {
				System.out.println("Encontrado: " + e.getNombre());
				break;
			}
			System.out.println("Nombre: " + e.getNombre());
		}
	}
}

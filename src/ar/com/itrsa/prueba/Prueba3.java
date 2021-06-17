import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prueba3 {
	
	public static void main(String[] args) {
		Empleado e1 = new Empleado("Martin", Boolean.TRUE, 1, Long.valueOf(1000));
		Empleado e2 = new Empleado("Jose", Boolean.TRUE, 2, null);
		Empleado e3 = new Empleado("Juan", Boolean.FALSE, 3, Long.valueOf(3333));

		//Collecciones
		
		/* SET */
		Set<Empleado> conjunto = new HashSet<Empleado>();
		conjunto.add(e1);
		conjunto.add(e3);
		conjunto.add(e2);
		
		//Forma 1 de recorrer
		Iterator<Empleado> iter = conjunto.iterator();
		while(iter.hasNext()) {
			Empleado num = iter.next();
			System.out.println("Numero1: " + num.getNombre());
		}
		System.out.println("-----------");
		//Forma 2 de recorrer
		for (Empleado emp : conjunto) {
			System.out.println("Numero2: " + emp.getIdEmpleado());
		}

		System.out.println("-----------");

		//Saber si existe el empleado con id 2
		boolean existe = false;
		for (Empleado emp : conjunto) {
			if(emp.getIdEmpleado().equals(Integer.valueOf(2))) {
				existe = true;
				break;
			}
		}
		System.out.println("Existe emp 2: " + existe);
		
		Empleado e2nuevo = new Empleado(null, null, 2, null);

		System.out.println("Existe Emp1: " + e2.equals(e2nuevo));

		System.out.println("Existe Emp1000: " + e2.equals(Integer.valueOf(222)));

		
		boolean existeEmpleado = conjunto.contains(e2nuevo);

		System.out.println("Existe Emp2: " + existeEmpleado);

		System.out.println("-----------");
		
		conjunto.add(e2nuevo);
		
//		conjunto.remove(e2);

		//Forma 1 de recorrer
		Iterator<Empleado> iter1 = conjunto.iterator();
		while(iter1.hasNext()) {
			Empleado emp = iter1.next();
			System.out.println("Numero1: " + emp.getIdEmpleado() + ". Nombre: " + emp.getNombre());
		}
		
		System.out.println("-----------");

		// LIST 
		List<Empleado> lista = new ArrayList<Empleado>();
		lista.add(e1);
		lista.add(e3);
		lista.add(e2);

		//Forma 1 de recorrer y borrado seguro
		Iterator<Empleado> iter2 = lista.iterator();
		while(iter2.hasNext()) {
			Empleado num = iter2.next();
			System.out.println("NumeroList1: " + num.getIdEmpleado());
			if(num.getIdEmpleado().equals(Integer.valueOf(2))) {
				iter2.remove();
			}
		}

		//Forma 2 de recorrer
		for (Empleado integer : lista) {
			System.out.println("NumeroList2: " + integer.getIdEmpleado());
		}

//		lista.remove(e2);

		//Forma 3 de recorrer y borrado inconsistente puede lanzar exception (ConcurrentModificationException)
		for (int i = 0; i < lista.size(); i++) {
			Empleado num = lista.get(i);
			if(num.getIdEmpleado().equals(Integer.valueOf(2))) {
				lista.remove(i);
			}
		}
		
		for (Empleado integer : lista) {
			System.out.println("NumeroList4: " + integer.getIdEmpleado());
		}

		lista.add(e2);

		for (Empleado integer : lista) {
			System.out.println("NumeroList5: " + integer.getIdEmpleado());
		}

		//Si quiero tomar el último elemento de la lista
		System.out.println("Ultimo: " + lista.get(lista.size()-1).getIdEmpleado());
		//Si quiero tomar el primer elemento de la lista
		System.out.println("Primero: " + lista.get(0).getIdEmpleado());

		System.out.println("Indice del número e3: " + lista.indexOf(e2));
		
		//Si quiero saber si la lista tiene un elemento en particular
		System.out.println("La lista tiene el e1? " + lista.contains(e1));

		//Nombre de las personas por ID
		HashMap<Integer, Empleado> personasMap = new HashMap<Integer, Empleado>();
		personasMap.put(Integer.valueOf(1), e1);
		personasMap.put(Integer.valueOf(3), e3);
		personasMap.put(Integer.valueOf(2), e2);
		personasMap.put(Integer.valueOf(4), e1);
		
		Empleado emp = personasMap.get(Integer.valueOf(3));

		System.out.println("N: " + emp.getNombre() + ". id: " + emp.getIdEmpleado());
		
		Empleado e1get = personasMap.get(Integer.valueOf(1));
		e1get.setNombre("asasdaasd");
		System.out.println("Nombre e1: " + e1get.getNombre());
		Empleado e4get = personasMap.get(Integer.valueOf(4));
		System.out.println("Nombre e4: " + e4get.getNombre());

		//Recorrer 1
		Iterator<Integer> iterMap = personasMap.keySet().iterator();
		while(iterMap.hasNext()) {
			Integer indice = iterMap.next();
			Empleado emp1 = personasMap.get(indice);
			System.out.println("R1: " + emp1.getIdEmpleado());
		}
		//Recorrer 2
		for (Integer indice : personasMap.keySet()) {
			Empleado emp1 = personasMap.get(indice);
			System.out.println("R2: " + emp1.getIdEmpleado());
		}
		
		//Para ver si una clave existe
		boolean existe11 = personasMap.containsKey(Integer.valueOf(3));
		System.out.println(" Existe el 3? " + existe11);

		//Para ver si un valor existe
		boolean existe2 = personasMap.containsValue(new Empleado(null, null, 2, null));
		System.out.println(" Existe? " + existe2);

		//Si quiero reemplazar un valor
		Empleado juan = personasMap.get(Integer.valueOf(4));
		System.out.println("Antes del cambio: " + juan.getNombre());
		personasMap.replace(Integer.valueOf(4), new Empleado("Pedro", null, 2, null)); // personasMap.put(Integer.valueOf(4), "Juan4");
		Empleado juan2 = personasMap.get(Integer.valueOf(4));
		System.out.println("Después del cambio: " + juan2.getNombre());

		//Para remover
		personasMap.remove(Integer.valueOf(3));
		//Recorrer 2
		for (Integer indice : personasMap.keySet()) {
			Empleado nombre1 = personasMap.get(indice);
			System.out.println("Sin3: " + nombre1.getNombre());
		}
		
		//Map de Empleados y Proyectos
		Map<Empleado,List<Proyecto>> mapa = new HashMap<Empleado,List<Proyecto>>();
		
	}
	
}

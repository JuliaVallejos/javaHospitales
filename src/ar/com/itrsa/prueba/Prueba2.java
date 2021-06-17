import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Prueba2 {
	
	public static void main(String[] args) {
		Empleado e1 = new Empleado("Martin", Boolean.TRUE, 1, Long.valueOf(1000));
		Empleado e2 = new Empleado("Jose", Boolean.TRUE, 2, null);
		Empleado e3 = new Empleado("Juan", Boolean.FALSE, 3, Long.valueOf(3333));

		Empleado[] empleados = new Empleado[3];
		empleados[0] = e1;
		empleados[1] = e2;
		empleados[2] = e3;
//		empleados[3] = new Empleado("asdasd", Boolean.FALSE, 1121, 123123L);

		System.out.println("Array cargado");

		//Si el numero de documento es igual a 1000 imprimir el nombre de la persona
		for (int i = 0; i < empleados.length; i++) {
			try {
				if(empleados[i].getNumeroDocumento().equals(1000l)) {
					System.out.println("NroDoc 1000: " + empleados[i].getNumeroDocumento());
				}
				else {
					System.out.println("NroDoc !1000: " + empleados[i].getNumeroDocumento());
				}
			}
			catch (NullPointerException e) {
				System.out.println("NroDoc err1: " + empleados[i].getNumeroDocumento());
				e.printStackTrace();
			}
			catch (Exception e) {
				System.out.println("NroDoc err: " + empleados[i].getNumeroDocumento());
			}
		}

		try {
			e1.procesar();
			e3.procesar();
			e2.procesar();

		} catch (Exception e) {
			System.out.println("ERRRRRRRRROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		//
		IntLista intLista = null;
		boolean paramOrder = false;
		if(paramOrder) {
			intLista = new ListaOrdenada();
		}
		else {
			intLista = new ListaDesordenada();			
		}
		
		intLista.agregar(null);

		//Collecciones
		
		/* SET */
		Set<Integer> conjunto = new HashSet<Integer>();
		conjunto.add(Integer.valueOf(2));
		conjunto.add(Integer.valueOf(2));
		conjunto.add(Integer.valueOf(2));
		
		//Forma 1 de recorrer
		Iterator<Integer> iter = conjunto.iterator();
		while(iter.hasNext()) {
			Integer num = iter.next();
			System.out.println("Numero1: " + num);
		}

		//Forma 2 de recorrer
		for (Integer integer : conjunto) {
			System.out.println("Numero2: " + integer);
		}
		
		conjunto.remove(Integer.valueOf(2));

		//Forma 1 de recorrer
		Iterator<Integer> iter1 = conjunto.iterator();
		while(iter1.hasNext()) {
			Integer num = iter1.next();
			System.out.println("Numero1: " + num);
		}

		//Forma 2 de recorrer
		for (Integer integer : conjunto) {
			System.out.println("Numero2: " + integer);
		}
		System.out.println("---------------");

		/* LIST */
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(Integer.valueOf(100));
		lista.add(Integer.valueOf(200));
		lista.add(Integer.valueOf(300));

		//Forma 1 de recorrer
		Iterator<Integer> iter2 = lista.iterator();
		while(iter2.hasNext()) {
			Integer num = iter2.next();
			System.out.println("NumeroList1: " + num);
		}

		//Forma 2 de recorrer
		for (Integer integer : lista) {
			System.out.println("NumeroList2: " + integer);
		}

		lista.remove(Integer.valueOf(200));

		//Forma 3 de recorrer
		for (int i = 0; i < lista.size(); i++) {
			Integer num = lista.get(i);
			System.out.println("NumeroLista3: " + num);
		}
		//Si quiero tomar el último elemento de la lista
		System.out.println("Ultimo: " + lista.get(lista.size()-1));
		//Si quiero tomar el primer elemento de la lista
		System.out.println("Primero: " + lista.get(0));
		
		//Si quiero saber el índice del número 300
		System.out.println("Indice del número 300" + lista.indexOf(Integer.valueOf(300)));
		
		//Si quiero saber si la lista tiene un elemento en particular
		System.out.println("La lista tiene el 300? " + lista.contains(Integer.valueOf(300)));
		
		//Nombre de las personas por ID
		HashMap<Integer, String> personasMap = new HashMap<Integer, String>();
		personasMap.put(Integer.valueOf(1), "Juan1");
		personasMap.put(Integer.valueOf(3), "Juan3");
		personasMap.put(Integer.valueOf(2), "Juan2");
		personasMap.put(Integer.valueOf(4), "Juan1");
		
		String nombre = personasMap.get(Integer.valueOf(3));

		System.out.println("N: " + nombre);
		
		//Recorrer 1
		Iterator<Integer> iterMap = personasMap.keySet().iterator();
		while(iterMap.hasNext()) {
			Integer indice = iterMap.next();
			String nombre1 = personasMap.get(indice);
			System.out.println("R1: " + nombre1);
		}
		
		//Recorrer 2
		for (Integer indice : personasMap.keySet()) {
			String nombre1 = personasMap.get(indice);
			System.out.println("R2: " + nombre1);
		}

		//Para ver si una clave existe
		boolean existe = personasMap.containsKey(Integer.valueOf(20));
		System.out.println(" Existe el 20? " + existe);

		//Para ver si un valor existe
		boolean existe2 = personasMap.containsValue("Juan2");
		System.out.println(" Existe? " + existe2);

		//Si quiero reemplazar un valor
		String juan = personasMap.get(Integer.valueOf(4));
		System.out.println("Antes del cambio: " + juan);
		personasMap.replace(Integer.valueOf(4), "Juan4"); // personasMap.put(Integer.valueOf(4), "Juan4");
		String juan2 = personasMap.get(Integer.valueOf(4));
		System.out.println("Después del cambio: " + juan2);
		
		//Para remover
		personasMap.remove(Integer.valueOf(3));
		//Recorrer 2
		for (Integer indice : personasMap.keySet()) {
			String nombre1 = personasMap.get(indice);
			System.out.println("Sin3: " + nombre1);
		}

	}
	
}


public class ListaOrdenada implements IntLista {

	@Override
	public void agregar(Object e) {
		System.out.println("Agregar en ListaOrdenada");
	}

	@Override
	public void eliminar(Object e) {
		System.out.println("Eliminar en ListaOrdenada");
	}

	@Override
	public Object get() {
		System.out.println("Get en ListaOrdenada");
		return null;
	}
	
	public String mensaje() {
		return "LISTAORD";
	}

}

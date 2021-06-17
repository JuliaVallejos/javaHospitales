
public class ListaDesordenada implements IntLista {

	@Override
	public void agregar(Object e) {
		System.out.println("Agregar en ListaDesordenada");
	}

	@Override
	public void eliminar(Object e) {
		System.out.println("Eliminar en ListaDesordenada");
	}

	@Override
	public Object get() {
		System.out.println("Get en ListaDesordenada");
		return null;
	}

	public String mensajeNuevo() {
		return "LISTADESORD";
	}

}

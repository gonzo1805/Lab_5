package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public class BitsVectorSetImpl<T extends Enumerable<T>> implements ConjuntoNumerable<T> {

	/**
	 * Arreglo simple donde se guardaran los datos, unico atributo de la clase
	 */
	T[] lista;

	/**
	 * Contructor de tamaño standart
	 */
	public BitsVectorSetImpl() {
		lista = (T[]) new Object[1000];
	}

	/**
	 * Contructor de tamaño personalizado
	 * 
	 * @param tamano
	 *            el tamaño personalizado
	 */
	public BitsVectorSetImpl(int tamano) {
		lista = (T[]) new Object[tamano];
	}

	/**
	 * Une todos los datos no repetidos de los conjuntos A y B y lo retorna en
	 * uno tercero
	 * 
	 * @param A
	 *            conjunto a unir
	 * @param B
	 *            conjunto a unir
	 * @return el conjunto con la union de todos los datos no repetidos de los
	 *         conjuntos A y B
	 */
	@Override
	public ConjuntoNumerable<T> union(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		ConjuntoNumerable<T> resultado = new BitsVectorSetImpl<T>();// Nuevo
																	// conjunto

		Iterator<T> itA = A.iterator();// Iterador A
		Iterator<T> itB = B.iterator();// Iterador B

		while (itA.hasNext()) {// Iteramos por todo A
			resultado.add(itA.next());// Añadimos a resultado
		}
		while (itB.hasNext()) {// Iteramos por todo B
			T insercion = itB.next();
			if (!A.contains(insercion)) {// Lo que no esta en A
				resultado.add(insercion);// Se inserta en resultado
			}
		}
		return resultado;// Retorna resultado
	}

	/**
	 * Interseca los datos de los conjuntos A y B y los retorna en un tercer
	 * conjunto, la interseccion son los datos que estan en el cconjunto A y al
	 * mismo tiempo en el B
	 * 
	 * @param A
	 *            conjunto a intersecar
	 * @param B
	 *            conjunto a intersecar
	 * @return el conjunto con la interseccion de los datos de los conjuntos A y
	 *         B
	 */
	@Override
	public ConjuntoNumerable<T> intersection(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		ConjuntoNumerable<T> resultado = new BitsVectorSetImpl<T>();// Nuevo
																	// conjunto

		Iterator<T> itB = B.iterator();// Iterador B

		while (itB.hasNext()) {// Iteramos por B
			T dato = itB.next();
			if (A.contains(dato)) {// Si A lo contiene
				resultado.add(dato);// Lo añadimos a resultado
			}
		}
		return resultado;// Retorna resultado
	}

	/**
	 * Hace una diferencia entre los datos del conjunto A a los del conjunto B y
	 * los retorna en uno tercero, la diferencia son todos los datos que estan
	 * en el conjunto A y que no estan en B
	 * 
	 * @param A
	 *            elemento base para la diferencia
	 * @param B
	 *            elemento que "resta" en la diferencia
	 * @return datos resultantes de la diferencia de A con B
	 */
	@Override
	public ConjuntoNumerable<T> difference(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		ConjuntoNumerable<T> resultado = new BitsVectorSetImpl<T>();// Nuevo
																	// conjunto

		Iterator<T> itA = A.iterator();// Iterador A

		while (itA.hasNext()) {// Iteramos por A
			T dato = itA.next();
			if (!B.contains(dato)) {// Si B no lo tiene
				resultado.add(dato);// Añadimso a resultado
			}
		}

		return resultado;// Retorna resultado
	}

	/**
	 * Retorna un boolean que dice si el elemento esta en el conjunto o no
	 * 
	 * @param dato
	 *            lo que se quiere buscar en el conjunto
	 * @return un boolean que dice si el elemento esta en el conjunto o no
	 */
	@Override
	public boolean contains(T dato) {
		return (this.lista[dato.getIndex()] != null);// Si su index en el array
														// es null
	}

	/**
	 * Limpia la lista a dejarla sin datos
	 */
	@Override
	public void clear() {
		this.lista = (T[]) new Object[lista.length];
	}

	/**
	 * Añade un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere agregar al conjunto
	 */
	@Override
	public void add(T dato) {
		if (this.lista.length < dato.getIndex()) {// Si el index pasa los
													// limites de la lista
			T[] listaNueva = (T[]) new Object[dato.getIndex() + 1];// Nueva
																	// lista
			Iterator<T> it = this.iterator();

			T data;

			while (it.hasNext()) {// Pasa los datos de la vieja a la nueva
				data = it.next();
				listaNueva[data.getIndex()] = data;
			}
			lista = listaNueva;
		}
		this.lista[dato.getIndex()] = dato;// Inserta el dato en la lista
	}

	/**
	 * Elimina un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere eliminar del conjunto
	 */
	@Override
	public void remove(T dato) {
		if (this.lista[dato.getIndex()] == null) {// Si no esta en la lista
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("El elemento no esta en la lista");
			throw f;
		}
		if (this.isEmpty()) {// Si lista vacia
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		this.lista[dato.getIndex()] = null;// Borra el dato
	}

	/**
	 * Retorna un boolean que dice si el conjunto asignado al this es igual en
	 * todos sus elementos al conjunto A
	 * 
	 * @param A
	 *            el conjunto que se compara con el asignado en this
	 * @return boolean que dice si el conjunto asignado al this es igual en
	 *         todos sus elementos al conjunto A
	 */
	@Override
	public boolean Equals(ConjuntoNumerable<T> A) {
		Iterator<T> itA = A.iterator();// Iterador A
		Iterator<T> itThis = this.iterator();// Iterador this

		while (itA.hasNext()) {// Itera todo A
			if (!this.contains(itA.next())) {// Si algo no esta en this
				return false;// No son iguales
			}
		}
		while (itThis.hasNext()) {// Itera todo this
			if (!A.contains(itThis.next())) {// Si algo no esta en A
				return false;// No son iguales
			}
		}
		return true;// Son iguales porque cada una es igual a la otra en todo
	}

	/**
	 * Retorna un boolean si el conjunto asignado al this esta vacio
	 * 
	 * @return un boolean si el conjunto asignado al this esta vacio
	 */
	@Override
	public boolean isEmpty() {
		Iterator<T> itThis = this.iterator();// Iterador this
		return (itThis.next() == null);// Si el primer next es null, esta vacia
	}

	/**
	 * Instanciador de iterador
	 * 
	 * @return el iterador
	 */
	@Override
	public Iterator<T> iterator() {
		return new It<T>();
	}

	/**
	 * Clase privada del iterador del vector de bits
	 * 
	 * @author Gonzalo
	 *
	 * @param <E>
	 */
	private class It<E> implements Iterator<E> {

		/**
		 * Como hay que iterar ignorando las celdas con un null en su interior,
		 * se agrego siguienteDato, que es donde esta el siguiente valor != null
		 * luego de donde esta el iterador actualmente, esto para saber si hay
		 * un dato siguiente en el array y accesarlo mas rapido al usar next
		 */
		int actualIterador = 0;
		int siguienteDato = actualIterador;

		public It() {
		}

		@Override
		public boolean hasNext() {
			for (int i = actualIterador; i < lista.length; i++) {
				if (lista[i] != null) {
					siguienteDato = i;
					return true;
				}
			}
			return false;
		}

		@Override
		public E next() {
			if (actualIterador >= lista.length) {
				System.out.println("Ya esta en el final de la lista");
				return null;
			} else {
				E retorno = (E) lista[siguienteDato];
				actualIterador = siguienteDato;
				return retorno;
			}

		}
	}

}

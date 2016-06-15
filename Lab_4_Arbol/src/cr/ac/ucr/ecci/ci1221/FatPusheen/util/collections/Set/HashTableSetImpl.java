package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.ArrayList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class HashTableSetImpl<T> implements Conjunto<T> {

	List<T>[] lista;

	public HashTableSetImpl() {
		lista = (ArrayList<T>[]) new Object[1000];
	}

	public HashTableSetImpl(int tamano) {
		lista = (ArrayList<T>[]) new Object[tamano];
	}

	/**
	 * Auxiliar para union, ayuda a hacer la iteracion completa de los buckets
	 * en la lista para completar la union
	 * 
	 * @param hash
	 *            el bucket a iterar
	 * @param con
	 *            el conjunto a comparar
	 */
	private void auxiliarUnion(int hash, Conjunto<T> con) {
		Iterator<T> itThis = this.lista[hash % lista.length].iterator();// Iterador
																		// del
																		// bucket
		while (itThis.hasNext()) {// Iteramos el bucket
			T dato = itThis.next();
			if (!con.contains(dato)) {// Si no esta en con
				con.add(dato);// Lo añade
			}
		}
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
	public Conjunto<T> union(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacio
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}

		Conjunto<T> resultado = new HashTableSetImpl<T>();// Nuevo conjunto

		Iterator<T> itA = A.iterator();// Iterador A
		Iterator<T> itB = B.iterator();// Iterador B

		while (itA.hasNext()) {// Itera por A
			resultado.add(itA.next());// Añade CADA BUCKET a resultado, no sus
										// elementos
		}
		while (itB.hasNext()) {// Itera por B
			T dato = itB.next();
			auxiliarUnion(dato.hashCode() % lista.length, resultado);// Auxiliar
		}
		return resultado;// Retorna resultado
	}

	/**
	 * Auxiliar para la interseccion, itera por cada bucket enviado y añade los
	 * datos adecuados de la intersccion entre los conjuntos
	 * 
	 * @param hash
	 *            el bucket a iterar
	 * @param con
	 *            el conjunto a comparar
	 * @param resultado
	 *            el conjunto a retornar en el principal
	 */
	private void auxiliarInsterction(int hash, Conjunto<T> con, Conjunto<T> resultado) {
		Iterator<T> itThis = this.lista[hash % lista.length].iterator();// Iterador
																		// del
																		// bucket
		while (itThis.hasNext()) {// Iteramos por el bucket
			T dato = itThis.next();
			if (con.contains(dato)) {// Si lo contiene el conjunto a comparar
				resultado.add(dato);// Lo añade en resultado
			}
		}
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
	public Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Conjunto<T> resultado = new HashTableSetImpl<T>();// Nuevo conjunto

		Iterator<T> itB = B.iterator();// Iterador de B

		while (itB.hasNext()) {// Iteramos por B
			T dato = itB.next();
			auxiliarInsterction(dato.hashCode() % lista.length, A, resultado);// Auxiliar
		}
		return resultado;// Retorna resultado
	}

	/**
	 * Auxiliar para diferencia, itera por cada bucket enviado buscando los
	 * elementos adecuados para la correcta diferencia entre los conjuntos
	 * originales
	 * 
	 * @param hash
	 *            el bucket a iterar
	 * @param con
	 *            el conjunto a comparar
	 * @param resultado
	 *            el conjunto que contendra los elementos de la diferencia
	 */
	private void auxiliarDifference(int hash, Conjunto<T> con, Conjunto<T> resultado) {
		Iterator<T> itThis = this.lista[hash % lista.length].iterator();// Iterador
																		// del
																		// bucket
		while (itThis.hasNext()) {// Iteramos el bucket
			T dato = itThis.next();
			if (!con.contains(dato)) {// Si no lo contiene el conjunto a
										// comparar
				resultado.add(dato);// Lo añadimos a resultado
			}
		}
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
	public Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Conjunto<T> resultado = new HashTableSetImpl<T>();// Nuevo conjunto

		Iterator<T> itA = A.iterator();// Iterador A

		while (itA.hasNext()) {// Iteramos A
			T dato = itA.next();
			auxiliarDifference(dato.hashCode() % lista.length, B, resultado);// Auxiliar
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
		if (this.lista[dato.hashCode() % lista.length] == null) {// Si el bucket
																	// esta
																	// vacio
			return false;// No esta
		} else {
			Iterator<T> interior = this.lista[dato.hashCode() % lista.length].iterator();// Iterador
			// del
			// bucket
			while (interior.hasNext()) {// Itera el bucket
				if (dato.equals(interior.next())) {// Si esta en el bucket
					return true;// Retorna true
				}
			}
		}
		return false;// No lo encontro
	}

	/**
	 * Limpia la lista a dejarla sin datos
	 */
	@Override
	public void clear() {
		lista = (ArrayList<T>[]) new Object[lista.length];
	}

	/**
	 * Añade un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere agregar al conjunto
	 */
	@Override
	public void add(T dato) {
		if (this.contains(dato)) {// Si el dato ya esta
			System.out.println("El elemento ya esta en el conjunto, no se insertara");
		} else {
			if (this.lista.length <= dato.hashCode() % lista.length) {// Si el
																		// hash
																		// es
																		// mas
				// grande que la lista
				// en si
				// Agranda la lista
				List<T>[] listaNueva = (ArrayList<T>[]) new Object[dato.hashCode() + 1];

				Iterator<T> itThis = this.iterator();// Iterador de this

				while (itThis.hasNext()) {// Iteramos por this
					T datoIt = itThis.next();
					// Llenamos la lista nueva con los buckets de la vieja
					listaNueva[datoIt.hashCode() % lista.length] = this.lista[datoIt.hashCode() % lista.length];
				}

				this.lista = listaNueva;
			}
			this.lista[dato.hashCode() % lista.length].add(dato);// Añade el
																	// dato a su
																	// bucket
		}
	}

	/**
	 * Elimina un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere eliminar del conjunto
	 */
	@Override
	public void remove(T dato) {
		if (this.lista[dato.hashCode() % lista.length] == null) {// Si el bucket
																	// esta
																	// vacio
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("El elemento no esta en la lista");
			throw f;
		}
		if (this.isEmpty()) {// Si la lista esta vacia
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		this.lista[dato.hashCode() % lista.length].remove(dato);// Remueve el
																// dato del
																// bucket
		// correspondiente
	}

	/**
	 * Auxiliar para el equals, itera el bucket buscando NO coincidencias con el
	 * conjunto a comparar (con) si las encuentra retorna false
	 * 
	 * @param hash
	 *            el bucket a iterar
	 * @param con
	 *            el conjunto a comparar
	 * @return
	 */
	private boolean auxiliarEquals(int hash, Conjunto<T> con) {
		Iterator<T> itThis = this.lista[hash % lista.length].iterator();// Iterador
																		// del
																		// bucket
		while (itThis.hasNext()) {// Itera el bucket
			T dato = itThis.next();
			if (!con.contains(dato)) {// Si encuentra una no coincidencia
				return false;// Retorna false
			}
		}
		return true;// De lo contrario, true
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
	public boolean Equals(Conjunto<T> A) {
		Iterator<T> itA = A.iterator();// Iterador A
		Iterator<T> itThis = this.iterator();// Iterador this

		while (itA.hasNext()) {// Iteramos A
			T dato = itA.next();
			// Auxiliar (dice si A es igual a this)
			if (!auxiliarEquals(dato.hashCode() % lista.length, this)) {
				return false;
			}
		}
		while (itThis.hasNext()) {// Iteramos this
			T dato = itThis.next();
			// Auxiliar (dice si this es igual a A)
			if (!auxiliarEquals(dato.hashCode() % lista.length, A)) {
				return false;
			}
		}
		return true;// Al ser iguales uno con el otro y viceversa, ambos son
					// iguales en todo
	}

	/**
	 * Retorna un boolean si el conjunto asignado al this esta vacio
	 * 
	 * @return un boolean si el conjunto asignado al this esta vacio
	 */
	@Override
	public boolean isEmpty() {
		Iterator<T> itThis = this.iterator();// Iterador this
		return (!itThis.hasNext());// Si el primer hasNext del iterador es null
									// es porque esta vacia
	}

	/**
	 * Instanciador del iterador
	 */
	@Override
	public Iterator<T> iterator() {
		return new It<T>();
	}

	/**
	 * Clase privada del iterador del hash table
	 * 
	 * @author Gonzalo
	 *
	 * @param <E>
	 */
	private class It<E> implements Iterator<E> {
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
				actualIterador = siguienteDato;
				return (E) lista[siguienteDato];
			}
		}
	}

}

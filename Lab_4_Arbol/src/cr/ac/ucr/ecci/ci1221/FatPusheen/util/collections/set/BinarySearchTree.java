package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.Stack;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackArray;

public class BinarySearchTree<T extends Comparable> implements Conjunto<T> {

	/**
	 * Atributo donde estara guardado la raiz del arbol binario de busqueda
	 */
	Nodo<T> raiz;

	/**
	 * Contructor del arbol binario de busqueda
	 * 
	 * @param raiz
	 *            lo que sera la raiz del nuevo arbol
	 */
	public BinarySearchTree(T raiz) {
		this.raiz = new Nodo<T>(raiz);
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
		if (A.isEmpty() == true && B.isEmpty() == true) {// Si alguno o ambos
			// conjuntos estan vacios, devuelve el que no o un error,
			// respectivamente
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}

		Iterator<T> itA = A.iterator();// Iterador de A
		Conjunto<T> resultado = new BinarySearchTree<T>(itA.next());// Nuevo
																					// arbol

		while (itA.hasNext()) {// Añade todo A al nuevo arbol
			resultado.add(itA.next());
		}

		Iterator<T> itB = B.iterator();// Iterador de B

		while (itB.hasNext()) {// Busca los datos en B que no estan en resultado
								// y los inserta
			T dato = itB.next();
			if (!resultado.contains(dato)) {
				resultado.add(dato);
			}
		}
		return resultado;// Retorna el nuevo arbol
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
		Iterator<T> itA = A.iterator();// Iterador A
		Conjunto<T> resultado = new BinarySearchTree<T>(itA.next());// Nuevo
																					// arbol

		while (itA.hasNext()) {// Iteramos por todo A
			resultado.add(itA.next());// Insertamos en resultado
		}
		Iterator<T> itB = B.iterator();// Iterador de B

		while (itB.hasNext()) {// Iteramos por todo B
			T dato = itB.next();
			if (!A.contains(dato)) {// Si el dato no esta en A
				resultado.remove(dato);// Lo quitamos de resultado
			}
		}
		return resultado;// Retorna el nuevo arbol
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
		if (A.isEmpty() == true && B.isEmpty() == true) {// Comprobacion de
															// vacios
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Iterator<T> itA = A.iterator();// Iterador de A
		Conjunto<T> resultado = new BinarySearchTree<T>(itA.next());// Nuevo
																					// arbol

		while (itA.hasNext()) {// Iteramos todo A
			resultado.add(itA.next());// Insertamos en resultado lo de A
		}
		itA = A.iterator();// Reiniciamos el iterador de A

		while (itA.hasNext()) {// Iteramos todo A
			T dato = itA.next();
			if (B.contains(dato)) {// Si B contiene un dato que esta en A
				resultado.remove(dato);// Lo remueve de resultado
			}
		}
		return resultado;// Retorna el nuevo arbol
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
		return contains(raiz, dato);// Auxiliar
	}

	/**
	 * Auxiliar para el contains
	 * 
	 * @param nodo
	 *            por donde va la recursividad
	 * @param dato
	 *            el dato que se quiere encontrar en el arbol
	 * @return un boolean si el dato esta o no en la lista
	 */
	private boolean contains(Nodo<T> nodo, T dato) {
		if (nodo.dato.equals(dato)) {// Si lo encontro
			return true;// Retorna true
		} else {
			if (nodo.hijoIzquierdo != null) {// Si tiene hijo izquierdo
				return contains(nodo.hijoIzquierdo, dato);// Recursividad por
															// ahi
			} else if (nodo.hijoDerecho != null) {// Si tiene hijo derecho
				return contains(nodo.hijoDerecho, dato);// Recursividad por ahi
			}
		}
		return false;// No lo encontro
	}

	/**
	 * Limpia la lista a dejarla sin datos
	 */
	@Override
	public void clear() {
		raiz = null;// Borra todo
	}

	/**
	 * Añade un dato al conjunto asignado al this
	 * 
	 * @param dato
	 *            el elemento que se quiere agregar al conjunto
	 */
	@Override
	public void add(T dato) {
		if (this.contains(dato)) {// Si el dato ya esta en el conjunto
			System.out.println("El elemento ya esta en el arbol, no se insertara");
			return;// Solo avisa y sale del metodo
		}
		if (raiz == null) {// Si el arbol esta vacio
			this.raiz = new Nodo<T>(dato);// Sera la nueva raiz
		} else {
			inserteOrdenado(raiz, new Nodo<T>(dato), false);// Auxiliar
		}
	}

	/**
	 * Auxiliar para el add, inserta ordenadamente dentro del arbol mas no
	 * reacomoda datos del mismo
	 * 
	 * @param este
	 *            por donde va la recursividad
	 * @param dato
	 *            el nodo que se quiere insertar en el arbol
	 * @param insercion
	 *            si ya se inserto entonces cambia a true
	 */
	private void inserteOrdenado(Nodo<T> este, Nodo<T> dato, boolean insercion) {
		if (insercion == true) {// Si ya esta insertado
			return;// Sale
		} else {
			if (este.dato.compareTo(dato.dato) < 0) {// Si donde esta es menor
														// que el dato
				if (este.hijoDerecho == null) {// Y no tiene hijo derecho
					este.hijoDerecho = dato;// Inserta
					insercion = true;// Insercion se hizo
				} else {
					inserteOrdenado(este.hijoDerecho, dato, insercion);// Si no
																		// inserta,
																		// recursividad
				}
			}
			if (este.dato.compareTo(dato.dato) >= 0) {// Si donde esta es mayor
														// que el dato
				if (este.hijoIzquierdo == null) {// Y no tiene hijo izquierdo
					este.hijoIzquierdo = dato;// Inserta
					insercion = true;// Se hizo insercion
				} else {
					inserteOrdenado(este.hijoIzquierdo, dato, insercion);// Recursividad
																			// de
																			// caso
																			// contrario
				}
			}
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
		Nodo<T> nodo = null;// Una copia del nodo que tiene el dato
		if (!this.contains(dato) || this.isEmpty()) {// Si vacia o no la
														// contiene
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"La lista esta vacia o el elemento no esta en la lista");
			throw f;// Se cae
		}

		nodo = localizaNodo(dato, raiz, nodo);// Localiza el nodo

		if (nodo.hijoDerecho == null && nodo.hijoIzquierdo == null) {// Si hoja
			nodo = null;// Borra

		} else if (nodo.hijoDerecho == null && nodo.hijoIzquierdo != null) {// Si
																			// hijo
																			// izquierdo
			nodo = nodo.hijoIzquierdo;// Borra

		} else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo == null) {// Si
																			// hijo
																			// derecho
			nodo = nodo.hijoDerecho;// Borra

		} else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo != null) {// Si
																			// ambos
																			// hijos
			Nodo<T> camino = nodo.hijoDerecho;// Nodo auxiliar
			Nodo<T> padre = nodo;// Nodo padre al auxiliar
			while (camino.hijoIzquierdo != null) {// Busca el nodo mas izquierdo
													// de los derecho del nodo a
													// borrar
				padre = camino;// Mueve el padre
				camino = camino.hijoIzquierdo;// Mueve el auxiliar
			} // Cuando estan en posicion
			nodo.setDato(camino.dato);// Borra el dato a borrar por el mas
										// izquierdo de sus hijos derechos
			padre.setHijoIzquierdo(camino.hijoDerecho);// Reasigna los hijos del
														// auxiliar
														// padre del auxiliar
		}

	}

	/**
	 * Metodo que localiza el nodo a borrar en el arbol, es un auxiliar para el
	 * remove del arbol
	 * 
	 * @param dato
	 *            el dato que se busca en el arbol
	 * @param raiz
	 *            la raiz del arbol en el que se quiere buscar
	 * @param nodo
	 *            el nodo dueño del dato que se quiere encontrar
	 * @return el nodo dueño del dato que se quiere encontrar
	 */
	private Nodo<T> localizaNodo(T dato, Nodo<T> raiz, Nodo<T> nodo) {
		if (raiz.dato.equals(dato)) {// Si lo encuentra
			nodo = raiz; // Lo asigna a nodo
			return nodo; // Lo retorna
		}
		if (raiz.hijoIzquierdo != null) {// Va para la izquierda
			localizaNodo(dato, raiz.hijoIzquierdo, nodo);
		}
		if (raiz.hijoDerecho != null) {// Luego derecha
			localizaNodo(dato, raiz.hijoDerecho, nodo);
		}
		return nodo;// Retorna nodo
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
		Iterator<T> itThis = this.iterator();// Iterador this
		Iterator<T> itA = A.iterator();// Iterador A

		while (itThis.hasNext()) {// Si lo que esta en this esta en A
			if (!A.contains(itThis.next())) {// Si no
				return false;// Retorna falso
			}
		}

		while (itA.hasNext()) {// Si lo que esta en A esta en this
			if (!this.contains(itA.next())) {// Si no
				return false;// Retorna falso
			}
		}
		return true;// Si lo que esta en A esta en this y vice, entonces son
					// iguales
	}

	/**
	 * Retorna un boolean si el conjunto asignado al this esta vacio
	 * 
	 * @return un boolean si el conjunto asignado al this esta vacio
	 */
	@Override
	public boolean isEmpty() {
		return raiz == null;
	}

	/**
	 * Clase nodo para el arbol binario de busqueda
	 * 
	 * @author Gonzalo
	 *
	 * @param <T>
	 */
	private class Nodo<T> {

		T dato;
		Nodo<T> hijoDerecho;
		Nodo<T> hijoIzquierdo;

		public Nodo(T dato) {
			hijoIzquierdo = null;
			hijoDerecho = null;
			this.dato = dato;
		}

		public T getDato() {
			return this.dato;
		}

		public Nodo<T> getHijoIzquierdo() {
			return this.hijoIzquierdo;
		}

		public Nodo<T> getHijoDerecho() {
			return this.hijoDerecho;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public void setHijoDerecho(Nodo<T> hijo) {
			this.hijoDerecho = hijo;
		}

		public void setHijoIzquierdo(Nodo<T> hijo) {
			this.hijoIzquierdo = hijo;
		}
	}

	/**
	 * Clase iterador del arbol binario de busqueda
	 * 
	 * @author Gonzalo
	 *
	 * @param <E>
	 */
	private class It<E> implements Iterator<E> {

		Stack<Nodo<T>> stack;

		/**
		 * Crea el stack con los datos del arbol
		 */
		public It() {
			stack = new StackArray<Nodo<T>>();
			inserciones(raiz);
		}

		/**
		 * Itera todo el arbol y guarda los datos en el stack
		 * 
		 * @param raiz
		 *            la raiz del arbol a iterar
		 */
		private void inserciones(Nodo<T> raiz) {
			if (raiz.dato != null) {
				stack.push(raiz);
			}
			if (raiz.hijoIzquierdo != null) {
				inserciones(raiz.hijoIzquierdo);
			}
			if (raiz.hijoDerecho != null) {
				inserciones(raiz.hijoDerecho);
			}
		}

		@Override
		public boolean hasNext() {
			return (!stack.isEmpty());
		}

		@Override
		public E next() {
			return (E) stack.pop().dato;
		}
	}

	/**
	 * Instanciador del iterador
	 * 
	 * @return una instancia del iterador
	 */
	@Override
	public Iterator<T> iterator() {
		return new It<T>();
	}

}

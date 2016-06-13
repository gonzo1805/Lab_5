package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.Stack;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack.StackArray;

public class BinarySearchTree<T extends Comparable<T>> implements Conjunto<T> {

	Nodo<T> raiz;

	public BinarySearchTree(Nodo<T> raiz) {
		this.raiz = new Nodo(raiz);
	}

	@Override
	public Conjunto<T> union(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}

		Iterator<T> itA = A.iterator();
		Conjunto<T> resultado = new BinarySearchTree<T>(new Nodo<T>(itA.next()));

		while (itA.hasNext()) {
			resultado.add(itA.next());
		}

		Iterator<T> itB = B.iterator();

		while (itB.hasNext()) {
			T dato = itB.next();
			if (!resultado.contains(dato)) {
				resultado.add(dato);
			}
		}
		return resultado;
	}

	@Override
	public Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Iterator<T> itA = A.iterator();
		Conjunto<T> resultado = new BinarySearchTree<T>(new Nodo<T>(itA.next()));

		while (itA.hasNext()) {
			resultado.add(itA.next());
		}
		Iterator<T> itB = B.iterator();

		while (itB.hasNext()) {
			T dato = itB.next();
			if (!A.contains(dato)) {
				resultado.remove(dato);
			}
		}
		return resultado;
	}

	@Override
	public Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Iterator<T> itA = A.iterator();
		Conjunto<T> resultado = new BinarySearchTree<T>(new Nodo<T>(itA.next()));

		while (itA.hasNext()) {
			resultado.add(itA.next());
		}
		Iterator<T> itB = B.iterator();

		while (itB.hasNext()) {
			T dato = itB.next();
			if (!A.contains(dato)) {
				resultado.remove(dato);
			}
		}
		return resultado;
	}

	@Override
	public boolean contains(T dato) {
		return contains(raiz, dato);
	}

	private boolean contains(Nodo<T> nodo, T dato) {
		if (nodo.dato.equals(dato)) {
			return true;
		} else {
			if (nodo.hijoIzquierdo != null) {
				return contains(nodo.hijoIzquierdo, dato);
			} else if (nodo.hijoDerecho != null) {
				return contains(nodo.hijoDerecho, dato);
			}
		}
		return false;
	}

	@Override
	public void clear() {
		raiz = null;
	}

	@Override
	public void add(T dato) {
		if (this.contains(dato)) {
			System.out.println("El elemento ya esta en el arbol, no se insertara");
			return;
		}
		if (raiz == null) {
			this.raiz = new Nodo<T>(dato);
		} else {
			inserteOrdenado(raiz, new Nodo<T>(dato), false);
		}
	}

	private void inserteOrdenado(Nodo<T> este, Nodo<T> dato, boolean insercion) {
		if (insercion == true) {
			return;
		} else {
			if (este.dato.compareTo(dato.dato) < 0) {
				if (este.hijoDerecho == null) {
					este.hijoDerecho = dato;
					insercion = true;
				} else {
					inserteOrdenado(este.hijoDerecho, dato, insercion);
				}
			}
			if (este.dato.compareTo(dato.dato) >= 0) {
				if (este.hijoIzquierdo == null) {
					este.hijoIzquierdo = dato;
					insercion = true;
				} else {
					inserteOrdenado(este.hijoIzquierdo, dato, insercion);
				}
			}
		}
	}

	@Override
	public void remove(T dato) {
		Nodo<T> nodo = null;
		if (!this.contains(dato)) {
			System.out.println("El elemento no esta en el conjunto");
			return;
		}

		nodo = localizaNodo(dato, raiz, nodo);

		if (nodo.hijoDerecho == null && nodo.hijoIzquierdo == null) {
			nodo = null;

		} else if (nodo.hijoDerecho == null && nodo.hijoIzquierdo != null) {
			nodo = nodo.hijoIzquierdo;

		} else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo == null) {
			nodo = nodo.hijoDerecho;

		} else if (nodo.hijoDerecho != null && nodo.hijoIzquierdo != null) {
			Nodo<T> camino = nodo.hijoDerecho;
			Nodo<T> padre = nodo;
			while (camino.hijoIzquierdo != null) {
				padre = camino;
				camino = camino.hijoIzquierdo;
			}
			nodo.setDato(camino.dato);
			padre.setHijoIzquierdo(camino.hijoDerecho);
		}

	}

	private Nodo<T> localizaNodo(T dato, Nodo<T> raiz, Nodo<T> nodo) {
		if (raiz.dato.equals(dato)) {
			nodo = raiz;
			return nodo;
		}
		if (raiz.hijoIzquierdo != null) {
			localizaNodo(dato, raiz.hijoIzquierdo, nodo);
		}
		if (raiz.hijoDerecho != null) {
			localizaNodo(dato, raiz.hijoDerecho, nodo);
		}
		return nodo;
	}

	@Override
	public boolean Equals(Conjunto<T> A) {
		Iterator<T> itThis = this.iterator();
		Iterator<T> itA = A.iterator();

		while (itThis.hasNext()) {
			if (!A.contains(itThis.next())) {
				return false;
			}
		}

		while (itA.hasNext()) {
			if (!this.contains(itA.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return raiz == null;
	}

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

	private class It<E> implements Iterator<E> {

		Stack<Nodo<T>> stack;

		public It() {
			stack = new StackArray<Nodo<T>>();
			inserciones(raiz);
		}

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

	@Override
	public Iterator<T> iterator() {
		return new It<T>();
	}

}

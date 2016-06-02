package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public class BinarySearchTree<T> implements Conjunto<T> {

	@Override
	public Conjunto<T> union(Conjunto<T> A, Conjunto<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(T dato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(T dato) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean Equals(Conjunto<T> A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterador() {
		// TODO Auto-generated method stub
		return null;
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
}

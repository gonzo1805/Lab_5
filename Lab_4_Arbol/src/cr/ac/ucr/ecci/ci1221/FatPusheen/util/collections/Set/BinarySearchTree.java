package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Conjunto<T> {

	Nodo<T> raiz;

	public BinarySearchTree() {
		this.raiz = new Nodo(null);
	}

	public BinarySearchTree(Nodo<T> raiz) {
		this.raiz = new Nodo(raiz);
	}

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
		return contains(raiz, dato);
	}

	private boolean contains(Nodo<T> nodo, T dato) {
		if (nodo.dato.equals(dato)) {
			return true;
		} else {
			if (nodo.hijoIzquierdo != null) {
				contains(nodo.hijoIzquierdo, dato);
			} else if (nodo.hijoDerecho != null) {
				contains(nodo.hijoDerecho, dato);
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
		if (raiz == null) {
			this.raiz = new Nodo<T>(dato);
		} else {
			inserteOrdenado(raiz, new Nodo<T>(dato));
		}
	}

	private void inserteOrdenado(Nodo<T> este, Nodo<T> dato) {
		if (este == null) {
			este = dato;
		} else {
			if (este.dato.compareTo(dato.dato) < 0) {
				inserteOrdenado(este.hijoDerecho, dato);
			}
			if (este.dato.compareTo(dato.dato) >= 0) {
				inserteOrdenado(este.hijoIzquierdo, dato);
			}
		}
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

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/*private class Iterator<T>{
		
		public Iterator(){
			
		}
	}*/

}

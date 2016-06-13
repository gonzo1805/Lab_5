package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a Stack using a linked list.
 *
 * @author Rodrigo A. Bartels
 */
public class StackLinkedList<E> implements Stack<E> {

	private Nodo cabeza;
	private int tamano = 0;

	@Override
	public void push(E element) {
		Nodo nodo = new Nodo(element);
		if (tamano == 0) {
			cabeza = nodo;
			tamano++;
		} else {
			nodo.setSiguiente(cabeza);
			cabeza = nodo;
			tamano++;
		}
	}

	@Override
	public E peek() {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Lista vacia");
			throw f;
		}
		return cabeza.getDato();
	}

	@Override
	public E pop() {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Lista vacia");
			throw f;
		}
		E retorno = cabeza.getDato();
		cabeza = cabeza.getSiguiente();
		tamano--;
		return retorno;
	}

	@Override
	public void add(E element) {
		push(element);
	}

	@Override
	public E remove(E element) {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Lista vacia");
			throw f;
		}
		if (cabeza.dato.equals(element))
			return pop();
		else {
			Nodo anterior = cabeza;
			Nodo aux = cabeza;
			for (int i = 0; i < tamano; i++) {
				if (aux.dato.equals(element)) {
					anterior.setSiguiente(aux.siguiente);
					tamano--;
					return element;
				}
				anterior = aux;
				aux = aux.siguiente;
			}
		}
		return null;

	}

	@Override
	public boolean contains(E element) {
		Nodo aux = cabeza;
		while (aux != null) {
			if (aux.getDato().equals(element))
				return true;
			else
				aux = aux.getSiguiente();
		}
		return false;
	}

	@Override
	public int size() {
		return tamano;
	}

	@Override
	public boolean isEmpty() {
		return (tamano == 0);
	}

	@Override
	public void clear() {
		cabeza = null;
		tamano = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It<E>();
	}

	private class It<E> implements Iterator<E> {
		Nodo actual = cabeza;

		public It() {
		}

		@Override
		public boolean hasNext() {
			return (!actual.siguiente.equals(null));
		}

		@Override
		public E next() {
			E dato = (E) actual.siguiente.dato;
			if (actual.siguiente.equals(null)) {
				return dato;
			}
			actual = actual.siguiente;
			return dato;
		}

	}

	private class Nodo {
		E dato;
		Nodo siguiente = null;

		public Nodo() {
		}

		public Nodo(E element) {
			this.dato = element;
		}

		public void setDato(E dato) {
			this.dato = dato;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public E getDato() {
			return this.dato;
		}

		public Nodo getSiguiente() {
			return this.siguiente;
		}
	}
}

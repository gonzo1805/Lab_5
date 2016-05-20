package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a List model using a linked list data structure.
 *
 * @param <E>
 *            the type of the elements that the list holds.
 */
public class LinkedList<E> implements List<E> {

	private Nodo cabeza;
	private int cantidadNodos = 0;
	private Nodo cola;

	/**
	 * Adds the given element to the given position.
	 *
	 * @param element
	 *            the element.
	 * @param position
	 *            the position.
	 */
	@Override
	public void add(E element, int position) {
		if (position > cantidadNodos || cantidadNodos == 0 || position == cantidadNodos) {
			add(element);
		} else if (position - 1 == 0) {
			Nodo nodo = new Nodo(element);
			nodo.setNext(cabeza);
			cabeza = nodo;
			cantidadNodos++;
		} else {
			Nodo actual = cabeza;
			Nodo anterior = cabeza;
			for (int i = 0; i < position - 1; i++) {
				anterior = actual;
				actual = actual.getNext();
			}
			Nodo nodo = new Nodo(element);
			nodo.setNext(actual);
			anterior.setNext(nodo);
			cantidadNodos++;
		}
	}

	/**
	 * removes the element at the given position.
	 *
	 * @param position
	 *            the position.
	 */
	@Override
	public void remove(int position) {
		if (position - 1 == 0) {
			cabeza = cabeza.getNext();
			cantidadNodos--;
		} else if (position == cantidadNodos) {
			Nodo nodo = cabeza;
			Nodo anterior = cabeza;
			for (int i = 0; i < position - 1; i++) {
				anterior = nodo;
				nodo = nodo.getNext();
			}
			anterior.setNext(null);
			cantidadNodos--;
			cola = anterior;
		} else if (position - 1 > 1) {
			Nodo nodo = cabeza;
			Nodo anterior = cabeza;
			for (int i = 0; i < position - 1; i++) {
				anterior = nodo;
				nodo = nodo.getNext();
			}
			anterior.setNext(nodo.getNext());
			cantidadNodos--;
		}
	}

	/**
	 * Returns the initial position of the given element.
	 *
	 * @param element
	 *            the element to find.
	 * @return the position of the found element.
	 */
	@Override
	public int find(E element) {
		Nodo nodo = cabeza;
		for (int i = 0; i <= cantidadNodos; i++) {
			if (nodo.getValor() == element) {
				return i + 1;
			}
			nodo = nodo.getNext();
		}
		System.out.println("El elemento no fue encontrado dentro de la lista, se retornara un 0");
		return -1;
	}

	/**
	 * Returns the element at the given position.
	 * Works from 1 to list.size()
	 *
	 * @param position
	 *            the position.
	 * @return the element at the given position.
	 */
	@Override
	public E get(int position) {
		if (cabeza == null) {
			System.out.println("La lista esta vacia");
			return null;
		} else if (position > cantidadNodos || position < 0) {
			System.out.println(
					"Se solicito un espacio en la lista que esta no posee porque es mas grande que la misma, o porque la posicion es negativa se retornara un null");
			return null;
		}
		Nodo nodo = cabeza;
		for (int i = 0; i < position - 1; i++) {
			nodo = nodo.getNext();
		}
		return nodo.getValor();

	}

	/**
	 * Replaces the element in the given position with the given element.
	 *
	 * @param position
	 *            the position
	 * @param element
	 *            the element to replace.
	 * @return the replaced element.
	 */
	@Override
	public E set(int position, E element) {
		E retorno;
		if (position - 1 == 0) {
			retorno = cabeza.getValor();
			cabeza.setValor(element);
			return retorno;
		}
		Nodo actual = cabeza;

		if (position - 1 > 0) {
			for (int i = 0; i < position - 1; i++) {
				actual = actual.getNext();
			}

			retorno = actual.getValor();
			actual.setValor(element);
			return retorno;

		}
		return null;
	}

	/**
	 * Adds an element to the collection.
	 *
	 * @param element
	 *            the element to add to the collection.
	 */
	@Override
	public void add(E element) {
		if (cantidadNodos == 0) {
			Nodo nodo = new Nodo(element);
			cabeza = nodo;
			cola = cabeza;
			cantidadNodos++;
		} else {
			cola.setNext(new Nodo(element));
			cola = cola.getNext();
			cantidadNodos++;
		}
	}

	/**
	 * Removes an element to the collection.
	 *
	 * @param element
	 *            the element to remove to the collection.
	 */
	@Override
	public E remove(E element) {
		if (contains(element) == true) {
			int pos = find(element);
			E elemento = get(pos);
			remove(pos);
			return elemento;
		} else {
			return null;
		}
	}

	/**
	 * Checks if the collection contains the given Element.
	 *
	 * @param element
	 *            the element to look for.
	 * @return true if the element is in the collection, false otherwise.
	 */
	@Override
	public boolean contains(E element) {
		return (find(element) != -1);
	}

	/**
	 * Returns the size of the collection.
	 *
	 * @return the size of the collection.
	 */
	@Override
	public int size() {
		return cantidadNodos;
	}

	/**
	 * Whether the collection is empty or not.
	 *
	 * @return Whether the collection is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return cantidadNodos == 0;
	}

	/**
	 * Removes all the elements from the collection.
	 */
	@Override
	public void clear() {
		cabeza.setNext(null);
		cabeza = null;
		cantidadNodos = 0;
		cola = null;
	}

	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@Override
	public Iterator<E> iterator() {
		return new B();
	}

	/**
	 * Sorts a collection.
	 */
	@Override
	public void sort() {

	}

	private class B<E> implements Iterator<E> {
		int actual = 0;

		@Override
		public boolean hasNext() {
			return actual < cantidadNodos;
		}

		@Override
		public E next() {
			int a = actual;
			int b = cantidadNodos;
			if (actual == cantidadNodos) {
				System.out.println("Ya esta en el final de la lista");
				return null;
			}
			if (actual == 0) {
				actual++;
				return (E) cabeza.getValor();
			}
			Nodo auxiliar = cabeza;
			for (int i = 0; i < actual; i++) {
				auxiliar = auxiliar.getNext();
			}
			actual++;
			return (E) auxiliar.getValor();
		}
	}

	private class Nodo {

		private Nodo next = null;
		private E valor;

		public Nodo() {
		}

		public Nodo(E element) {
			this.valor = element;
		}

		public void setValor(E valor) {
			this.valor = valor;
		}

		public E getValor() {
			return this.valor;
		}

		public void setNext(Nodo siguiente) {
			this.next = siguiente;
		}

		public Nodo getNext() {
			return this.next;
		}
	}
}

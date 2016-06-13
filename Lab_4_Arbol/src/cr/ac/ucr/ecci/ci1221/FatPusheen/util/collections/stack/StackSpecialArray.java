package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a stack using a modified version of the array
 * implementation.
 *
 * @author Rodrigo A. Bartels
 */
public class StackSpecialArray<E> implements Stack<E> {

	private E[] elements;
	private int cantidadDatos;

	public StackSpecialArray(int tamano) {
		elements = (E[]) new Object[tamano];
		cantidadDatos = 0;
	}

	public StackSpecialArray() {
		elements = (E[]) new Object[100];
		cantidadDatos = 0;
	}

	@Override
	public void push(E element) {
		if (cantidadDatos + 1 >= elements.length) {
			E[] sustituto = (E[]) new Object[elements.length * 2];
			for (int i = 0; i < cantidadDatos; i++) {
				sustituto[i] = elements[i];
			}
			sustituto[cantidadDatos] = element;
			elements = sustituto;
			cantidadDatos++;
		} else {
			elements[cantidadDatos] = element;
			cantidadDatos++;
		}
	}

	@Override
	public E peek() {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"La pila esta vacia");
			throw f;
		}
		return elements[cantidadDatos - 1];
	}

	@Override
	public E pop() {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"La posicion que se quiere borrar no existe");
			throw f;
		}
		E retorno = elements[cantidadDatos - 1];
		elements[cantidadDatos - 1] = null;
		cantidadDatos--;
		return retorno;

	}

	@Override
	public void add(E element) {
		push(element);
	}

	@Override
	public E remove(E element) {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"El elemento que se quiere borrar no existe");
			throw f;
		}
		E retorno = null;
		if (elements[cantidadDatos - 1].equals(element)) {
			return pop();
		}
		boolean comprobacion = false;
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[i].equals(element)) {
				retorno = elements[i];
				comprobacion = true;
			}
			if (comprobacion == true) {
				if (!(elements[i + 1].equals(null))) {
					elements[i] = elements[i + 1];
				}
			}

		}
		if (comprobacion == false) {
			System.out.println("El elemento no estaba en la lista, retornara null");
			return null;
		}
		cantidadDatos--;
		return retorno;
	}

	@Override
	public boolean contains(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[i] == element)
				return true;
		}
		return false;
	}

	@Override
	public int size() {
		return cantidadDatos;
	}

	@Override
	public boolean isEmpty() {
		return cantidadDatos == 0;
	}

	@Override
	public void clear() {
		elements = (E[]) new Object[50];
		cantidadDatos = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new It<E>();
	}

	private class It<E> implements Iterator<E> {
		private int actual = cantidadDatos-1;

		public It() {
		};

		@Override
		public boolean hasNext() {
			return actual > 0;
		}

		@Override
		public E next() {
			if (actual == 0) {
				System.out.println("No hay mas elementos");
				return null;
			} else {
				E retorno = (E) elements[actual];
				actual--;
				return retorno;
			}
		}

	}
}

package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.stack;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

/**
 * Implementation of a stack using arrays.
 *
 * @author Rodrigo A. Bartels
 */
public class StackArray<E> implements Stack<E> {

	private E[] elements;
	private int cantidadDatos;

	public StackArray() {
		elements = (E[]) new Object[1000];
		cantidadDatos = 0;
	}

	public StackArray(int tamano) {
		elements = (E[]) new Object[tamano];
		cantidadDatos = 0;
	}

	@Override
	public void push(E element) {
		if (cantidadDatos == 0) {
			elements[0] = element;
			cantidadDatos++;
		} else if (cantidadDatos + 1 >= elements.length) {
			E[] sustituto = (E[]) new Object[elements.length * 2];

			for (int i = 0; i < cantidadDatos; i++) {
				sustituto[i + 1] = elements[i];
			}
			sustituto[0] = element;
			elements = sustituto;
			cantidadDatos++;
		} else {
			E aux = elements[0];
			E aux2 = elements[0];
			for (int i = 0; i < cantidadDatos; i++) {
				aux = elements[i + 1];
				elements[i + 1] = aux2;
				aux2 = aux;
			}
			elements[0] = element;
			cantidadDatos++;
		}
	}

	@Override
	public E peek() {
		return elements[0];
	}

	@Override
	public E pop() {
		if (this.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException(
					"La posicion que se quiere borrar no existe");
			throw f;
		}
		E retorno = elements[0];
		for (int i = 0; i < cantidadDatos - 1; i++) {
			elements[i] = elements[i + 1];
		}
		cantidadDatos--;
		return retorno;
	}

	@Override
	public void add(E element) {
		push(element);
	}

	@Override
	public E remove(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[0] == element) {
				return pop();
			} else {
				if (elements[i].equals(element)) {
					E retorno = elements[i];
					for (int x = 0; x < cantidadDatos - 1; x++) {
						elements[i] = elements[i + 1];
						i++;
					}
					cantidadDatos--;
					return retorno;
				}
			}
		}
		System.out.println("El elemento no esta en la lista");
		return null;
	}

	@Override
	public boolean contains(E element) {
		for (int i = 0; i < cantidadDatos; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return cantidadDatos;
	}

	@Override
	public boolean isEmpty() {
		return (cantidadDatos == 0);
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
		int actual;

		public It() {
			actual = 0;
		}

		@Override
		public boolean hasNext() {
			return actual < cantidadDatos;
		}

		@Override
		public E next() {
			if (actual >= cantidadDatos) {
				System.out.println("No hay mas elementos");
				return null;
			} else {
				E retorno = (E) elements[actual];
				actual++;
				return retorno;
			}

		}
	}
}

package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public class BitsVectorSetImpl<T extends Enumerable<T>> implements ConjuntoNumerable<T> {

	T[] lista;

	public BitsVectorSetImpl() {
		lista = (T[]) new Object[1000];
	}

	public BitsVectorSetImpl(int tamano) {
		lista = (T[]) new Object[tamano];
	}

	@Override
	public ConjuntoNumerable<T> union(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		ConjuntoNumerable<T> resultado = new BitsVectorSetImpl<T>();

		Iterator<T> itA = A.iterator();
		Iterator<T> itB = B.iterator();

		while (itA.hasNext()) {
			resultado.add(itA.next());
		}
		while (itB.hasNext()) {
			T insercion = itB.next();
			if (!A.contains(insercion)) {
				resultado.add(insercion);
			}
		}
		return resultado;
	}

	@Override
	public ConjuntoNumerable<T> intersection(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		ConjuntoNumerable<T> resultado = new BitsVectorSetImpl<T>();

		Iterator<T> itB = B.iterator();

		while (itB.hasNext()) {
			T dato = itB.next();
			if (A.contains(dato)) {
				resultado.add(dato);
			}
		}
		return resultado;
	}

	@Override
	public ConjuntoNumerable<T> difference(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		ConjuntoNumerable<T> resultado = new BitsVectorSetImpl<T>();

		Iterator<T> itA = A.iterator();

		while (itA.hasNext()) {
			T dato = itA.next();
			if (!B.contains(dato)) {
				resultado.add(dato);
			}
		}

		return resultado;
	}

	@Override
	public boolean contains(T dato) {
		return (this.lista[dato.getIndex()] != null);
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.lista.length; i++) {
			this.lista[i] = null;
		}
	}

	@Override
	public void add(T dato) {
		if (this.lista.length < dato.getIndex()) {
			T[] listaNueva = (T[]) new Object[dato.getIndex() + 1];
			Iterator<T> it = this.iterator();

			T data;

			while (it.hasNext()) {
				data = it.next();
				listaNueva[data.getIndex()] = data;
			}
			lista = listaNueva;
		}
		this.lista[dato.getIndex()] = dato;
	}

	@Override
	public void remove(T dato) {
		this.lista[dato.getIndex()] = null;
	}

	@Override
	public boolean Equals(ConjuntoNumerable<T> A) {
		Iterator<T> itA = A.iterator();
		Iterator<T> itThis = this.iterator();

		while (itA.hasNext()) {
			if (!this.contains(itA.next())) {
				return false;
			}
		}
		while (itThis.hasNext()) {
			if (!A.contains(itThis.next())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		Iterator<T> itThis = this.iterator();
		return (itThis.next() == null);
	}

	@Override
	public Iterator<T> iterator() {
		return new It<T>();
	}

	private class It<E> implements Iterator<E> {
		int actualIterador = 0;
		int tamano = lista.length;
		int siguienteDato = actualIterador;

		public It() {
		}

		@Override
		public boolean hasNext() {
			for (int i = actualIterador; i < tamano; i++) {
				if (lista[i] != null) {
					siguienteDato = i;
					return true;
				}
			}
			return false;
		}

		@Override
		public E next() {
			if (actualIterador >= tamano) {
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

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

		Conjunto<T> resultado = new HashTableSetImpl<T>();

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
	public Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Conjunto<T> resultado = new HashTableSetImpl<T>();

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
	public Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B) {
		if (A.isEmpty() == true && B.isEmpty() == true) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.isEmpty() == true) {
			return B;
		} else if (B.isEmpty() == true) {
			return A;
		}
		Conjunto<T> resultado = new HashTableSetImpl<T>();

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
		if (this.lista[dato.hashCode()] == null) {
			return false;
		} else {
			Iterator<T> interior = this.lista[dato.hashCode()].iterator();
			while (interior.hasNext()) {
				if (dato.equals(interior.next())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void clear() {
		this.lista = null;
	}

	@Override
	public void add(T dato) {
		if (this.lista.length < dato.hashCode()) {
			List<T>[] listaNueva = (ArrayList<T>[]) new Object[dato.hashCode() + 1];

			Iterator<T> itThis = this.iterator();

			while (itThis.hasNext()) {
				T datoIt = itThis.next();
				listaNueva[datoIt.hashCode()].add(datoIt);
			}

			lista = listaNueva;
		}
		this.lista[dato.hashCode()].add(dato);

	}

	@Override
	public void remove(T dato) {
		this.lista[dato.hashCode()].remove(dato);
	}

	@Override
	public boolean Equals(Conjunto<T> A) {
		Iterator<T> itA = A.iterator();
		Iterator<T> itThis = this.iterator();
		
		while(itA.hasNext()){
			T dato = itA.next();
			Iterator<T> itDato;
		}
		
		return false;
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
				actualIterador = siguienteDato;
				return (E) lista[siguienteDato];
			}

		}

	}
}

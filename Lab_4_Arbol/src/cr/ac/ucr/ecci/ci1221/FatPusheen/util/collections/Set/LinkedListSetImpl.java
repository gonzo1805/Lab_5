package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public class LinkedListSetImpl<T> implements Conjunto<T> {

	List<T> lista;

	LinkedListSetImpl() {
		lista = new LinkedList<T>();
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
		Conjunto<T> resultado = new LinkedListSetImpl<T>();
		Iterator<T> itA = A.iterador();
		Iterator<T> itB = B.iterador();
		while (itA.hasNext()) {
			resultado.add(itA.next());
		}
		while (itB.hasNext()) {
			T dato = itB.next();
			if (B.contains(dato) == false) {
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
		Conjunto<T> resultado = new LinkedListSetImpl<T>();
		Iterator<T> itA = A.iterador();

		T datoA;

		while (itA.hasNext()) {
			datoA = itA.next();
			if (B.contains(datoA) == true) {
				resultado.add(datoA);
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
		Conjunto<T> resultado = new LinkedListSetImpl<T>();

		Iterator<T> itA = A.iterador();
		Iterator<T> itB = B.iterador();

		while (itA.hasNext()) {
			resultado.add(itA.next());
		}

		T dato = itB.next();

		if (resultado.contains(dato)) {
			resultado.remove(dato);
		}

		return resultado;
	}

	@Override
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}

	@Override
	public boolean contains(T dato) {
		if (this.lista.size() == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("La lista esta vacia");
			throw f;
		}
		for (int i = 1; i <= this.lista.size(); i++) {
			if (this.lista.get(i).equals(dato)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		this.lista.clear();
	}

	@Override
	public void add(T dato) {
		this.lista.add(dato);
	}

	@Override
	public void remove(T dato) {
		if (this.contains(dato) == false) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("El elemento no esta en la lista");
			throw f;
		} else {
			this.lista.remove(dato);
		}

	}

	@Override
	public boolean Equals(Conjunto<T> A) {
		Iterator<T> itThis = this.iterador();
		Iterator<T> itA = this.iterador();

		while (itThis.hasNext()) {
			if (A.contains(itThis.next()) == false) {
				return false;
			}
		}
		while (itA.hasNext()) {
			if (this.contains(itA.next()) == false) {
				return false;
			}
		}
		return true;
	}

	public Iterator<T> iterador() {
		Iterator<T> it = this.lista.iterator();
		return it;
	}

}

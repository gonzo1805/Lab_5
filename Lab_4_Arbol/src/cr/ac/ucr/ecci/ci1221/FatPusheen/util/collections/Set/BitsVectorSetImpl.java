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
		int i = 0;
		while (A.posicion(i) != null) {
			resultado.add(A.posicion(i));
			i++;
		}

		i = 0;

		while (B.posicion(i) != null) {
			if (resultado.contains(B.posicion(i)) == false) {
				resultado.add(B.posicion(i));
			}
			i++;
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

		int i = 0;
		while (A.posicion(i) != null) {
			resultado.add(A.posicion(i));
			i++;
		}

		i = 0;

		while (resultado.posicion(i) != null) {
			if (B.contains(resultado.posicion(i)) == false) {
				resultado.remove(resultado.posicion(i));
			}
			i++;
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

		int i = 0;
		while (A.posicion(i) != null) {
			resultado.add(A.posicion(i));
			i++;
		}

		i = 0;

		while (B.posicion(i) != null) {
			if (resultado.contains(B.posicion(i))) {
				resultado.remove(B.posicion(i));
			}
			i++;
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
		this.lista[dato.getIndex()] = dato;
	}

	@Override
	public void remove(T dato) {
		this.lista[dato.getIndex()] = null;
	}

	@Override
	public boolean Equals(ConjuntoNumerable<T> A) {
		int i = 0;
		while (this.posicion(i) != null) {
			if (A.contains(this.posicion(i)) == false){
				return false;
			}
		}
		
		i = 0;
		
		while (A.posicion(i) != null) {
			if (this.contains(A.posicion(i)) == false){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return (this.lista.length == 0);
	}

	@Override
	public T posicion(int posicion) {
		return this.lista[posicion];
	}

}

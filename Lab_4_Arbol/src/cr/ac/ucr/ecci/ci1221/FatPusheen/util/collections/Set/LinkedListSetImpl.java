package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import java.util.concurrent.ExecutionException;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class LinkedListSetImpl<T> implements Conjunto<T> {

	List<T> lista;

	LinkedListSetImpl() {
		lista = new LinkedList<T>();
	}

	@Override
	public Conjunto<T> union(LinkedListSetImpl<T> A, LinkedListSetImpl<T> B) {
		if (A.lista.size() == 0 && B.lista.size() == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.lista.size() == 0) {
			return B;
		} else if (B.lista.size() == 0) {
			return A;
		}
		Conjunto<T> resultado = new LinkedListSetImpl<T>();
		for (int i = 1; i <= A.lista.size(); i++) {
			resultado.add(A.lista.get(i));
		}
		for (int x = 1; x <= B.lista.size(); x++) {
			if (resultado.contains(B.lista.get(x)) == false) {
				resultado.add(B.lista.get(x));
			}
		}
		return resultado;
	}

	@Override
	public Conjunto<T> intersection(LinkedListSetImpl<T> A, LinkedListSetImpl<T> B) {
		if (A.lista.size() == 0 && B.lista.size() == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.lista.size() == 0) {
			return B;
		} else if (B.lista.size() == 0) {
			return A;
		}
		Conjunto<T> resultado = new LinkedListSetImpl<T>();
		for (int i = 1; i<=A.lista.size(); i++){
			if (B.contains(A.lista.get(i)) == true){
				resultado.add(A.lista.get(i));
			}
		}
		return resultado;
	}

	@Override
	public Conjunto<T> difference(LinkedListSetImpl<T> A, LinkedListSetImpl<T> B) {
		if (A.lista.size() == 0 && B.lista.size() == 0) {
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("Ambas listas estan vacias");
			throw f;
		} else if (A.lista.size() == 0) {
			return B;
		} else if (B.lista.size() == 0) {
			return A;
		}
		Conjunto<T> resultado = new LinkedListSetImpl<T>();
		for (int i=1; i<=A.lista.size(); i++){
			resultado.add(A.lista.get(i));
		}
		for (int z=1; z<=B.lista.size(); z++){
			if (resultado.contains(B.lista.get(z)) == true){
				resultado.remove(B.lista.get(z));
			}
		}
		return resultado;
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
		if (this.contains(dato) == false){
			ArrayIndexOutOfBoundsException f = new ArrayIndexOutOfBoundsException("El elemento no esta en la lista");
			throw f;
		} else {
			this.lista.remove(dato);
		}

	}

	@Override
	public boolean Equals(LinkedListSetImpl<T> A) {
		for (int i=1; i<=this.lista.size(); i++){
			for (int x = 1; x<=A.lista.size(); x++){
				if (this.lista.contains(A.lista.get(x)) == false){
					return false;
				}
			}
		}
		return true;
	}

}

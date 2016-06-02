package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.ArrayList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class BitsVectorSetImpl<T extends Enumerable<T>> implements ConjuntoNumerable<T> {

	List<Boolean> lista;
	
	public BitsVectorSetImpl(){
		lista = new ArrayList<Boolean>();
	}
	
	public BitsVectorSetImpl(int tamano){
		lista = new ArrayList<Boolean>(tamano);
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
		Iterator<Boolean> itA = A.iterador();
		Iterator<Boolean> itB = B.iterador();
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
	public ConjuntoNumerable<T> intersection(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConjuntoNumerable<T> difference(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T dato) {
		int posicion = dato.getIndex();
		if (this.lista.get(posicion)){
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		
		
	}

	@Override
	public void add(T dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Equals(ConjuntoNumerable<T> A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Boolean> iterador() {
		Iterator<Boolean> it = this.lista.iterator();
		return it;
	}

	
}

package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.ArrayList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public class BitsVectorSetImpl<T extends Enumerable> implements ConjuntoNumerable<T> {

	T[] lista;
	
	public BitsVectorSetImpl(){
		lista = (T[]) new Object[10];
	}
	
	public BitsVectorSetImpl(int tamano){
		lista = (T[]) new Object[tamano];
	}
	
	@Override
	public ConjuntoNumerable<T> union(BitsVectorSetImpl<T> A, BitsVectorSetImpl<T> B, BitsVectorSetImpl<T> C) {
		
		return null;
	}

	@Override
	public ConjuntoNumerable<T> intersection(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B, ConjuntoNumerable<T> C) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConjuntoNumerable<T> difference(ConjuntoNumerable<T> A, ConjuntoNumerable<T> B, ConjuntoNumerable<T> C) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T dato, ConjuntoNumerable<T> A) {
		return A.contains(dato);
		
	}
	
	public boolean contains(T dato){
	 for (int i=0; i<this.lista.length; i++){
		 if (this.lista[i].equals(dato)){
			 return true;
		 }
	 }
	 return false;
	}

	@Override
	public void clear(ConjuntoNumerable<T> A) {
		
		
	}

	@Override
	public void add(T dato, ConjuntoNumerable<T> A) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T dato, ConjuntoNumerable<T> A) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Equals(ConjuntoNumerable<T> A) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Iterator;

public class HashTableSetImpl<T> implements Conjunto<T> {

	T[] lista;
	
	public HashTableSetImpl(){
		lista = (T[]) new Object[1000];
	}
	
	public HashTableSetImpl(int tamano){
		lista = (T[]) new Object[tamano];
	}
	
	@Override
	public Conjunto<T> union(Conjunto<T> A, Conjunto<T> B) {
		
		return null;
	}

	@Override
	public Conjunto<T> intersection(Conjunto<T> A, Conjunto<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conjunto<T> difference(Conjunto<T> A, Conjunto<T> B) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
	public boolean Equals(Conjunto<T> A) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return null;
	}

	

	

	

}

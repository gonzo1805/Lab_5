package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set;

public class EnumerableImpl<T> implements Enumerable<T> {

	T dato;
	int index;

	public EnumerableImpl(T dato, int index){
		this.dato = dato; 
		this.index = index;
	}
	
	@Override
	public int getIndex() {
		return this.index;
	}

	public T getDato() {
		return this.dato;
	}

}

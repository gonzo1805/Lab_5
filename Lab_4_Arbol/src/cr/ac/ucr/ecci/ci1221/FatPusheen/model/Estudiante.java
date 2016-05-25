package cr.ac.ucr.ecci.ci1221.FatPusheen.model;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set.Enumerable;

public class Estudiante implements Enumerable {
	
	int posicion;
	
	@Override
	public int getIndex() {
		return this.posicion;
	}
}

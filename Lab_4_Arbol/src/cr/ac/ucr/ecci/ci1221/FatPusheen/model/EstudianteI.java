package cr.ac.ucr.ecci.ci1221.FatPusheen.model;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.set.Enumerable;

public interface EstudianteI extends Comparable, Enumerable {


	@Override
	public int getIndex(); 

	public void setIndex(int index); 

	public int getEdad(); 

	public void setEdad(int edad);

	public String getCarne();

	public void setCarne(String carne);

	public int getCedula();

	public void setCedula(int cedula);

	@Override
	public int hashCode();

	@Override
	public int compareTo(Object comparacion);
}

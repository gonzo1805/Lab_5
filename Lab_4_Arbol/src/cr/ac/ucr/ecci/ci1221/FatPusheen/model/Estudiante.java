package cr.ac.ucr.ecci.ci1221.FatPusheen.model;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Set.Enumerable;


public class Estudiante implements Enumerable, Comparable {

	/**
	 * Atributos: index: sera la posicion en la lista de clase carne: un string
	 * con su carne estudiantil cedula: su cedula, sin 0´s ni guiones edad: la
	 * edad del estudiante
	 */
	int index;
	String carne;
	int cedula;
	int edad;

	public Estudiante(String carne, int cedula, int edad, int index) {
		this.carne = carne;
		this.cedula = cedula;
		this.edad = edad;
		this.index = index;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCarne() {
		return this.carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public int getCedula() {
		return this.cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	@Override
	public int hashCode() {
		int resultado;
		resultado = cedula + edad + Integer.parseInt(carne);
		resultado = resultado * 500 / 21;
		return resultado;
	}

	@Override
	public int compareTo(Object comparacion) {
		int primero = Integer.parseInt(this.carne);
		int segundo = Integer.parseInt();
		return 0;
	}

}

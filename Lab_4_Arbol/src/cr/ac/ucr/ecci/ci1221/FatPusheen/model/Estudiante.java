package cr.ac.ucr.ecci.ci1221.FatPusheen.model;

public class Estudiante implements EstudianteI {

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
		int carnet = carne.charAt(0) + Integer.parseInt(carne.substring(1));
		resultado = cedula + edad + carnet;
		resultado = (resultado) % 100 ;
		return resultado;
	}

	@Override
	public int compareTo(Object comparacion) {
		int primero = Integer.parseInt(this.carne);
		int segundo = Integer.parseInt(((Estudiante) comparacion).carne);
		int res = 0;
		if (primero < segundo) {
			res = -1;
		} else if (primero == segundo) {
			res = 0;
		} else if (primero > segundo) {
			res = 1;
		}
		return res;
	}

}

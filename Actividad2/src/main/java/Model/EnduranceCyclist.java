
package Model;

public class EnduranceCyclist extends Competidor {
    private final String speciality = "Endurance";

    public EnduranceCyclist(String nombre, int edad, String pais, int rankingMundial, double estatura, double peso) {
        super(nombre, edad, pais, rankingMundial, estatura, peso);
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "EnduranceCyclist{" + super.toString() + ", speciality='" + speciality + '\'' + '}';
    }
}

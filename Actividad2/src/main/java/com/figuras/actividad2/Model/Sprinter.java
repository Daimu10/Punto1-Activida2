
package com.figuras.actividad2.Model;


public class Sprinter extends Competidor {
    private final String speciality = "Sprint";

    public Sprinter(String nombre, int edad, String pais, int rankingMundial, double estatura, double peso) {
        super(nombre, edad, pais, rankingMundial, estatura, peso);
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "Sprinter{" + super.toString() + ", speciality='" + speciality + '\'' + '}';
    }
}

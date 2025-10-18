
package com.figuras.actividad2.Controller;


import Model.Competencia;
import Model.Competidor;
import Model.EnduranceCyclist;
import Model.Equipo;
import Model.Sprinter;

public class Controller {
    private final Competencia competencia;

    public Controller(Competencia competencia) {
        this.competencia = competencia;
    }

    public void agregarEquipo(Equipo e) { competencia.agregarEquipo(e); }

    public String generarReporte() { return competencia.generarReporte(); }

    public boolean crearEquipo(String nombre, String pais) {
        if (nombre == null || nombre.isBlank()) return false;
        Equipo existente = competencia.buscarEquipoPorNombre(nombre);
        if (existente != null) return false;
        competencia.agregarEquipo(new Equipo(nombre, pais));
        return true;
    }

    public boolean agregarCompetidorAEquipo(String nombreEquipo, Competidor c) {
        Equipo e = competencia.buscarEquipoPorNombre(nombreEquipo);
        if (e == null || c == null) return false;
        e.agregarCompetidor(c);
        return true;
    }

    public boolean actualizarRanking(String nombreEquipo, String nombreCompetidor, int puntos) {
        Equipo e = competencia.buscarEquipoPorNombre(nombreEquipo);
        if (e == null) return false;
        for (Competidor c : e.getCompetidores()) {
            if (c.getNombre().equalsIgnoreCase(nombreCompetidor)) {
                c.actualizarRanking(puntos);
                return true;
            }
        }
        return false;
    }

    public String listarEquipos() {
        StringBuilder sb = new StringBuilder();
        for (Equipo e : competencia.getEquipos()) sb.append(e.obtenerDatosEquipo()).append("\n");
        return sb.toString();
    }

    /**
     * Carga datos de prueba (equipos y competidores) en la competencia.
     * Útil para la presentación y pruebas manuales.
     */
    public void agregarDatosPrueba() {
        Equipo e1 = new Equipo("Huracanes", "Colombia");
        Equipo e2 = new Equipo("Velocistas", "España");
        Equipo e3 = new Equipo("Montañeses", "Argentina");

        Competidor c1 = new Sprinter("Juan Perez", 25, "Colombia", 12, 1.78, 72.0);
        Competidor c2 = new EnduranceCyclist("Maria Gomez", 28, "Colombia", 20, 1.65, 60.0);
        Competidor c3 = new Sprinter("Carlos Ruiz", 22, "España", 8, 1.80, 75.0);
        Competidor c4 = new EnduranceCyclist("Ana Martinez", 30, "Argentina", 15, 1.70, 62.0);
        Competidor c5 = new Sprinter("Luis Torres", 21, "Colombia", 30, 1.76, 68.0);

        e1.agregarCompetidor(c1);
        e1.agregarCompetidor(c2);
        e2.agregarCompetidor(c3);
        e3.agregarCompetidor(c4);
        e3.agregarCompetidor(c5);

        competencia.agregarEquipo(e1);
        competencia.agregarEquipo(e2);
        competencia.agregarEquipo(e3);
        // Aplicar algunas actualizaciones de ranking a los datos de prueba
        // usa ambos métodos sobrecargados para demostrar comportamiento
        c1.actualizarRanking(250);          // suma simple
        c2.actualizarRanking(180, 1.2);     // suma con factor
        c4.actualizarRanking(120);          // suma simple
        c5.actualizarRanking(300, 0.9);     // suma con factor (factor arbitrario)
    }
}

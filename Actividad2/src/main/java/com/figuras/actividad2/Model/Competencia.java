
package com.figuras.actividad2.Model;

import java.util.ArrayList;
import java.util.List;

public class Competencia {
    private final String nombreEvento;
    private final List<Equipo> equipos = new ArrayList<>();

    public Competencia(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void agregarEquipo(Equipo e) {
        equipos.add(e);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public Equipo buscarEquipoPorNombre(String nombre) {
        if (nombre == null) return null;
        for (Equipo e : equipos) {
            if (nombre.equalsIgnoreCase(e.getNombre())) return e;
        }
        return null;
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("Competencia: ").append(nombreEvento).append("\n");
        for (Equipo e : equipos) {
            sb.append(e.obtenerDatosEquipo()).append("\n");
        }
        return sb.toString();
    }
}


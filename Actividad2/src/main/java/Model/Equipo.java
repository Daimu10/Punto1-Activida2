
package Model;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private final String nombre;
    private final String pais;
    private final List<Competidor> competidores = new ArrayList<>();

    public Equipo(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public List<Competidor> getCompetidores() {
        return competidores;
    }

    public void agregarCompetidor(Competidor c) {
        this.competidores.add(c);
    }

    public String obtenerDatosEquipo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo: ").append(nombre).append(" (").append(pais).append(")\n");
        for (Competidor c : competidores) {
            sb.append("  - ").append(c.obtenerDatos()).append("\n");
        }
        return sb.toString();
    }
}


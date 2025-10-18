import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Model.Competencia;
import Model.Competidor;
import Model.Equipo;

public class CompetenciaTest {
    @Test
    public void testGenerarReporteContieneEquiposYCompetidores() {
        Competencia comp = new Competencia("TestEvent");
        Equipo e = new Equipo("Equipo1", "PaisX");
        Competidor c = new Competidor("Ana", 24, "PaisX", 30, 1.66, 58.0);
        e.agregarCompetidor(c);
        comp.agregarEquipo(e);

        String reporte = comp.generarReporte();
        assertNotNull(reporte);
        assertTrue(reporte.contains("Equipo"));
        assertTrue(reporte.contains("Ana"));
    }
}


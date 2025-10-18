import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.figuras.actividad2.Controller.Controller;
import Model.Competencia;
import Model.Competidor;
import Model.Equipo;
import Model.Sprinter;

public class ControllerTest {

    @Test
    public void testCrearEquipo() {
        Competencia comp = new Competencia("TestEvent");
        Controller controller = new Controller(comp);

        boolean created = controller.crearEquipo("EquipoTest", "Colombia");
        assertTrue(created, "Debe crear un equipo nuevo");

        // crear nuevamente con mismo nombre debe fallar
        boolean createdAgain = controller.crearEquipo("EquipoTest", "Colombia");
        assertFalse(createdAgain, "No se debe permitir crear dos equipos con el mismo nombre");

        // verificar que el equipo está en la competencia
        Equipo e = comp.buscarEquipoPorNombre("EquipoTest");
        assertNotNull(e, "El equipo creado debe estar presente en la competencia");
        assertEquals("EquipoTest", e.getNombre());
    }

    @Test
    public void testAgregarCompetidorAEquipo() {
        Competencia comp = new Competencia("TestEvent");
        Controller controller = new Controller(comp);

        controller.crearEquipo("EquipoA", "España");
        Competidor c = new Sprinter("Prueba", 20, "España", 50, 1.75, 70.0);

        boolean added = controller.agregarCompetidorAEquipo("EquipoA", c);
        assertTrue(added, "Debe añadir competidor al equipo existente");

        Equipo e = comp.buscarEquipoPorNombre("EquipoA");
        assertNotNull(e);
        assertEquals(1, e.getCompetidores().size());
        assertEquals("Prueba", e.getCompetidores().get(0).getNombre());

        // intentar añadir a equipo inexistente
        Competidor c2 = new Sprinter("Prueba2", 22, "España", 60, 1.80, 72.0);
        boolean added2 = controller.agregarCompetidorAEquipo("NoExiste", c2);
        assertFalse(added2, "No debe poder añadirse a un equipo inexistente");
    }
}

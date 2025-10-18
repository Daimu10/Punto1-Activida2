
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import Model.Competidor;

public class CompetidorTest {

    @Test
    public void testActualizarRankingSimple() {
        Competidor c = new Competidor("Test", 30, "País", 50, 1.7, 70.0);
        c.actualizarRanking(250);
        assertTrue(c.getPuntos() >= 250);
        assertTrue(c.getRankingMundial() <= 50);
    }

    @Test
    public void testActualizarRankingConFactor() {
        Competidor c = new Competidor("Test2", 28, "País", 10, 1.8, 75.0);
        c.actualizarRanking(150, 1.5);
        assertTrue(c.getPuntos() >= 150);
        assertTrue(c.getRankingMundial() <= 10);
    }
}

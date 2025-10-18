
package View;

import com.figuras.actividad2.Controller.Controller;
import Model.Competidor;
import Model.EnduranceCyclist;
import Model.Sprinter;

public class View {

    public void mostrar(String texto) {
        javax.swing.JOptionPane.showMessageDialog(null, texto);
    }

    public void iniciarMenu(Controller controller) {
        boolean running = true;
        while (running) {
            String opt = javax.swing.JOptionPane.showInputDialog(null,
                    """
                            --- Menú Competencias de Ciclismo ---
                            1) Crear equipo
                            2) Añadir competidor a equipo
                            3) Actualizar ranking de un competidor (sumar puntos)
                            4) Listar equipos y competidores
                            5) Generar reporte completo
                            6) Cargar datos de prueba (equipos y competidores)
                            0) Salir
                            Elige una opción:""");
            if (opt == null)
                break;
            opt = opt.trim();
            switch (opt) {
                case "1" -> {
                    String nombre = javax.swing.JOptionPane.showInputDialog(null, "Nombre equipo:");
                    if (nombre == null)
                        break;
                    String pais = javax.swing.JOptionPane.showInputDialog(null, "País:");
                    if (pais == null)
                        break;
                    boolean ok = controller.crearEquipo(nombre.trim(), pais.trim());
                    mostrar(ok ? "Equipo creado." : "No se pudo crear (ya existe o nombre inválido).");
                }
                case "2" -> {
                    String nombreEquipo = javax.swing.JOptionPane.showInputDialog(null, "Equipo destino:");
                    if (nombreEquipo == null)
                        break;
                    String nombre = javax.swing.JOptionPane.showInputDialog(null, "Nombre competidor:");
                    if (nombre == null)
                        break;
                    String edadStr = javax.swing.JOptionPane.showInputDialog(null, "Edad:");
                    if (edadStr == null)
                        break;
                    int edad = parseIntSafe(edadStr);
                    String pais = javax.swing.JOptionPane.showInputDialog(null, "País:");
                    if (pais == null)
                        break;
                    String rankingStr = javax.swing.JOptionPane.showInputDialog(null, "Ranking mundial (entero):");
                    if (rankingStr == null)
                        break;
                    int ranking = parseIntSafe(rankingStr);
                    String estStr = javax.swing.JOptionPane.showInputDialog(null, "Estatura (m):");
                    if (estStr == null)
                        break;
                    double est = parseDoubleSafe(estStr);
                    String pesoStr = javax.swing.JOptionPane.showInputDialog(null, "Peso (kg):");
                    if (pesoStr == null)
                        break;
                    double peso = parseDoubleSafe(pesoStr);
                    String tipo = javax.swing.JOptionPane.showInputDialog(null, "Tipo (1=Sprinter, 2=Endurance):");
                    if (tipo == null)
                        break;
                    Competidor c = ("2".equals(tipo.trim()))
                            ? new EnduranceCyclist(nombre.trim(), edad, pais.trim(), ranking, est, peso)
                            : new Sprinter(nombre.trim(), edad, pais.trim(), ranking, est, peso);
                    boolean added = controller.agregarCompetidorAEquipo(nombreEquipo.trim(), c);
                    mostrar(added ? "Competidor añadido." : "No se pudo añadir (equipo no existe).");
                }
                case "3" -> {
                    String nombreEquipo = javax.swing.JOptionPane.showInputDialog(null, "Equipo del competidor:");
                    if (nombreEquipo == null)
                        break;
                    String nombre = javax.swing.JOptionPane.showInputDialog(null, "Nombre del competidor:");
                    if (nombre == null)
                        break;
                    String puntosStr = javax.swing.JOptionPane.showInputDialog(null, "Puntos a sumar (entero):");
                    if (puntosStr == null)
                        break;
                    int puntos = parseIntSafe(puntosStr);
                    boolean ok = controller.actualizarRanking(nombreEquipo.trim(), nombre.trim(), puntos);
                    mostrar(ok ? "Ranking actualizado." : "Competidor o equipo no encontrado.");
                }
                case "4" -> mostrar(controller.listarEquipos());
                case "5" -> mostrar(controller.generarReporte());
                case "6" -> {
                    controller.agregarDatosPrueba();
                    mostrar("Datos de prueba cargados.");
                }
                case "0" -> {
                    running = false;
                    mostrar("Saliendo...");
                }
                default -> mostrar("Opción no válida.");
            }
        }
    }

    private int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private double parseDoubleSafe(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}

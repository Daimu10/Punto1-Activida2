
package com.figuras.actividad2.Model;


public class Competidor {
    private String nombre;
    private int edad;
    private String pais;
    private int rankingMundial;
    private double estatura;
    private double peso;
    private int puntos;

    public Competidor(String nombre, int edad, String pais, int rankingMundial, double estatura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
        this.rankingMundial = rankingMundial;
        this.estatura = estatura;
        this.peso = peso;
        this.puntos = 0;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getRankingMundial() {
        return rankingMundial;
    }

    public void setRankingMundial(int rankingMundial) {
        this.rankingMundial = rankingMundial;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPuntos() {
        return puntos;
    }

    // actualizar ranking basado en puntos obtenidos
    public void actualizarRanking(int puntosObtenidos) {
        this.puntos += puntosObtenidos;
        int delta = puntosObtenidos / 100; // cada 100 puntos mejora una posición
        this.rankingMundial = Math.max(1, this.rankingMundial - delta);
    }

    // sobrecarga de método: actualizarRanking con puntos y factor
    public void actualizarRanking(int puntosObtenidos, double factor) {
        if (factor <= 0) {
            actualizarRanking(puntosObtenidos);
            return;
        }
        int puntosCalc = (int) Math.round(puntosObtenidos * factor);
        actualizarRanking(puntosCalc);
    }

    // otro método sobrecargado: retornar puntos como String
    public String obtenerPuntos(String formato) {
        if ("simple".equals(formato))
            return Integer.toString(puntos);
        return String.format("%d pts", puntos);
    }

    // método para obtener datos
    public String obtenerDatos() {
        return toString();
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", pais='" + pais + '\'' +
                ", ranking=" + rankingMundial +
                ", estatura=" + estatura +
                ", peso=" + peso +
                ", puntos=" + puntos +
                '}';
    }
}

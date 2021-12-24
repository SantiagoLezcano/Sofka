
package Modelo;

public class ronda {
    private int id;
    private int dificultad; //del 1 al 5
    private int puntos;

    public ronda(int id, int dificultad, int puntos) {
        this.id = id;
        this.dificultad = dificultad;
        this.puntos = puntos;
    }

    public ronda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
}

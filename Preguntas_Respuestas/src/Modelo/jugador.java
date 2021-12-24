
package Modelo;

public class jugador {
    private int id;
    private String nombre;
    private int idRonda;
    private int puntajeTotal;
    private int estado; //ganador (1)- perdedor

    public jugador(int id, String nombre, int idRonda, int puntajeTotal, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.idRonda = idRonda;
        this.puntajeTotal = puntajeTotal;
        this.estado = estado;
    }

    public jugador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}

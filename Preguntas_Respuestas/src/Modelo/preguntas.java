
package Modelo;

public class preguntas{
    private int id;
    private int idRonda;
    private String pregunta;
    private static int rondaNumero=0;
    private jugador jugador;
    
    public preguntas(jugador jugador){
       this.jugador=jugador;
    }
    
    public preguntas(int id, int idRonda, String pregunta) {
        this.id =id;
        this.idRonda = idRonda;//DIFIUCULTAD DADA POR RONDA
        this.pregunta = pregunta;
    }
    
    public preguntas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getRondaNumero() {
        return rondaNumero;
    }

    public void setRondaNumero(int rondaNumero) {
        this.rondaNumero = rondaNumero;
    }
    
    
}


package Modelo;

public class opciones {
    private int id;
    private int idPregunta;
    private String respuestas;
    private int respuestaEs; //correcta 1 falsa 0 por motivos de BD

    public opciones(int id, int idPregunta, String respuestas, int respuestaEs) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.respuestas = respuestas;
        this.respuestaEs = respuestaEs;
    }

    public opciones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    public int getRespuestaEs() {
        return respuestaEs;
    }

    public void setRespuestaEs(int respuestaEs) {
        this.respuestaEs = respuestaEs;
    }
    
    
}

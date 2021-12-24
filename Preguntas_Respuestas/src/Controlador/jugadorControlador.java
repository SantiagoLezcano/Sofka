
package Controlador;

import Modelo.BD;
import Modelo.jugador;


public class jugadorControlador {
    
    public jugador crearJugador(int id, String nom){
        
        jugador juga = new jugador(id,nom,1,0,0);
        BD accesoBD= new BD();
        try{
            
            accesoBD.getConnection();
            accesoBD.InsertarBD(juga);
            accesoBD.cerrarConexion();
        }catch(Exception exc){
            accesoBD.cerrarConexion();
            System.out.println("Error " + exc.getMessage());
        }
        return juga;
    }
}

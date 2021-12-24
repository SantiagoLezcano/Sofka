/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santiago
 */
public class preguntasControlador {
    private int idpreguntamomento;
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsmd = null;
    public String generarPregunta() {
        int numAleatorio = (int) (Math.random() * 5);
       // System.out.println(numAleatorio);
        ronda rd = new ronda();
        preguntas pr = new preguntas();
        int filaguardada;
        String pregunta = "equisde";
        BD bd = new BD();
        bd.getConnection();
        Connection con = bd.getConnection();
        
        try {
            if(rd.getId()<=5){ 
            Statement stm = bd.getConnection().createStatement();
            rs = stm.executeQuery("SELECT * FROM Preguntas INNER JOIN Ronda "
                    + "ON Preguntas.idRonda=Ronda.id "
                    + "WHERE Ronda.id=" + (pr.getIdRonda() + 1));

            rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            String[] fila = new String[columnas];
            int i=0;
            while (rs.next()) {
               fila[i]=rs.getString(1);
                    if(numAleatorio==i){
                        pregunta=rs.getString("pregunta");
                        idpreguntamomento=Integer.parseInt(rs.getString(1));
                    }
                i++;
            }
            
            return pregunta;
            
        //}
        //catch (SQLException e) {
        }else{
               Puntaje puntaje= new Puntaje(); 
               puntaje.setVisible(true);
               Preguntas preguntas =new Preguntas();
               preguntas.setVisible(false);
                }
        
        bd.cerrarConexion();
        return "nulo";
        
        
    }catch(SQLException e){
            System.out.println(e.getMessage());
    }
        return null;
    }

    public int numColumnasBD() {
        try {
            int columnas = rsmd.getColumnCount();
            return columnas;
        } catch (SQLException e) {
            return 0;
        }
    }

    public int getIdpreguntamomento() {
        return idpreguntamomento;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BD;
import Modelo.opciones;
import Modelo.preguntas;
import Modelo.ronda;
import Vista.Preguntas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class opcionesControlador {
    PreparedStatement ps;

    ResultSet rs;
    ResultSetMetaData rsmd = null;

    public String[] generarOpciones(int preguntaid) {
        BD bd = new BD();
        preguntas pr= new preguntas();
        bd.getConnection();
        Connection con = bd.getConnection();
        int i=0;
        try {
            Statement stm = bd.getConnection().createStatement();
            rs = stm.executeQuery("SELECT * FROM Opciones "
                    + "WHERE Opciones.idPregunta="+preguntaid);
            rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            String[] respuesta = new String[4];
            
            while (rs.next()){
                   respuesta[i]=rs.getString("respuesta");
                   i++;  
//                   System.out.println(respuesta[i]);
            }
//            System.out.println(respuesta[0]);
//            System.out.println(respuesta[1]);
//            System.out.println(respuesta[2]);
//            System.out.println(respuesta[3]);ntln("re" + rs.getString("respuesta"));
////          System.out.println(respuesta[i]);
////          System.out.println("hola");
////          System.out.println(columnas);
////          System.out.println(i);
            return respuesta;
        } catch (SQLException e) {
        }
        bd.cerrarConexion();
        return null;
    }
     public String generarRespuestaCorrecta(int preguntaid) {
        BD bd = new BD();
        preguntas pr= new preguntas();
        bd.getConnection();
        Connection con = bd.getConnection();
        int i=0;
        try {
            Statement stm = bd.getConnection().createStatement();
            rs = stm.executeQuery("SELECT * FROM Opciones "
                    + "WHERE Opciones.idPregunta="+preguntaid);
            rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            String respuestaCo = "vacio";
            
            while (rs.next()){
                   if(rs.getString("respuestaEs").equals("1"))
                   respuestaCo=rs.getString("respuesta");
                   i++;  
//                   System.out.println(respuesta[i]);
            }
            //System.out.println(respuestaCo);
//            System.out.println(respuesta[0]);
//            System.out.println(respuesta[1]);
//            System.out.println(respuesta[2]);
//            System.out.println(respuesta[3]);ntln("re" + rs.getString("respuesta"));
////          System.out.println(respuesta[i]);
////          System.out.println("hola");
////          System.out.println(columnas);
////          System.out.println(i);
            return respuestaCo;
        } catch (SQLException e) {
        }
        bd.cerrarConexion();
        return null;
    }

     public int validarSeleccion(String [] op,String correct){
        String[] opciones= new String[4];
        opciones=op; 
        
        if(opciones[0].equals(correct)){
            return 0;
        }else if(opciones[1].equals(correct)){
            return 1;
        }else if(opciones[2].equals(correct)){
            return 2;
        }else if(opciones[3].equals(correct)){
            return 3;
        }
        return 5;//no entro al ciclo
        
     }
}

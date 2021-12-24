package Modelo;

import java.sql.*;

public class BD {

    Statement s;
    Connection connection = null;

    public Connection getConnection() {

        String user = "santiago";
        String pass = "123456";
        String bd = "PreguntasRespuestas";
        String ip = "localhost";
        String puerto = "1433";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionDB = "jdbc:sqlserver://localhost;databaseName=" + bd + ";user=" + user + ";password=" + pass + ";";
            connection = DriverManager.getConnection(connectionDB);
        } catch (ClassNotFoundException E) {
            System.out.println("Error " + E.getMessage());
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error  " + e.getMessage());
        }
        return connection;
    }

    public boolean InsertarBD(jugador juga) {
        try {
            int filaguardada;
            s = connection.createStatement();
            filaguardada = s.executeUpdate("Insert into dbo.Jugador values('" + juga.getId() + "', '" + juga.getNombre() + "','" + juga.getIdRonda()
                    + "','" + juga.getPuntajeTotal() + "','" + juga.getEstado() + "')");
            if (filaguardada == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean ActualizarBD(jugador juga,ronda ronda, int respuestaEs) {
        int filaguardada;
        juga.setId(ronda.getId());
        if(respuestaEs==1)
            juga.setPuntajeTotal(juga.getPuntajeTotal()+ronda.getPuntos());
        if(respuestaEs==1 && ronda.getId()==5)
           juga.setEstado(1);
        try{
            s = connection.createStatement();
        filaguardada = s.executeUpdate("SELECT * FROM Jugador;"
                + "GO"
                + "UPDATE Jugador SET rondaID ="+juga.getIdRonda()+", puntajeTotal="+juga.getPuntajeTotal()
                +"WHERE id="+juga.getId());
        if (filaguardada == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
            
        
        
    }

    public void cerrarConexion() {

        try {

            connection.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean InsertarBD(int id, String nom, int idRonda, int puntajeTotal, int estado) {

        try {

            int filaguardada;

            s = connection.createStatement();

            filaguardada = s.executeUpdate("Insert into dbo.Jugador values('" + id + "', '" + nom + "','" + idRonda + "','" + puntajeTotal + "','" + estado + "')");

            //filaguardada = cstmt.executeUpdate();
            if (filaguardada == 1) {

                return true;

            } else {

                return false;
            }

        } catch (Exception ex) {

            return false;

        }

    }

//    public static Connection establecerConexion(){
//        try{
//            String cadena="jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd;
//            conectar=DriverManager.getConnection(cadena,user,pass);
//            JOptionPane.showMessageDialog(null, "CONECTADO!");
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error" + e.toString());
//        }
//        return conectar;
//    }
}

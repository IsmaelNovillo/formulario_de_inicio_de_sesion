import org.w3c.dom.ls.LSOutput;

import java.sql.*;

public class Conect {

    static final String DB_URL="jdbc:mysql://localhost/INSTITUCION";
    //credenciales de la base
    static final String USER="root";
    static final String PASS="root_bas3";
    //el querry da lo que vas a traer de la base

    static final String QUERY="SELECT * from Estudiantes where ID = ";
    static final String QUERY_DEL="DELET from Estudiantes where ID = ";
    String Password;
    public void coneccion(String x){
        //comando select
        try(
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt= conn.createStatement();

                ResultSet rs= stmt.executeQuery(QUERY+x);
        ){
            //impresion de valores de la base
            while(rs.next()){
                System.out.println("id:"+rs.getInt("ID"));
                System.out.println("nombre:"+rs.getString("NOMBRE"));
                System.out.println("CONTRA:"+rs.getString("CONTRASEÑA"));
                Password = rs.getString("CONTRASEÑA");

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void ELIMINAR(String x){
        //comando delete
        try(
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stm = conn.createStatement()
        ){
            String QUERY_DEL="DELETE from Estudiantes where ID = "+x;
            stm.executeUpdate(QUERY_DEL);
            System.out.println("usuario eliminado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void aniadir(String x,String z){
        //comando delete
        try(
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stm = conn.createStatement()
        ){
            String QUERY_DEL="INSERT INTO Estudiantes (ID,CONTRASEÑA) VALUES  ("+x+','+'"'+z+'"'+')';
            stm.executeUpdate(QUERY_DEL);
            System.out.println("usuario AÑADIDO");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void UPDATE(String x,String z,String a){
        //comando delete
        try(
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stm = conn.createStatement()
        ){
            String QUERY_DEL="UPDATE ESTUDIANTES SET NOMBRE ="+'"'+z+'"'+ ", CONTRASEÑA ="+'"'+a+'"' +"WHERE ID ="+x;
            stm.executeUpdate(QUERY_DEL);
            System.out.println("usuario ACTUALIZADO");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
///FINAL

}

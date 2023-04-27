package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertClient {
  public static void main(String[] args) {
    
    Connection conexion;
    String url="jdbc:mysql://localhost:3306/supermercado";
    String usuario="root";
    String clave="michi";
    String consulta= "insert into cliente(ClientDni,ClientNom,ClientApe,ClientDom,ClientTel,ClientMail) values ('41345678','Jero','Perez','Calle 40','2689346557','jero567@gmail.com')";
        
    try {
    	Class.forName("com.mysql.jdbc.Driver");     
        conexion=DriverManager.getConnection(url,usuario,clave);    
        Statement sentencia=conexion.createStatement();
        sentencia.execute(consulta);   
        System.out.println("¡Se han agregado los nuevos datos a la tabla!");
    } catch (Exception e) {  
      e.printStackTrace();
      System.out.println("¡¡Error en la inserción de datos!!");
    }
   
  }
}
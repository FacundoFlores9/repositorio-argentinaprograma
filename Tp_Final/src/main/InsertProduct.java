package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertProduct {
  public static void main(String[] args) {
    
    Connection conexion;
    String url="jdbc:mysql://localhost:3306/supermercado";
    String usuario="root";
    String clave="michi";
    String consulta= "insert into productos(IDProd,NomProd,DescProd,FecVenProd,OrigProd,PrecProd) values ('31','Manteca','0','2025-04-28','Argentina','450')";
        
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
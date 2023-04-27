package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import com.mysql.jdbc.Statement;

public class DeleteProduct {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection conexion;
	    String url="jdbc:mysql://localhost:3306/supermercado";
		String usuario="root";
		String password="michi";
		
		System.out.println("Escriba el ID del producto a eliminar: ");
		int IDProd  = scanner.nextInt(); 
		
	    String Delete ="DELETE FROM productos WHERE IDProd = '"+IDProd+"'";

	
    try {
    	Class.forName("com.mysql.jdbc.Driver");     
        conexion=DriverManager.getConnection(url,usuario,password);    
        Statement sentencia = (Statement) conexion.createStatement();
        sentencia.execute(Delete);   
        System.out.println("¡El producto fue eliminado!");
    } catch (Exception e) {  
      e.printStackTrace();
      System.out.println("Error en el borrado del registro!!");
    }
  }
}
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueriesSql {
	Connection conexion = null;
    Statement sentencia = null; 
    
    public static void main(String[] args) {
		QueriesSql queriesSql = new QueriesSql();
		queriesSql.conectar();
		queriesSql.consultarTabla();
		queriesSql.consultarTablaP();
		queriesSql.desconectar();
	}
	
	 public void conectar() {
		 try{
			    Class.forName("com.mysql.jdbc.Driver");
			   conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado","root","michi");
			    System.out.println("Conexion exitosa!!");
			    
			}catch (ClassNotFoundException e){
			    System.out.println("Error al cargar el controlador!!!!");
			    e.printStackTrace();
			    
			}catch (SQLException e){
			    System.out.println("Error en la conexion!!!!");
			    e.printStackTrace();
			    
			}catch (Exception e){
			    System.out.println("Error en la conexion!!!!");
			    e.printStackTrace();
			}

	    }// FIN METODO CONECTAR
	
	public void consultarTabla() {
	    ResultSet r = buscar("select ClientDni,ClientNom,ClientApe,ClientDom,ClientTel,ClientMail from cliente");  
	    
	    try {
	        System.out.println("REGISTROS DE LA TABLA CLIENTES");
	        
	        while (r.next()) {
	        	System.out.println(r.getInt("ClientDni") + " | " + r.getString("ClientNom") + " | " + r.getString("ClientApe") + " | " + r.getString("ClientDom") + " | " + r.getString("ClientTel")  + " | " + r.getString("ClientMail"));
	        }
	    } catch (SQLException ex) {
	    	Logger.getLogger(QueriesSql.class.getName()).log(Level.SEVERE, null, ex);
	   }
	}
    
	public void consultarTablaP() {
	    ResultSet r = buscar("select IDProd,NomProd,DescProd,FecVenProd,OrigProd,PrecProd from productos"); 
	    
	    try {
	        System.out.println("REGISTROS DE LA TABLA PRODUCTOS");
	        
	        while (r.next()) {
	        	System.out.println(r.getInt("IDProd") + " | " + r.getString("NomProd") + " | " + r.getString("DescProd") + " | " + r.getString("FecVenProd") + " | " + r.getString("OrigProd")  + " | " + r.getString("PrecProd"));
	        }
	    } catch (SQLException ex) {
	    	//Logger.getLogger(QueriesSql.class.getName()).log(Level.SEVERE, null, ex);
	   }
	}

    ResultSet buscar(String sql) {
        try {
            sentencia = conexion.createStatement(); 
            return sentencia.executeQuery(sql);  
        } catch (SQLException ex) {
            Logger.getLogger(QueriesSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    
    private void desconectar() {
        try {
            conexion.close(); 
            System.out.println("\n************************************************************\n");
            System.out.println("La conexion a la base de datos se ha terminado");
            System.out.println("\n************************************************************");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }catch (Exception ex) {
            System.out.println("error");
        }
    }
    
    
}
    	
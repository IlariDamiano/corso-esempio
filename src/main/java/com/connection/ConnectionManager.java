//RESPONSABILITA' : GESTIONE DELLA CONNESSIONE

package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionManager implements ConnectionParameters{
	
	// Apertura della connessione e restituzione della stessa
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//1.1 (Indicazione del Driver di connessione)
		Class.forName(dbDriver);
				
		//1.2 (Indicazione di URL, Username e Password senza variabile, ritornandolo direttamente)
		return DriverManager.getConnection(dbUrl, dbUser, dbPass);
		
	}
	
	//Inizializzazione di un Oggetto PreparedStatement e restituzione dello stesso
	
	public static PreparedStatement getPreparedStatement(String sql, Connection con) throws ClassNotFoundException, SQLException {
		
		return con.prepareStatement(sql);
		
	}

	// inizializzazione di un ResultSet (struttura dati JDBC) 
	//già contenente le operazioni date dal DB rispetto alla
	//query di lettura passata in input al metodo
	public static ResultSet getResultSet(String sql, Connection con) throws SQLException {
		
		return con.createStatement().executeQuery(sql);
		
		//si può scrivere anche così:
//		Statement stmt = con.createStatement();
//		
//		ReultSet rs = stmt.executeQuery(sql);
//		
//		return rs;
		
	}
	
	
	//chiusura della connessione
	
	public static void closeConnection(Connection con) throws SQLException {
		
		con.close();
		
		// Equivalente a fare: 
		// con = null;
		
	}
}


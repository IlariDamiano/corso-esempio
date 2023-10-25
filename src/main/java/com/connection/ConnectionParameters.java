//RESPONSABILITA' : CONFIGURAZIONE DEI PARAMETRI DI CONNESSIONE

package com.connection;

public interface ConnectionParameters {
	
	//driver di connessione
	static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	//url con nome macchina, porta e nome DB
	static final String dbUrl = "jdbc:mysql://localhost:3308/corso";
	//indicare username e password
	static final String dbUser = "root";
	static final String dbPass = "";

}

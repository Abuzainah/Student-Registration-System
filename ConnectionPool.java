package com.abd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectionPool {
    private ArrayList<Connection>connections=new ArrayList<>();
    private int counter=0;

    public ConnectionPool(int maximumConnectionsNumber,String urlOfDataBase,String userName,String password){
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        for(int i=0;i<maximumConnectionsNumber;i++){
            try{
                connections.add(DriverManager.getConnection(urlOfDataBase,userName,password));
                counter++;
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public synchronized Connection getConnection(){
        if(counter==0) return null;
        Connection connection=connections.remove(connections.size()-1);
        counter--;
        return connection;
    }
    public synchronized void returnConnection(Connection connection){
    
        connections.add(connection);
        counter++;
    }
    public synchronized void closePool(){
        for(int i=0;i<counter;i++){
            try{
                connections.get(i).close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

package org.email.utility;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
  private static ConnectionPool pool=null;
  private static DataSource dataSource=null;

  private ConnectionPool(){
    try{
      InitialContext initialContext=new InitialContext();
      dataSource=(DataSource)initialContext.lookup("java:/comp/env/jdbc/murach");

    }catch(NamingException e){

    }
  }

  public static ConnectionPool getInstance(){
    if(pool==null){
      pool=new ConnectionPool();
    }
    return pool;
  }

  public Connection getConnection(){
    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void freeConnection(Connection c){
    try {
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

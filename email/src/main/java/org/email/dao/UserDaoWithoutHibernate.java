package org.email.dao;

import org.email.entity.User;
import org.email.utility.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoWithoutHibernate {

  public static int insert(User user){
    ConnectionPool pool=ConnectionPool.getInstance();
    Connection connection=pool.getConnection();
    String query="insert into User(Email,FirstName,LastName)"+"values(?,?,?)";
    PreparedStatement statement=null;
    try {
      statement=connection.prepareStatement(query);
      statement.setString(1,user.getEmail());
      statement.setString(2,user.getFirstName());
      statement.setString(3,user.getLastName());
      return statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }finally {
      try {
        pool.freeConnection(connection);
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }

    }
  }

  public static int update(User user){
    ConnectionPool pool=ConnectionPool.getInstance();
    Connection connection=pool.getConnection();
    String query="UPDATE User SET"+
        "FirstName=?"+
        "LastName=?"+
        "Email=?";
    PreparedStatement statement=null;
    try {
      statement=connection.prepareStatement(query);
      statement.setString(3,user.getEmail());
      statement.setString(1,user.getFirstName());
      statement.setString(2,user.getLastName());
      return statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }finally {
      try {
        pool.freeConnection(connection);
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

    public static void delete(String email){
      ConnectionPool pool=ConnectionPool.getInstance();
      Connection connection=pool.getConnection();
      String query="Delete From User where"+"Email=?";
      PreparedStatement statement=null;
      try {
        statement=connection.prepareStatement(query);
        statement.setString(1,email);
        statement.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }finally {
        try {
          pool.freeConnection(connection);
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

    }

    public static boolean emailExists(String email){

      ConnectionPool pool=ConnectionPool.getInstance();
      Connection connection=pool.getConnection();
      String query="SELECT From User where"+"Email=?";
      PreparedStatement statement=null;
      try {
        statement=connection.prepareStatement(query);
        statement.setString(1,email);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
          if(resultSet.getString("Email").equals(email)){
            return true;
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }finally {
        try {
          pool.freeConnection(connection);
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      return false;
  }

  public static User selectUser(String email) {
    User user=null;
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    String query = "SELECT From User where" + "Email=?";
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(query);
      statement.setString(1, email);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        if (resultSet.getString("Email").equals(email)) {
          user=new User();
          user.setEmail(resultSet.getString(1));
          user.setFirstName(resultSet.getString(2));
          user.setLastName(resultSet.getString(3));
          return user;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pool.freeConnection(connection);
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return user;
  }
}

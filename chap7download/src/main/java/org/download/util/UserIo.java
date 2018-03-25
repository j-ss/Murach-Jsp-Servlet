package org.download.util;

import org.download.entity.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserIo {

  public static void save(User user,String path){
    try {
      ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(path));
      outputStream.writeObject(user);
    } catch (IOException e) {
      Logger logger= Logger.getLogger(UserIo.class.getClass().getName());
      logger.log(Level.WARNING,e.getMessage());
    }
  }
  public static User getUser(String email,String path){
    Logger logger= Logger.getLogger(UserIo.class.getClass().getName());
    User user=null;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
         user=(User)inputStream.readObject();
    } catch (FileNotFoundException e) {
      logger.log(Level.WARNING,e.getMessage());
    } catch (IOException e) {
      logger.log(Level.WARNING,e.getMessage());
    } catch (ClassNotFoundException e) {
      logger.log(Level.WARNING,e.getMessage());
    }
   return user;
  }
}

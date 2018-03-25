package org.email.dao;

import org.email.entity.User;
import org.email.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {

  private  static SessionFactory sessionFactory=HibernateUtility.getSessionFactory();
  public static void save(User user){
    Session session=sessionFactory.openSession();
    session.saveOrUpdate(user);
  }
}

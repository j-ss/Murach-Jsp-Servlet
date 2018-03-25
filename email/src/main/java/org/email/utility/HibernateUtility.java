package org.email.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

  public static SessionFactory getSessionFactory(){
    Configuration configuration=new Configuration();
    configuration.configure("classpath:hibernate.cfg.xml");
    return configuration.buildSessionFactory();
  }
}

package org.email.controller;

import org.email.dao.UserDao;
import org.email.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailListServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    String action=req.getParameter("action");
    String url="/index.jsp";
    String message="";
    if(action.equals("add")){
      String fname=req.getParameter("fname").trim();
      String lname=req.getParameter("lname").trim();
      String email=req.getParameter("email");
      // test
      String contactBy=req.getParameter("contactVia");
      String music1=req.getParameter("jazz");
      String music2=req.getParameter("rock");
      String music3=req.getParameter("bluegrass");
      String country[]=req.getParameterValues("country");
      System.out.println(contactBy+"\n"+music1+" "+music2+" "+music3);
      for(String c:country){
        System.out.println(c);
      }
      User user=new User(fname,lname,email);
      /**
       * validate data
       */
      if(fname.isEmpty()||lname.isEmpty()){
        message="please fill all details correct";
            url="/index.jsp";
      }else {
        UserDao.save(user);
        req.setAttribute("user", user);
        url = "/thanks.jsp";
      }
    }
    if(action==null){
      action="join";
    }
    if(action.equals("join")){
      url="/index.jsp";
    }

    req.setAttribute("message",message);
    req.getRequestDispatcher(url).forward(req,resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    doPost(req,resp);
  }
}

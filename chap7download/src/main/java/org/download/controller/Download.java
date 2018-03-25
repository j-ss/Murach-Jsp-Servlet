package org.download.controller;

import org.download.entity.User;
import org.download.util.UserIo;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "downloadServlet",urlPatterns = {"/download"},loadOnStartup = 1)
public class Download extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action=req.getParameter("action");
    String url=null;
    if(action==null){
      action="viewAlbums";
    }
    if(action.equals("viewAlbums")){
      url="/index.jsp";
    }
    if(action.equals("checkUser")){
      url=checkUser(req,resp);
    }
    req.setAttribute("productCode",req.getParameter("productCode"));
    getServletContext().getRequestDispatcher(url).forward(req,resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String action=req.getParameter("action");
    String url;
    if(action==null){
      url="/register.jsp";
    }
    if(action.equals("registerUser")){

      String email=req.getParameter("email");
      String firstName=req.getParameter("firstName");
      String lastName=req.getParameter("lastName");
      firstName=firstName.trim();
      lastName=lastName.trim();
      if(firstName==null||lastName==null){
        url="/register.jsp";
      }else{
        User user=new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        HttpSession session=req.getSession();
        session.setMaxInactiveInterval(60*60);
        session.setAttribute("user",user);
        Cookie cookie=new Cookie("email",email);
        cookie.setMaxAge(60*60);
        cookie.setPath("/");
        resp.addCookie(cookie);
        ServletContext sc=getServletContext();
        UserIo.save(user,sc.getRealPath("/WEB-INF/emaillist.txt"));
        url="/index.jsp";
      }
      getServletContext().getRequestDispatcher(url).forward(req,resp);
    }
  }

  public String checkUser(HttpServletRequest request, HttpServletResponse resp){

    String productCode=request.getParameter("productCode");
    System.out.println(productCode);
    HttpSession session=request.getSession();
    User user=(User)session.getAttribute("user");

    String url;
    if(user==null){
      Cookie[] cookies=request.getCookies();
      String email=null;
      for(Cookie cookie:cookies){
        if(cookie.getName().equals("email")){
          email=cookie.getValue();
        }
      }
      if(email==null){
        url="/register.jsp";
      }else{
        ServletContext sc=getServletContext();
        User user1= UserIo.getUser(email,sc.getRealPath("/WEB-INF/emaillist.txt"));
        session.setAttribute("user",user1);
        session.setMaxInactiveInterval(60*60);
        url="/"+productCode+"_download.jsp";
      }
    }else{
      url="/"+productCode+"_download.jsp";
    }
    return url;
  }
}

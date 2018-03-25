package org.cart.controller;

import org.cart.dao.ProductIo;
import org.cart.entity.Cart;
import org.cart.entity.LineItem;
import org.cart.entity.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String action = req.getParameter("action");
    if (action == null) {
      action = "cart";
    }
    String url = "/index.jsp";
    if (action.equals("shop")) {
      url = "/index.jsp";
    }
    else if (action.equals("cart")) {
      String productCode = req.getParameter("productCode");
      String quantityString = req.getParameter("quantity");
      HttpSession session = req.getSession();
      Cart cart = (Cart) session.getAttribute("cart");
      if (cart == null) {
        cart = new Cart();
      }
      int quantity;
      try {
        quantity = Integer.parseInt(quantityString);
        if (quantity < 0) {
          quantity = 1;
        }
      } catch (NumberFormatException e) {
        quantity = 1;
      }
      Product product=new ProductIo().getProduct(productCode);
      LineItem lineItem=new LineItem();
      lineItem.setProduct(product);
      lineItem.setQuantity(quantity);
      if(quantity>0){
        cart.addItem(lineItem);
      }
      if(quantity==0){
        cart.removeItem(lineItem);
      }

      session.setAttribute("cart",cart);
      url="/cart.jsp";
    }
    else if(action.equals("checkout")){
      url="/checkout.jsp";
    }

    getServletContext().getRequestDispatcher(url).forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doGet(req,resp);
  }
}

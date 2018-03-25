package org.cart.entity;

import java.text.NumberFormat;

public class LineItem {

  private Product product;
  private int quantity;

  public LineItem() {
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotal(){
    return quantity*product.getPrice();
  }

  public String getTotalCurrencyFormat(){
    NumberFormat format=NumberFormat.getCurrencyInstance();
    return format.format(this.getTotal());
  }
}

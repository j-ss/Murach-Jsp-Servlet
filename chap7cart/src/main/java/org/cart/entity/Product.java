package org.cart.entity;

import java.text.NumberFormat;

public class Product {
  private String productCode;
  private String description;
  private double price;

  public Product() {
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getCurencyFormat(){
    NumberFormat format= NumberFormat.getCurrencyInstance();
    return format.format(price);
  }
}

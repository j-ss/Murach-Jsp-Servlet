package org.cart.dao;

import org.cart.entity.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductIo {

  private Path path= Paths.get("/home/patel/jogi/projects/murach/chapter7cart/src/main/resources/products.txt");
  public List<Product> getProducts(){

    BufferedReader reader=null;
    ArrayList<Product> products=new ArrayList<>();
    String line=null;
    try {
      reader= Files.newBufferedReader(path);
      line=reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (line!=null){
      String[] productInfo=line.split("\\|");
      Product product=new Product();
      product.setProductCode(productInfo[0]);
      product.setDescription(productInfo[1]);
      product.setPrice(Double.parseDouble(productInfo[2]));
      products.add(product);
      try {
        line=reader.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return products;
  }

  public Product getProduct(String productCode){
    BufferedReader reader=null;
    String line=null;
    try {
      reader= Files.newBufferedReader(path);
      line=reader.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (line!=null){
      String[] product=line.split("\\|");
      if(productCode.equals(product[0])){
        Product product1=new Product();
        product1.setProductCode(product[0]);
        product1.setDescription(product[1]);
        product1.setPrice(Double.parseDouble(product[2]));
        return product1;
      }
      try {
        line=reader.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}

package org.cart.entity;

import java.util.ArrayList;

public class Cart {

  private ArrayList<LineItem> lineitems;

  public Cart() {
    lineitems=new ArrayList<>();
  }

  public ArrayList<LineItem> getLineitems() {
    return lineitems;
  }

  public int getCount(){
    return lineitems.size();
  }

  public void addItem(LineItem item){
    String code=item.getProduct().getProductCode();
    int quantity=item.getQuantity();
    for (LineItem lineitem:lineitems) {
      if(lineitem.getProduct().getProductCode().equals(code)){
        lineitem.setQuantity(quantity);
        return;

      }

    }

    lineitems.add(item);
  }

  public void removeItem(LineItem item){
    String code=item.getProduct().getProductCode();
    for (LineItem lineitem:lineitems) {
      if(lineitem.getProduct().getProductCode().equals(code)){
        lineitems.remove(lineitem);
        return;
      }
    }
  }
}

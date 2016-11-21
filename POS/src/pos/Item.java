/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author waltersanchez
 */
public class Item {
    private final StringProperty name;
    private final IntegerProperty qty; 
    private final IntegerProperty price; 
    private final IntegerProperty total; 
    public Item(String name, int qty, int price,int total) {
        this.name = new SimpleStringProperty(name);
        this.qty = new SimpleIntegerProperty(qty);
        this.price = new SimpleIntegerProperty(price);
        this.total=new SimpleIntegerProperty(qty*price);
    }
    public StringProperty nameProperty()
    {
      return  name;
    }
    public IntegerProperty qtyProperty()
    {
      return  qty;
    }
    public IntegerProperty priceProperty()
    {
      return  price;
    }
    public IntegerProperty totalProperty()
    {
      return  total;
    }

    
    public String getName() {
        return name.get();
    }

    public int getQty() {
        return qty.get();
    }

    public int getPrice() {
        return price.get();
    }

    public int getTotal() {
        return total.get();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public void setQty(int qty) {
        this.qty.set(qty);
    }

    public void setPrice(int price) {
        this.price.set(price);
    }
    
    public void setTotal(int total) {
        this.total.set(total);
    }   
    
    
    
    
    
}

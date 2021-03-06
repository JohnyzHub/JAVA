package com.corejava.design.patterns.behavioral.memento;

public class Item {

   private String name;

   private double price;

   public Item(String name, double price) {
      this.name = name;
      this.price = price;
   }

   public String toString() {
      return name + "@price- " + price + "\n";
   }
}

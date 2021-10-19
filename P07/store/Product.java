public abstract class Product
{
 protected String name;
 protected double price;
 protected double cost;
 
 public Product(String name, double price, double cost)
 {
  this.name = name;
  this.price = price;
  this.cost = cost;
 }
 
 public String name()
 {
  return name;
 }
 
 @Override
 public String toString()
 {
  return "Name: " + name + "\n" + "Cost: " + cost + "\n" + "Price: " + price;
 }
 
}

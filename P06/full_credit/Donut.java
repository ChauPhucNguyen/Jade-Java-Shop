public class Donut extends Product
{
 public enum Frosting {unfrosted,chocolate,vanilla,strawberry}
 public enum Filling {unfilled,creme,Bavarian,strawberry}
 
 protected Frosting frosting;
 protected boolean sprinkles;
 protected Filling filling;
 
 public Donut(String name, double price, double cost, Frosting frosting, boolean sprinkles, Filling filling)
 {
  super(name,price,cost);
  this.frosting = frosting;
  this.sprinkles = sprinkles;
  this.filling = filling;
 }
 
 @Override
 public String toString()
 {
  return name + " (frosted with " + frosting + " filled with " + filling + ") $" +price;
 }
}

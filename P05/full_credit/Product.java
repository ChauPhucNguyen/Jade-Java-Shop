abstract class Product
{  
   protected String name;
   protected double unitCost;
   protected int quantity;
   
   public Product(String name, double unitCost)
   {
    this.name = name;
    this.unitCost = unitCost;
   }
   
   public abstract void placeOrder(int quantity);
   
   public abstract double price();
   
   @Override
   public String toString()
   {
    if(quantity > 0)
    {
     return name + "(" + quantity + " " + "@" + " " + "$" + unitCost + ")";
    }
    else
    {
     return name + "(" + unitCost + ")";
    }
   }
} 

public class Taxed extends Product
{
   private static double tax;
   
   public Taxed(String name, double cost)
   {
    super(name,cost);
   }
   
   public static void setSalesTaxRate(double salesTaxRate)
   {
    tax = salesTaxRate;
   }
   
   @Override
   public void placeOrder(int quantity)
   {
    if (quantity > 0)
    {
     this.quantity = quantity;
    }
   }

   
   @Override
   public double price()
   {
    return (quantity * unitCost) * (1+tax);
   }
}

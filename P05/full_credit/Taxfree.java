public class Taxfree extends Product
{
  public Taxfree(String name, double cost)
  {
   super(name,cost);
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
   return quantity * unitCost;
  }
}

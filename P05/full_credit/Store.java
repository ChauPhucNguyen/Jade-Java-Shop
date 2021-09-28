import java.util.Scanner;
import java.util.ArrayList;

public class Store
{
   public void cli()
   {
    Scanner input = new Scanner(System.in);
    int quantity;
    int productNumber;
    double total = 0;
    Taxed.setSalesTaxRate(0.0625);
    String multiLine[];
    Taxfree Cheetos = new Taxfree("Flaming Hot Cheetos", 2.5);
    Taxfree Lays = new Taxfree("Barbecue Flavored Lays", 1.78);
    Taxed Tostitos = new Taxed("Original Tostitos", 2.98);
    Taxed Fritos = new Taxed("Fritos Original Corn Chips", 3.28);
    ArrayList <Object> arrayList = new ArrayList<Object>();

    while(true)
    {
     System.out.println("=======================");
     System.out.println(" Welcome to the Store!");
     System.out.println("=======================");
     System.out.println("\n");
     System.out.println("1 Flaming Hot Cheetos ($2.50)");
     System.out.println("2) Barbecue Flavored Lays ($1.78)");
     System.out.println("3) Original Tostitos ($2.98)");
     System.out.println("4) Fritos Original Corn Chips ($3.28)");
     System.out.println("\n");
     System.out.println("Current order:");
     
     if(arrayList.size() != 0)
     {
     for (int i = 0; i < arrayList.size(); i++)
     {
      System.out.println(arrayList.get(i));
     }
     }
     
     System.out.println("\n");
     System.out.printf("Total due today: $%.2f", total);
     System.out.println("\n\n");
     System.out.println("Enter in quantity (0 to complete order) and product #:");
     multiLine = input.nextLine().split(" ");
     quantity = Integer.parseInt(multiLine[0]);
     productNumber = Integer.parseInt(multiLine[1]);
     
     if(quantity < 0 || (productNumber > 4 || productNumber < 0))
     {
      try
      {
       multiLine = input.nextLine().split(" ");
       quantity = Integer.parseInt(multiLine[0]);
       productNumber = Integer.parseInt(multiLine[1]);
       if(quantity < 0)
       {
        throw new IllegalArgumentException("quantity is a negative number");
       }
       if(productNumber < 0 || productNumber > 4)
       {
        throw new IllegalArgumentException("product number is out of range");
       }
      }
      catch(IllegalArgumentException e)
       {
       System.out.println("Invalid input, please try again:");
       }
      }  
   
   if(quantity == 0)
     {
      System.out.printf("Your total is $%.2f\n", total);
      System.out.println("Thank you for your order!");
      System.exit(0);
     }
   
   switch(productNumber)
   {
    case 1:
     Cheetos.placeOrder(quantity);
     total += Cheetos.price();
     arrayList.add(Cheetos);
     break;
    case 2:
     Lays.placeOrder(quantity);
     total += Lays.price();
     arrayList.add(Lays);
     break;
    case 3:
     Tostitos.placeOrder(quantity);
     total += Tostitos.price();
     arrayList.add(Tostitos);
     break;
    case 4:
     Fritos.placeOrder(quantity);
     total += Fritos.price();
     arrayList.add(Fritos);
     break;
   }
  }
   
 }
 public static void main(String[] args)
   {
    Store store = new Store();
    store.cli();
   }
}

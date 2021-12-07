package store;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Store
{
 private String storeName;
 private ArrayList<Product> products;
 private ArrayList<Person> people;
 private ArrayList<Order> orders;
 
 public Store(String storeName)
 {
  this.storeName = storeName;
  this.products = new ArrayList<>();
  this.people = new ArrayList<>();
  this.orders = new ArrayList<>();
 }
 
 public Store(BufferedReader in) throws IOException
 {
  this(in.readLine());
  int size = Integer.parseInt(in.readLine());
  for(int i=0; i<size; ++i) 
  products.add(readProduct(in));
  size = Integer.parseInt(in.readLine());
  for(int i=0; i<size; ++i)
  people.add(readPerson(in));
  size = Integer.parseInt(in.readLine());
  for(int i=0; i<size; ++i) 
  orders.add(new Order(in));        
 }
  
 public void save(BufferedWriter out) throws IOException
 {
  out.write(storeName + '\n');
  out.write("" + products.size() + '\n');
  for(Product p : products)
  p.save(out);
  out.write("" + people.size() + '\n');
  for(Person p : people)
  p.save(out);
  out.write("" + orders.size() + '\n');
  for(Order o : orders)
  o.save(out);
 }

 String name()
 {
   return storeName;
 }

 public void addProduct(Product product)
 {
  products.add(product);
 }
    
 public int numberOfProducts()
 {
  return products.size();
 }
 
 public String toString(int index)
 {
  return products.get(index).toString();
 }
   
 public Object[] getProducts()
 {
  return products.toArray();
 }

 public void addOrder(Order order)
 {
  if (order.numberOfProducts() < 1)
  throw new IllegalArgumentException("No products in Order #" + order.getID());
  orders.add(order);
 }
  
 public Object[] getOrders()
 {
  return orders.toArray();
 }

public void addPerson(Person person)
{
 people.add(person);
}
  
public Object[] getPeople()
{
 return people.toArray();
}

@Override
public String toString()
{
 String result = "Welcome to " + storeName + "\n\nToday's Menu\n\n";
 for(int i=0; i<products.size(); ++i)
 {
 result += i + ") " + products.get(i) + "\n";
 }
 return result;
}
  
    public String peopleToString()
    {
     String result = "Welcome to " + storeName + "\n\nPeople We Love ♥\n\n";
     for(int i=0; i<people.size(); ++i)
     {
      result += i + ") " + people.get(i) + "\n";
     }
     return result;
    }
  
    public String ordersToString()
    {
     String result = "Welcome to " + storeName + "\n\nCurrent Orders\n\n";
     for(int i=0; i<orders.size(); ++i)
     {
      result += orders.get(i) + "\n";
     }
     return result;
    }
    
    static Product readProduct(BufferedReader in) throws IOException {
        String productType = in.readLine();
        switch(productType) {
            case Java.ID:  return new Java(in);
            case Donut.ID: return new Donut(in);
            default: throw new IOException("Invalid product type: " + productType);
        }
    }

    static Person readPerson(BufferedReader in) throws IOException
    {       
     String personType = in.readLine();
     switch(personType)
     {
      case Customer.ID:  return new Customer(in);
      case Server.ID:    return new Server(in);
      default: throw new IOException("Invalid person type: " + personType);
     }
    }
}

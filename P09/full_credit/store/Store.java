import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.*;
package store;

public class Store
{
 protected String storeName;
 protected ArrayList<Product> products;
 
 public Store(String storeName)
 {
  this.storeName = storeName;
  this.products = new ArrayList<>();
  this.people = new ArrayList<>();
 }
 
 public String storeName()
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
 
 public void addPerson(Person person)
 { 
  people.add(person);
 }
    
 public int numberOfPeople()
 {
  return people.size();
 }
 
 public void save(BufferedWriter bw) throws IOException
 {
        bw.write(storeName + '\n');
        bw.write("" + products.size() + '\n');
        for(Product o: products)
        {
         o.save(bw);
        }
        bw.write("" + people.size() + '\n');
        for(Person i: people)
        {
         i.save(bw);
        }
 }
 
 public Store(BufferedReader br) throws IOException
 {
        this(br.readLine());
        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++)
        {
         String productType = br.readLine();
         switch(productType)
         {
          case Java.ID: products.add(new Java(br));
          break;
          case Donut.ID: products.add(new Donut(br));
          break;
          default: throw new IOException("Invalid product type: " + productType);
         }
        }
        
        int peopleSize = Integer.parseInt(br.readLine());
        
        for (int j = 0; j < peopleSize; j++)
        {
            String peopleType = br.readLine();
            switch(peopleType)
            {
            case Customer.ID: people.add(new Customer(br));
            break; 
            default: throw new IOException("Invalid customer type: " + peopleType);
            } 
        }
  }
  
 public String peopleToString(int productIndex)
 {
  String result = "";
  resultIndex = people.get(productIndex).toString();
  return resultIndex;
 }
  
 public String peopleToString()
 {
  String result = "";
  String separator = "";
  for(Person i : people) {
  resultPeople += separator + i;
  separator = "\n";
 }
  return resultPeople;
 }
 
 public String toString(int index)
 {
  String result = "";
  result = products.get(index).toString();
  return result;
 }
 
 @Override
 public String toString()
 {
  String result = "";
  String separator = "";
  for(Product i : products) {
  result += separator + i;
  separator = "\n";
 }
  return result;
 }
}

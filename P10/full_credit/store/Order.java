package store;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.*;

public class Order
{
  private static int id = 0;
  private Customer customer;
  private Server server;
  private HashMap<Product> products;
  server = new Server(serverName, serverPhone, serverSSN);
  
  public Order(Customer customer, Server server)
  {
   this.customer = customer;
   this.server = server;
   this.products = new HashMap<>();
   id++;
  }
    
  public Order(BufferedReader in)
  {
  String name = in.readLine();
  String phone = in.readLine();
  String serverName = in.readLine();
  String serverPhone = in.readLine();
  String serverSSN = in.readLine();
  }
    
  public void save(BufferedWriter out)
  {
   customer.save(out);
   server.save(out);
  }
    
  public int getID()
  {
   return id;
  }
    
  public void addProduct(int quality, Product product)
  {
   products.put(product, quality);
  }
    
  @Override
  public String toString(){
  return "Order # " + id + "for " + customer.toString() + "Server: " + server.toString();
  }

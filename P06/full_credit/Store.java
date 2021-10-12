import java.util.ArrayList;
public class Store
{
 protected String storeName;
 protected ArrayList<Product> products;
 
 public Store(String storeName)
 {
  this.storeName = storeName;
  this.products = new ArrayList<>();
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

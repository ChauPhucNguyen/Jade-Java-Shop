import java.util.ArrayList;
public class Java extends Product
{
 public enum Shot {none,chocolate,vanilla,peppermint,hazelnut}
 public enum Darkness {blonde,light,medium,dark,extreme}
 
 protected Darkness darkness;
 protected ArrayList<Shot> shots;
 
 public Java(String name, double price, double cost, Darkness darkness)
 {
  super(name,price,cost);
  this.darkness = darkness;
  this.shots = new ArrayList<>();
 }
 
 public void addShot(Shot shot)
 {
   shots.add(shot);
 }
 
 @Override
 public String toString()
 {
  String result = "";
  String separator = "";
  for(Shot i : shots) {
  result += separator + i;
  separator = ", ";
 }
  return name + "(" + darkness + " with " + result + ") $" + price;
 }
}

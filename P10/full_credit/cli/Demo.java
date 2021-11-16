public class Demo
{
 public static void main(String[] args)
 {
  Store jadeExpress = new Store("Demo Store");
  Donut Plain = new Donut("Plain Donuts", 9.99, 4.00, Donut.Frosting.unfrosted, false, Donut.Filling.unfilled);
  Donut Chocolate = new Donut("Chocolate Donuts with creme filling", 12.99, 6.00, Donut.Frosting.chocolate, false, Donut.Filling.creme);
  Donut Party = new Donut("Party Donuts with vanilla frosting, sprinkles and creme filling", 15.99, 8.00, Donut.Frosting.vanilla, true, Donut.Filling.creme);
  Donut Strawberry = new Donut("Strawberry donuts with vanilla frosting and strawberry filling", 12.99, 6.00, Donut.Frosting.vanilla, false, Donut.Filling.strawberry);
  Java Vanilla = new Java("Vanille Latte", 4.15, 2.00, Java.Darkness.light);
  Vanilla.addShot(Java.Shot.none);
  Java Peppermint = new Java("Peppermint Mocha Latte", 4.65, 2.00, Java.Darkness.light);
  Peppermint.addShot(Java.Shot.peppermint);
  Java Mocha = new Java("Mocha Latte", 4.15, 2.00, Java.Darkness.dark);
  Mocha.addShot(Java.Shot.chocolate);
  Java Hazel = new Java("Hazelnut Latte", 4.65, 2.00, Java.Darkness.medium);
  Hazel.addShot(Java.Shot.hazelnut);
  jadeExpress.addProduct(Plain);
  jadeExpress.addProduct(Chocolate);
  jadeExpress.addProduct(Party);
  jadeExpress.addProduct(Strawberry);
  jadeExpress.addProduct(Vanilla);
  jadeExpress.addProduct(Peppermint);
  jadeExpress.addProduct(Mocha);
  jadeExpress.addProduct(Hazel);
  System.out.print(jadeExpress);
  }
}

import java.util.Scanner;
public class Hello
{
   public static void main(String[] args) {
     Scanner testing = new Scanner(System.in);
     System.out.println("Please enter your name:\n");
     String name = testing.nextLine();
     System.out.println("Hello " + name + "!");
     }
}

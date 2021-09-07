import java.util.Arrays;
import java.lang.Math;
import java.text.DecimalFormat;

public class Roll{
   public static void main(String[] args)
   {
   if(args.length == 0)
   {
        System.out.println("usage: java Roll [#dice] [#sides]");
        System.exit(0);
    }
   else
    {
     int numberOfDices = Integer.parseInt(args[0]);
     int numberOfSides = Integer.parseInt(args[1]);
     Die Sides = new Die(numberOfSides);
     int sum = 0;
     float sum1;
     float average;
     int counter = 0;
     String noDecimal = "######";
     int array[] = new int[numberOfDices]; 
     for (int i = 0; i < numberOfDices; i++)
     {
         array[i]= Sides.roll();
     }
     Arrays.sort(array);
     while(counter != numberOfDices)
     {
      System.out.print(array[counter] + " ");
      counter++;
     }
     
     for( int num : array)
     {
          sum = sum + num;
     }
     sum1 = (float)sum;
     average = sum1/numberOfDices;
      DecimalFormat formatted = new DecimalFormat(noDecimal);
      System.out.printf("\nSum = %s", formatted.format(sum1));
      System.out.printf("\nAverage = %.2f", average);
    }
   }
}

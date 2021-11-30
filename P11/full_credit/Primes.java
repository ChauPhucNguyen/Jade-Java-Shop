import java.util.ArrayList;
import java.text.NumberFormat;

public class Primes
{
 private int numThreads;
 private ArrayList<Integer> primes;

 
 public Primes(int numThreads)
 {
  this.numThreads = numThreads;
 }
 
 public Primes findPrimes(int lower, int upper)
 {

  for (int imposter = lower; imposter <= upper; imposter++)
  {
   if(isPrime(imposter) == true)
   {
    primes.add(imposter);
   }
  }
  return new Primes(numThreads);
 }
 
 protected boolean isPrime(int number)
 {
  for (int i = 2; i <= Math.sqrt(number); i++)
  {
   if (number % i == 0)
   {
   return false;
   }
  }
  return true;
 }
 
 public int numberOfPrimes()
 {
  return primes.size();
  
 }
 
 public Integer[] toArray()
 {
  return primes.toArray(new Integer[0]);
 }
 
 public static void main(String[] args)
 {
   int numThreads = 1;
   int lower = 0;
   int upper = 10000000; 
   if(args.length > 0) numThreads = Integer.parseInt(args[0]);
   if(args.length > 1) lower = Integer.parseInt(args[1]);
   if(args.length > 2) upper = Integer.parseInt(args[2]);
   if(args.length > 3)
   {
   System.err.println("usage: java Primes [lower upper]");
   System.exit(-args.length);
   }
    Primes primes = new Primes(numThreads);
    int sumOfPrimes = 0;
    for(int prime : primes.findPrimes(lower, upper).toArray())
    sumOfPrimes += prime;
    System.out.println("Sum of the " + primes.numberOfPrimes() + " primes between " + lower + " and " + upper + " is " + NumberFormat.getIntegerInstance().format(sumOfPrimes));
  }
 
 }

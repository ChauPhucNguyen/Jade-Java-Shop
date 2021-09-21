import java.util.Scanner;
import java.lang.Character;

public class Puzzle
{
 private String solution;
 private boolean[] guesses = new boolean[10];
 
 public Puzzle(String solution)
 {
  this.solution = solution;
 }
 
 public boolean guess(char c)
 {
  boolean guess = false;
  c = Character.toUpperCase(c);
  solution = solution.toUpperCase();
  
  for (int i = 0; i < solution.length(); i++)
  {
   if ( c ==  solution.charAt(i))
   {
    guesses[i] = true;
    guess = true;
   }
  }
  return guess;
 }
 
 public boolean solve(String proposedSolution) 
 {
  if(proposedSolution.equals(solution))
  {
   return true;
  }
  else
  {
   return false;
  }
 }
 

 public String getSolution()
 {
  return solution;
 }
 
 @Override
 public String toString()
 {
  char solutionArray[] = solution.toCharArray();
  for (int j = 0; j < solution.length(); j++)
  {
   if (guesses[j] == false)
   { 
    solutionArray[j] = '_';
   }
  }
 return new String(solutionArray);
 }
 }

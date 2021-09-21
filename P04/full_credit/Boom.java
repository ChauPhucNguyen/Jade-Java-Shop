import java.lang.Character;
import java.util.Scanner;
import java.util.Arrays;

public class Boom{
    public void cli(){
    Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Boom! game.");
        System.out.println("guess all the letters in the word before time runs out; you will have 10 tries to guess the word.");
        int time = 10;
        Fuse fuse = new Fuse(time);
		System.out.println("Player 1, please enter in a word.");
		String solution = input.nextLine();
		Puzzle puzzle = new Puzzle(solution);
		boolean operating = true;
		while (solution.contains(" "))
		{
		  System.out.println("Player 1, please enter a valid prompt (one word)");
		  solution = input.nextLine();
		}
		while (operating)
		{
		System.out.println("your word is " + puzzle);
		System.out.println("Player 2, please enter in a letter you want to guess!");
		char c = input.nextLine().charAt(0);
		if (puzzle.guess(c) == true)
		{
		 System.out.println("you guessed correctly!");
		 if(puzzle.toString().contains("_") == false)
		 {
		  System.out.println("you guessed the word " + solution + " correctly!");
		  System.exit(0);
		 }
		 fuse.burn();
		}
		else
		{
		 System.out.println("You guessed incorrectly! Please try again!");
		 fuse.burn();
		}
		if (fuse.burn() == false)
		{
		 System.out.println(fuse);
		 break;
		}
		}
	}
	public static void main(String[] args)
	{
	 Boom boom = new Boom();
        boom.cli();
}
}
    

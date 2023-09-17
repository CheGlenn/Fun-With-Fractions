import java.io.PrintWriter;
import java.util.Scanner;

/**

 * InteractiveCalculator takes in arguments line by line in the terminal to calculate BigFraction values, following the form
 * BigFraction (operation) BigFraction
 * STORE a
 * a (operation) BigFraction
 *
 *  Samuel A. Rebelsky.
 * @author Che
 * @version Sep 2023 Mini Proj 2: Fun With Fractions
 */


public class InteractiveCalculator {
  public static void main(String args[]){
    PrintWriter pen = new PrintWriter(System.out, true);

    BFCalculator calc = new BFCalculator();

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    //scanner from StackOverflow https://stackoverflow.com/questions/59636888/correct-way-to-continuously-read-messages-from-the-console-and-do-other-things

    while (! input.equals("QUIT")){ //checks if input is QUIT, exits terminal if so
  
      if (input.substring(0,5).equals("STORE")){  //checks if input is STORE and calls store in BFCalc
        calc.store((input.substring(6,7)).charAt(0));
        input = scanner.nextLine();
      } //if
      else{ //calls evaluate with input
      pen.println(calc.evaluate(input));
      input = scanner.nextLine();
      } //else
    } //while
    scanner.close();
  }

  
}

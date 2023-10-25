import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {
  public static void main(String args[]){
    PrintWriter pen = new PrintWriter(System.out, true);

    BFCalculator calc = new BFCalculator();

    Scanner scanner = new Scanner(System.in); 
    String input = scanner.nextLine();
    //scanner from StackOverflow https://stackoverflow.com/questions/59636888/correct-way-to-continuously-read-messages-from-the-console-and-do-other-things

    while (! input.equals("QUIT")){ //checks if input is quit
  
      if(input.length() > 1){ //check if input is single number,char,fraction
        if (input.substring(0,5).equals("STORE")){ //checks input for STORE as first word
          calc.store((input.substring(6,7)).charAt(0)); //runs store with letter user put after store
          input = scanner.nextLine();
        } //if
        else{
        pen.println(calc.evaluate(input)); //if user did not use STORE, runs evaluate with user input
        input = scanner.nextLine();
        } //else
      } //if 
      else{
        pen.println(input);
        break;
      }
    } //while
    scanner.close();
  }

  
}

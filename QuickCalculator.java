import java.io.PrintWriter;

/**

 * QuickCalculator takes in arguments from the commandline to calculate BigFraction values following the form
 * "BigFraction (operation) BigFraction" "STORE char" "char (operation) BigFraction" 
 *
 *  Samuel A. Rebelsky.
 * @author Che
 * @version Sep 2023 Mini Proj 2: Fun With Fractions
 */


public class QuickCalculator{
  public static void main(String args[]){
    PrintWriter pen = new PrintWriter(System.out,true);

    BFCalculator calc = new BFCalculator();

    for(int i = 0; i < args.length; i++){ //loop through args
      String temp = args[i]; //temp value to store arg at index i

      if(temp.substring(0,5).equals("STORE")){ //check if STORE command
        pen.println(args[i]);
        calc.store((temp.substring(6,7)).charAt(0)); //run store
      }
      else{
        BigFraction result = calc.evaluate(temp); //run evaluate
        pen.println(args[i]);
        pen.println(result.simplify());
      }
      
    }
  }
}
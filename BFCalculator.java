import java.io.PrintWriter;

/**

 * BFCalculator class contains the methods evaluate and store. Evaluate takes in a String that follows the form
 * BigFraction (operator) BigFraction, and calculates the new BigFraction that results from that operations
 * Store takes in a Character, and stores the most recently calculated value into an index based on that character
 *
 *  Samuel A. Rebelsky.
 * @author Che
 * @version Sep 2023 Mini Proj 2: Fun With Fractions
 */


public class BFCalculator{

  BigFraction storedResult; //var for storing result
  BigFraction[] registry = new BigFraction[26]; //var for storing registry
  PrintWriter pen = new PrintWriter(System.out,true);

  /*
   * evaluate takes in a string and evaluates based on BigFraction value and operator
   * pre-conditions: String exp
   * post-conditions: BigFraction storedResult
   */
  public BigFraction evaluate(String exp){
    int base = 97; //var for converting from char to alphabetical value (0-25)
    BigFraction f1; 
    BigFraction f2;

    String[] input = exp.split(" "); //split string by spaces into an array

    for(int i = 0; i < input.length; i++){ //lopp through array to check for any characters
      String temp = input[i];
      if ((temp.codePointAt(0) > 96) && (temp.codePointAt(0) < 123)) { //kevin pointed me to the codePointAt function, and explained how it works
          input[i] = registry[(temp.codePointAt(0)) - base].toString();  //set letter input to corresponding registry 

      } //if
    } //for

    f1 = new BigFraction(input[0]);
    for(int i = 1; i < (input.length-1); i+=2){ //loop through input array
    f2 = new BigFraction(input[i+1]);
      //does operation based on inputted expression
      if (input[i].equals("+")){
        storedResult = f1.add(f2).simplify();  //stores whatever value in storedResult for use in store func
      } //if
      else if (input[i].equals("-")){
        storedResult = f1.sub(f2).simplify();  //stores whatever value in storedResult for use in store func
      } // el if
      else if (input[i].equals("*")){
        storedResult = f1.multiply(f2).simplify();  //stores whatever value in storedResult for use in store func
      }// el if
      else if (input[i].equals("/")){
        storedResult = f1.divide(f2).simplify(); //stores whatever value in storedResult for use in store func
      }// elf if

      f1 = this.storedResult.simplify();
    } //for

    return this.storedResult; //returns result

  }
  /*
   * This function stores the last calculated value
   * pre-conditions: Character val
   * post-conditions: BigFraction at index 
   */
  public BigFraction store(char val){ 
    int base = 97;
    int index = ((int) val - base); //uses same method from CaeserCipher.java 
    registry[index] = this.storedResult;
    return registry[index];
  }
}
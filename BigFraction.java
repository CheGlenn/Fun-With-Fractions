import java.math.BigInteger;



/**

 * BigFraction class uses BigInteger to create fractions
 *
 *  Samuel A. Rebelsky.
 * @author Che
 * @version Sep 2023 Mini Proj 2: Fun With Fractions
 */

public class BigFraction {
  
  BigInteger num;

  BigInteger denom;

  //CONSTRUCTORS

  public BigFraction(BigInteger num){
    this.num = num;
    this.denom = BigInteger.valueOf(1);
  }

  /**
   * Build a new BigFraction from BigIntegers
   *
   * Made by Sam R in Fraction.java
   */
  public BigFraction(BigInteger num, BigInteger denom){
    this.num = num;
    this.denom = denom;
  }
  /**
   * Build a new BigFraction from integers
   *
   * Made by Sam R in Fraction.java
   */
  public BigFraction(int num, int denom){
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  }

   /**
   * Build a new fraction by parsing a string.
   *
   * Made by Sam R in Fraction.java
   */
  public BigFraction(String str){
    String sep[] = str.split("/");
    this.num = BigInteger.valueOf(Integer.parseInt(sep[0]));
    this.denom = BigInteger.valueOf(Integer.parseInt(sep[1]));

  }

  //METHODS

  /**
   * Add the fraction `addMe` to this fraction.
   * From Sam R. Fraction.java
   */
  public BigFraction add(BigFraction addMe){
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new BigFraction(resultNumerator, resultDenominator);
  }

  /*
   * subtract big fraction 'subMe' from this BigFraction
   */
  public BigFraction sub(BigFraction subMe){
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = (this.num.multiply(subMe.denom)).subtract((this.denom.multiply(subMe.num)));
    resultDenominator = this.denom.multiply(subMe.denom);

    return new BigFraction(resultNumerator, resultDenominator);

  }
  /*
   * From Fraction.java lab
   * multiplies big fractions
   */
  public BigFraction multiply(BigFraction multiplyMe){
    BigInteger resultNum = this.num.multiply(multiplyMe.num); //set result numerator to multiplied numerators

    BigInteger resultDenom = this.denom.multiply(multiplyMe.denom); //set result denominator to multiplied denominators

    return new BigFraction (resultNum, resultDenom); //return new fraction with result numerator and result denominator
  } //multiply()

  /*
   * divides big fractions
   * takes in BigFraction
   */
  public BigFraction divide(BigFraction divideMe){
    BigInteger resultNum = this.num.multiply(divideMe.denom); //set result numerator to multiplied numerator and denom
    BigInteger resultDenom = this.denom.multiply(divideMe.denom); //set result denominator to multiplied denom and numerator

    return new BigFraction (resultNum, resultDenom); //returns new BigFraction from resultNum and resultDenom
  }

    /**
     * Simplify fraction using BigInteger gcd
     * @param fraction
     * @return simplified fraction
     */
  public BigFraction simplify(){
    BigInteger greatestCommonFactor = this.num.gcd(this.denom); //finds and stores greatest common denominator

    this.num = this.num.divide(greatestCommonFactor);
    this.denom = this.denom.divide(greatestCommonFactor);

    BigFraction simplified = new BigFraction(this.num, this.denom); //creates simplified fraction from new num and denom

    return simplified;
  } //simplify

    /**
   * Convert this fraction to a string for ease of printing. 
   * Taken from Sam R. Fraction.java
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    //Special case: denom is 1
    if (this.denom.equals(BigInteger.ONE)){
      return String.valueOf(this.num);
    } //if its 1

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  }// toString()
}


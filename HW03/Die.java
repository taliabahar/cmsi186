/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-06
 *  Author        :  Talia Bahar
 *  Date          :  2018-02-15
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-02-17  B.J. Johnson  Filled in method code
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   private int sides;
   private int pips;
   private final int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param nSides int value containing the number of sides to build on THIS Die
   * @throws       IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die ( int nSides ) throws IllegalArgumentException {
     if(nSides < 4){throw new IllegalArgumentException();}
     sides = nSides;
   }

  /**
   * Roll THIS die and return the result
   * @return  integer value of the result of the roll, randomly selected
   */
   public int roll() {
      pips = (int)(Math.random() * this.sides) + 1;
      return pips;
   }

  /**
   * Get the value of THIS die to return to the caller; note that the way
   * the count is determined is left as a design decision to the programmer
   * For example, what about a four-sided die - which face is considered its
   * "value"?
   * @return the pip count of THIS die instance
   */
   public int getValue() {
      return this.pips;
   }

  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public int setSides( int sides ) throws IllegalArgumentException {
     if(sides < 4){throw new IllegalArgumentException();}
     this.sides = sides;
     return sides;
   }

  /**
   * Public Instance method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public String toString() {
      return "[" + Integer.toString(this.pips) + "]";
   }

  /**
   * Class-wide method that returns a String representation of THIS die instance
   * @return String representation of this Die
   */
   public static String toString( Die d ) {
     return d.toString();
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
     Die d = null;
     try {d = new Die(1);}
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {d = new Die(2);}
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {d = new Die(3);}
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {d = new Die(4);}
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
       System.out.println("roll() test for a 4 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     try {
       d = new Die(5);
       System.out.println("roll() test for a 5 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {
       d = new Die(6);
       System.out.println("roll() test for a 6 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {
       d = new Die(7);
       System.out.println("roll() test for a 7 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {
       d = new Die(8);
       System.out.println("roll() test for a 8 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {
       d = new Die(9);
       System.out.println("roll() test for a 9 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {
       d = new Die(10);
       System.out.println("roll() test for a 10 sided die");
       System.out.println("Resetting current die side count is " + d.setSides(10) );
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}
     try {
       d = new Die(11);
       System.out.println("Resetting current die side count is " + d.setSides(11) );
       System.out.println("roll() test for an 11 sided die");
       System.out.println("You rolled a " + d.roll() );
       System.out.println("You rolled a " + d.getValue() );
       System.out.println("You rolled a " + d.toString() );
       System.out.println("You REROLLED a " + d.roll() );
       System.out.println("You REROLLED a " + d.roll() );
     }
     catch (IllegalArgumentException iae) {System.out.println ("Too few sides requested to constructor...");}

      System.out.println( "Hello world from the Die class..." );
   }

}

/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  Program to ___________________
 * @author    :  Talia Bahar
 * Date       :  2018-04-24
 * Description:  This program provides ___________________
 *
 *
 * Notes      :  None
 * Warnings   :  None
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DynamicChangeMaker {

public static int rowCount;
public static int columnCount;
public static Tuple result;

public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int target) {
    int rowCount = denominations.length;
    int columnCount = target + 1;
    Tuple[][] theTable = new Tuple[rowCount][columnCount];
    Tuple denoms = new Tuple(denominations);

    for (int i=0; i < denominations.length; i++){
        if(denominations[i] < 1){
            throw new IllegalArgumentException("BAD DATA");
        }
    }

    for(int i = 0; i < rowCount; i++) {
        for(int j = 0; j < columnCount; j++) {
            if(j == 0) {
                theTable[i][j] = new Tuple(denoms.length());
            } else {
                if(denoms.getElement(i) > j) {
                    theTable[i][j] = Tuple.IMPOSSIBLE;
                    if(j >= denoms.getElement(i)) {
                        if((theTable[i][j-denoms.getElement(i)]).isImpossible()) {
                            theTable[i][j] = Tuple.IMPOSSIBLE;
                        } else {
                            theTable[i][j].setElement(i, 1);
                        }
                    }
                    if(i != 0) {
                    if((theTable[i-1][j]).isImpossible()) {
                        theTable[i][j] = Tuple.IMPOSSIBLE;
                    } else if(theTable[i-1][j].total() < theTable[i][j].total()) {
                        theTable[i][j] = theTable[i-1][j];
                    }
                }
            } else {
                theTable[i][j] = new Tuple(denoms.length());
                theTable[i][j].setElement(i, 1);
                if((j - denominations[i]) >= 0) {
                    if((theTable[i][j-denoms.getElement(i)]).isImpossible()) {
                        theTable[i][j] = Tuple.IMPOSSIBLE;
                    } else {
                        theTable[i][j] = theTable[i][j-denoms.getElement(i)];
                    }
                }
                if(i != 0) {
                    if((theTable[i-1][j]).isImpossible()) {
                        theTable[i][j] = theTable[i][j];
                    } else if(theTable[i-1][j].total() < theTable[i][j].total()) {
                        theTable[i][j] = theTable[i-1][j];
                    }
                }
            }
        }
        result = theTable[i][j];
    }
    }
    System.out.println(result);
    return result;
    }
}

 // public String validate() {
 //   if(denominations)
 // }




// validate method
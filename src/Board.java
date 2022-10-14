public class Board {

    private Rule ruleSet = new Rule();
    Board() {

        boolean[][] planet = new boolean[Main.SIZE][Main.SIZE];

        // POPULATES FIRST ROW WITH SEED
        // boolean[] rowStart = randSeed();
        boolean[] rowStart = middleSeed();

        for(int i = 0; i < Main.SIZE; ++i) {
            planet[i][0] = rowStart[i];
        }


        /*
        // PRINTS RANDOMNESS TO EVERY ROW
        for (int i = 1; i < Main.SIZE; ++i) {
            boolean[] randRow = randSeed();
            for(int j = 0; j < Main.SIZE; ++j) {
                planet[j][i] = randRow[j];
            }
        }
        */

        // Sends Array Data to Method and populates array
        for(int i = 0; i < Main.SIZE-1; ++i) {
            for(int j = 0; j < Main.SIZE-1; ++j) {
                if (j == 0) {
                    planet[j][i+1] =  ruleCheck(false, planet[j][i], planet[j+1][i]);
                } else if (j == Main.SIZE) {
                    planet[j][i+1] =  ruleCheck(planet[j-1][i], planet[j][i], false);
                } else {
                    planet[j][i+1] =  ruleCheck(planet[j-1][i], planet[j][i], planet[j+1][i]);
                }
            } // inner for
        } // outer for

        // DRAWS TO THE SCREEN
        for (int i = 0; i < Main.SIZE; ++i) {
            for(int j = 0; j < Main.SIZE; ++j) {
                // wait(1);
                if (planet[j][i]) {
                    System.out.print(":::");
                } else {
                    System.out.print("XXX");
                }
            } // inner for
            System.out.println();
        } // outer for


    } // end constructor method

    // CHECKS THE INPUT ROW WITH THE RULE SET AND SPITS OUT AN ANSWER
    private boolean ruleCheck(boolean a, boolean b, boolean c) {
        boolean check = false;
        int[] upperCheck = {bool2Int(a), bool2Int(b), bool2Int(c)};

        /*
        for(int i = 0; i < 3; ++i) {
            System.out.print(upperCheck[i]);
        } System.out.print(" << ");
        */

        int[] lowerCheck = new int[4];
        for(int i = 0; i < 8; ++i) {
            lowerCheck = ruleSet.getVectorRow(i);
            if(upperCheck[0] == lowerCheck[0] &&
            upperCheck[1]==lowerCheck[1] &&
            upperCheck[2] == lowerCheck[2]) {
                check = int2Bool(lowerCheck[3]);
                break;
            }
        } // outer for
        // System.out.println(bool2Int(check));
        return check;

    } // ruleCheck

    // MAKES A RANDOM STARTING SEED
    private boolean[] randSeed() {
        boolean[] seedArray = new boolean[Main.SIZE];
        for (int i = 0; i < Main.SIZE; ++i) {
            seedArray[i] = randomToBool();
        }
        return seedArray;
    } // randSeed method

    // MAKES A SEED WITH ONE TRUE CELL IN THE MIDDLE
    private boolean[] middleSeed() {
        boolean[] seedArray = new boolean[Main.SIZE];
        for (int i = 0; i < Main.SIZE; ++i) {
            if(i == Main.SIZE / 2) {
                seedArray[i] = true;
            } else {
                seedArray[i] = false;
            }
        }
        return seedArray;
    } // middle seed method

    private boolean randomToBool() {
        float container;
        boolean value = false;
        container = (float)Math.random();
        if(container > .5) {
            value = true;
        }
        return value;

    } // random to boolean method

    public static void wait(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    } // wait method

    private int bool2Int(boolean in) {
        if (in == false) {
            return 0;
        } else {
            return 1;
        }
    } // bool to int

    private boolean int2Bool(int in) {
        if (in == 0) {
            return false;
        } else {
            return true;
        }
    } // int to bool

}

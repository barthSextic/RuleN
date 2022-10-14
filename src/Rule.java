public class Rule {

    private final int VECTOR_SIZE = 8;
    private int[] x0, x1, x2 = new int[VECTOR_SIZE];
    private int[] row = new int[4];

    //private int[] r = {0, 1, 0, 1, 1, 0, 1, 0}; // RULE 54
    //private int[] r = {0, 1, 1, 1, 1, 0, 0, 0}; // RULE 30
    private int[] r = {1, 0, 1, 1, 0, 0, 1, 0};
    Rule() {
        x0 = vectorBuilder(2);
        x1 = vectorBuilder(4);
        x2 = vectorBuilder(8);

        /*

        PRINTS THE VECTORS AND THE RULES IF NEEDED

        for(int i = 0; i < VECTOR_SIZE; ++i) {
            System.out.println(x0[i] +""+ x1[i] + x2[i] + r[i]);
        }

        */

    } // constructor method

    public int[] getVectorRow(int index) {
        row[0] = x0[index];
        row[1] = x1[index];
        row[2] = x2[index];
        row[3] = r[index];

        return row;
    }

    public int[][] getVectorX() {
        int[][] vectorArray = {x0, x1, x2};
        return vectorArray;

    } // get Vector method

    private int[] vectorBuilder(int n) {
        int[] array = new int[VECTOR_SIZE];
        int flip = n / 2;

        for (int i = 0; i < VECTOR_SIZE; ++i) {
            for(int j = 0; j < n; ++j) {
                if (i % n >= flip) {
                    array[i] = 1;
                } else {
                    array[i] = 0;
                } // if else
            } // inner for
        } // for loop

        return array;
    } // vector builder method



} // end class

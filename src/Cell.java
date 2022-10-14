public class Cell {

    private int state;

    Cell(boolean life) {

        if (life) {
            state = 1;
        } else {
            state = 0;
        }

    } // constructor

    private String key(boolean state) {
        String stateReturn = new String();
        if (state) {
            stateReturn = "X";
        } else {
            stateReturn = "=";
        }

        return stateReturn;

    }

    public int getState() {

        return state;

    }

}

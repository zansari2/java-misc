package rec;

/**
 * Simulates a screen of pixels that can have their values changed through a "fill" which given a location on the screen
 * can find all adjacent cells of same value and change all values to a new value
 */
public class Screen
{
    //Variables
    /**
     * Holds the screen state
     */
    int screen[][];
    //Constructors
    /**
     * Creates a Screen with certain values
     * @param s the screen
     */
    public Screen(int[][]s)
    {
        screen = s;
    }
    //Methods
    //Main
    public static void main(String[] args) 
    {
        int[][] x = new int[2][2];
        Screen s = new Screen(x);   
    }
}
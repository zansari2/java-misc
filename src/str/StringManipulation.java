package str;

/**
 * Manipulates strings in various ways
 */
public class StringManipulation
{
    //Variables
    /**
     * Holds the length of a string
     */
    private int length;
    /**
     * Holds the string to be manipulated
     */
    private String s;
    //Constructors
    public StringManipulation(String s, int i)
    {
        this.length = i;
        this.s = s;
    }
    //Methods
    /**
     * Reverses an array of words separated by .
     * @return the reversed array
     */
    private String reverseWordArray()
    {
        StringBuilder str = new StringBuilder(new String(""));
        //Traverse the string
        int v = 0;
        for(int n = length-1; n >= 0; n--)
        {
            if(s.charAt(n)!='.')
            {
                str.insert(v,s.charAt(n));
            }
            else
            {
                str.append('.');
                v=str.toString().length(); 
            }
        }
        return str.toString();
    }
    /**
     * Inverts a boolean
     * @param b the boolean being inverted
     * @return the inverted boolean
     */
    private boolean boolInvert(boolean b)
    {
        boolean ret;
        if(b == false)
        {
            ret = true;
        }
        else
        {
            ret = false;
        }
        return ret;
    }
    /**
     * Returns a string with all permuntations of a given string
     * @return the permutations
     */
    private String findPermutations()
    {

        return null;
    }
    //Main
    public static void main(String[] args) 
    {
        //Create and initialze a StringManipulation
        String s = "ABC";
        int length = s.length();
        StringManipulation sm = new StringManipulation(s,length);
        //Print the results of the method
        System.out.println
        (sm.findPermutations());
    }
}
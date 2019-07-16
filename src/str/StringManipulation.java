package str;
import java.util.*;
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
     * Inserts a character into a string
     * @param str the string being edited
     * @param c the character being added
     * @param j the position of insert
     * @return the new string
     */
    private String charinsert(String str,char c,int j){
	    String begin=str.substring(0,j);
	    String end=str.substring(j);
	    return begin+c+end;
    }
    /**
     * 
     * @param str the string being edited
     * @return a set of strings
     */
    private Set<String> pf (String str){
        //Creates a new set of strings that will be returned
        Set<String>perm=new HashSet<String>();
        //Handles null input
	    if(str==null){
	        return null;
        }
        //Handles empty input
	    if(str.length()==0){
	        perm.add("");
	        return perm;
        }
        //Sets the inital character to the beginning of the string
        char initial=str.charAt(0);
        //Sets the remaining string to the substring after the initial character
        String rem=str.substring(1);
        //Creates a new set recursively with the remaining string
        Set<String>words=pf(rem);
        //Once recursively obtained interate through the permutations
        for(String strnew:words)
        {
            for(int i=0;i<=strnew.length();i++)
            {
	            perm.add(charinsert(strnew,initial,i));
	        }
	    }
	    return perm;
	}
    /**
     * Prints a string with all permuntations of a given string
     */
    private void findPermutations()
    {   
        //Create a copy of the string to be edited
        String str=this.s;
        //Create a hashset of strings
        Set<String> s = new HashSet<String>();
        //Adds all permutations of the string to the set
		s.addAll(pf(str));
        int n = s.size();
        //Create an array of strings to hold the output
        String arr[] = new String[n];
        //Convert the set to an array and assign
        arr = s.toArray(arr);
        //Sort the array
        Arrays.sort(arr);
        //Print the results
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    /**
     * Recursively removes adjacent duplicates
     * @param c the current character being tested
     * @return the string
     */
    private String removeDuplicates(char c, int i)
    {
        String ret = "";
        if(length-1==i)
        {
            System.out.println(ret);
            return ret;
        }
        else
        {
            i++;
            removeDuplicates(s.charAt(i),i);
            ret = ret + s.charAt(i);
        }
        return ret;
    }
    //Main
    public static void main(String[] args) 
    {
        //Create and initialze a StringManipulation
        String s = "ABCDEFG";
        int length = s.length();
        StringManipulation sm = new StringManipulation(s,length);
        //Print the results of the method
        sm.removeDuplicates(s.charAt(0),0);
    }
}
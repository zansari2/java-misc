package arr;

/**
 * Takes an unsorted array of variable size and finds a continuous sub-array
 * that adds to a given value
 */
public class SubArray
{
    //Variables
    /**
     * The array of values
     */
    private int[] a;
    /**
     * The value to be found
     */
    private int value;
    //Constructor
    /**
     * Creates an object with an array and value
     */
    public SubArray(int[] a, int value)
    {
        this.a = a;
        this.value = value;
    }
    //Methods
    /**
     * @return the a
     */
    public int[] getA() 
    {
        return a;
    }
    /**
     * @return the value
     */
    public int getValue() 
    {
        return value;
    }
    /**
     * @param a the a to set
     */
    public void setA(int[] a) 
    {
        this.a = a;
    }
    /**
     * @param value the value to set
     */
    public void setValue(int value) 
    {
        this.value = value;
    }
    /**
     * Find first instance
     * @return the subarray containing the instance
     */
    private int[] singleFind()
    {
        int[] ret = new int[a.length];
        
        int seek = 0;
        int place = 0;

        //Iterate through the array looking for a matching amount to value
        while(seek!=value&&place<a.length)
        {
            //Update seeker value to match a running total
            //Update return array
            seek += a[place];
            ret[place]=a[place];
            //Reset seeker and return array if value has been passed
            if(seek>value)
            {
                seek=a[place];
                ret = new int[a.length];
                ret[place]=seek;
            }
            place++;
        }
        //Print -1 if no consecutive elements exist to make sought after value
        if(seek!=value)
        {
            ret = new int[a.length];
            ret[0]=-1;
        }
        return ret;
    }

    /**
     * Find multi instance
     * @return the multi subarray containing the instances
     */

    /**
     * Return number of instances
     * @return the number of instances
     */

    //Main
    public static void main(String[] args) 
    {
        int[] a = {6};
        int i = 5;

        SubArray s = new SubArray(a,i);

        int[] r = s.singleFind();

        for(int n = 0; n < r.length; n++)
        {
            if(r[n]!=0)
            {
                System.out.print(r[n]+" ");
            }
        }
        
        System.out.println();

    }
}
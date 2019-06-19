package arr;

import javax.lang.model.util.ElementScanner6;

/**
 * Manipulates arrays in various ways
 */
public class SubArray
{
    //Variables

    //Constructor
    /**
     * Creates an object
     */
    public SubArray()
    {
        
    }

    //Methods
    /**
     * Find first instance
     * @param a the array
     * @param value the value
     * @return the subarray containing the instance
     */
    private int[] singleFind(int[]a,int value)
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
     * Finds triplets within an array, where two elements add into a third element
     * @param a the array
     */
    private void triplets(int[]a)
    {
        int l,r,count = 0;
        //Create an array to hold possible values
        int[]b=new int[a.length];
        //Iterate through array finding all possible sums
        for(int i = 0; i < a.length; i++)
        {
            l = 0;
            r = a.length-1;
            while(l<r)
            {
                if(a[l]+a[r]==a[i])
                {
                    count++;
                    l++;
                }
                else if(a[l]+a[r]>a[i])
                {
                    r--;
                }
                else
                {
                    l++;
                }
            }
            if(count==0)
            {
                System.out.println(" -1 ");
            }
        }
        //Print values that match
    }

    //Main
    public static void main(String[] args) 
    {
        /*  Testing for singleFind()
        int[] a = {6};
        int i = 5;

        SubArray s = new SubArray();

        int[] r = s.singleFind(a,i);

        for(int n = 0; n < r.length; n++)
        {
            if(r[n]!=0)
            {
                System.out.print(r[n]+" ");
            }
        }
        
        System.out.println();
        */

    }
}
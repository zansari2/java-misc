package arr;

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
     * Find first instance of contiguous set of integers that add to form value
     * Note: Not accurate when array contains negatives
     * @param a the array
     * @param value the value
     * @return the subarray containing the instance
     */
    private void singleFind(int[]a,int value)
    {
        int[] ret = new int[a.length];
        
        int seek = 0;
        int place = 0;

        //Iterate through the array looking for a matching amount to value
        while(seek!=value&&place<a.length)
        {
            //Update seeker value to match a running total
            //Update return array
            if(a[place]>0)
            {
                seek += a[place];
                ret[place]=a[place];
            }
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
        for(int n = 0; n < ret.length; n++)
        {
            if(ret[n]!=0)
            {
                System.out.print(ret[n]+" ");
            }
        }
        System.out.println();
    }
    /**
     * Finds triplets within an array, where two elements add into a third element
     * @param a the array
     */
    private void triplets(int[]a)
    {
        //Sort the array using bubble sort
        int n = a.length; 
        for (int i = 0; i < n-1; i++) 
        {    
            for (int j = 0; j < n-i-1; j++) 
            {
               if (a[j] > a[j+1]) 
                { 
                    // swap a[j+1] and a[i] 
                    int temp = a[j]; 
                    a[j] = a[j+1]; 
                    a[j+1] = temp; 
                } 
            }
        }
        int l,r,count = 0;
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
                    System.out.println(a[l]+"+"+a[r]+"="+a[i]);
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
    /**
     * Finds the contiguous sub-array with the largest sum
     * @param a the array
     */
    private void kAlgorithm(int[] a)
    {
        //Sort the array
        int n = a.length; 
        for (int i = 0; i < n-1; i++) 
        {
            for (int j = 0; j < n-i-1; j++) 
            {
                if (a[j] > a[j+1]) 
                { 
                    // swap a[j+1] and a[i] 
                    int temp = a[j]; 
                    a[j] = a[j+1]; 
                    a[j+1] = temp; 
                } 
            }
        }
        //Default to highest value in case there are exclusively negative values
        int sum = a[n-1];
        //Iterate through array
        for(int i = 0; i < n-1; i++)
        {
            if(a[i]>0)
            {
                sum+=a[i];
            }
        }
        System.out.println(sum);
    }
    /**
     * Finds the missing number in an array of ordered values
     * @param a the array
     */
    private void findMissingNum(int[]a)
    {
        int n = a.length;
        int curr = 0;
        int ret = 0;
        for(int i = 0; i < n-1; i++)
        {

        }
    }
    //Main
    public static void main(String[] args) 
    {
        SubArray arr = new SubArray();
        int[] a = {-1,3,3,2}; 
        /*  Testing for singleFind()
        int i = 5;
        arr.singleFind(a,i);
        */
        int i = 5;
        arr.singleFind(a,i);
        /*  Testing for triplets
        arr.triplets(a);
        */

        /*  Testing for kAlgorithm
        arr.kAlgorithm(a);
        */

    }
}
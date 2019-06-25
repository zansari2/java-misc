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
    public SubArray(){}

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
        int ret = 0;
        for(int i = 0; i < n-1; i++)
        {
            if(a[i]+1!=a[i+1])
            {
                ret = a[i]+1;
            }
        }
        System.out.println(ret);
    }
    /**
     * Merge two arrays into a sorted array
     * @param a the first array
     * @param b the second array
     */
    private void mergeArray(int[]a,int[]b)
    {
        int[]c = new int[a.length+b.length];
        int s = 0;
        for(int i = 0; i < c.length; i++)
        {
            if(i<a.length)
            {
                c[i]=a[i];
            }
            else
            {
                c[i]=b[s];
                s++;
            }
        }
        sort(c);
        print(c);
    }
    /**
     * Sorts an array
     * @param a the array
     * @return the sorted array
     */
    private int[] sort(int[]a)
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
        return a;
    }
    /**
     * Prints an array
     * @param a the array
     */
    private void print(int[]a)
    {
        //Iterate through array
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    
    }
    /**
     * Rearranges an ordered array into an array with alternating max min values
     */
    private void minMax(int[]a)
    {
        int min;
        int max;
        int[] ret = new int[a.length];
        int l = 0;
        int r = a.length-1;
        int curr = 0;
        while(l<r)
        {
            ret[curr]=a[r];
            curr++;
            ret[curr]=a[l];
            curr++;
            l++;
            r--;
        }
        print(ret);
    }
    /**
     * Find pairs from a and b such that a[x]^b[x]>b[x]^a[x]
     * @param a the first array
     * @param b the second array
     */
    private void pairs(int[]a,int[]b)
    {
        int counter=0;
        for(int i =0; i < a.length;i++)
        {
            for(int n=0;n<b.length;n++)
            {
                if(Math.pow(a[i],b[n])>Math.pow(b[n], a[i]))
                {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
    /**
     * Counts the number of inversions required to sort an array
     * @param a the array
     */
    private void inversionCount(int[]a)
    {
        //Sort the array
        int counter = 0;
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
                    counter++;
                } 
            }
        }
        System.out.println(counter);
    }
    /**
     * Finds the position where equilibrium first occurs such that the sum of elements before equal to the sum of elements after it
     * @param a the array
     */
    private void equi(int[]a)
    {
        int position = -1;  //Default value set to -1 if equilibirum can't be reached
        int sum=0;          //Sum of the array values

        //Find the sum
        for(int i = 0; i < a.length; i++)
        {
            sum+=a[i];
        }

        //Find the point
        int i = 0;
        int equi = 0;       //Equilibrium value counter
        while(equi<sum/2)
        {
            equi+=a[i];
            i++;
        }

        //Check if equi matches the sum or if the point has been passed
        if(equi==sum/2.)
        {
            position = i-1;
        }

        System.out.println(position);
    }
    /**
     * Finds a variation of the equilibrium point where the algorithm checks for a point where all elements beyonnd and behind the current point's sum are equal
     * @param a the array
     */
    private void equi2(int[]a)
    {
        int lowSum = 0;
        int hiSum = 0;
        boolean check = false;
        //Cycle through the array
        for(int i =0; i<a.length;i++)
        {
            //Check below the point
            for(int h = i;h>=0;h--)
            {
                lowSum+=a[h];
            }
            lowSum-=a[i];
            //Check above the point
            for(int r = i+1;r<a.length;r++)
            {
                hiSum+=a[r];
            }
            //Check if sum's match
            if(hiSum==lowSum)
            {
                check=true; 
                System.out.println("Match at "+i);
            }
            //Reset sums
            lowSum=0;
            hiSum=0;
        }
        if(check==false)
        {
            System.out.println("No match found.");
        }
    }

    //Main
    public static void main(String[] args) 
    {
        SubArray arr = new SubArray();
        int[] a = {1,2,1,2,1};
        int[] b = {1,5};
        /*  Testing for singleFind()
        int i = 5;
        arr.singleFind(a,i);
        */
        /*  Testing for triplets
        arr.triplets(a);
        */
        /*  Testing for kAlgorithm
        arr.kAlgorithm(a);
        */
        /*  Testing for findMissingNum
        arr.findMissingNum(a);
        */
        /*  Testing for mergeArray
        arr.mergeArray(a, b);
        */
        /*  Testing for minMax
        arr.minMax(a);
        */
        /*  Testing for pairs
        arr.pairs(a, b);
        */
        /*  Testing for inversionCount
        arr.inversionCount(a);
        */
        /*  Testing for sort and print
        arr.print(arr.sort(a));
        */
        /* Testing for equilibrium
        arr.equi(a);
        */
        /* Testing for equilibrium 2
        arr.equi2(a);
        */

    }
}
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
    /**
     * Finds all leaders in a given array
     * Leaders are defined as elements whose value is greater than or equal to all following elements
     * @param a the array
     */
    private void findLeader(int[]a)
    {
        int sum = 0;
        //Iterate through each elements checking for leadership
        for(int i = 0; i < a.length; i++)
        {
            //Find total of all following values
            for(int l = i+1; l < a.length; l++)
            {
                sum+=a[l];
            }
            //Compare current value to value of all following elements
            if(sum<=a[i])
            {
                System.out.println("Leader: " + i);
            }
            //Reset sum
            sum = 0;
        }
    }
    /**
     * Finds the minimum number of platforms required for a railway station, such that no trains wait
     * Given arrival and departure times
     * @param arrivals the arrival times
     * @param departures the departure times
     */
    private void findTrainPlatforms(int[]arrivals,int[]departures)
    {
        int numArrivals = arrivals.length;
        int numDepartures = departures.length;
        int numPlatforms = 1;
        int ret = 1;

        //Check for mismatched array lengths
        if(numArrivals!=numDepartures)
        {
            System.out.println("Error. The number of arrivals isn't equal to the number of departures.");
        }
        else
        {
            //Cycle through arrivals
            for(int i = 1; i < numArrivals-1; i++)
            {
                for(int l = 0; l < i; l++)
                {
                    //Check if anny trains that arrived before the current arrivals, haven't departed yet
                    if(arrivals[i]<departures[l])
                    {
                        numPlatforms++;
                    }
                }
                //Updates the return if the current interval would exceed the maximum alloted platforms
                if(numPlatforms>ret)
                {
                    ret = numPlatforms;
                }
                //Resets the platforms to begin the test for the next interval
                numPlatforms = 1;
            }
        }
        //Print number of platforms to console
        System.out.println("Number of platforms"+ret);
    }
    /**
     * Reverses a subarray given a number of elements to be reversed
     * @param a the array 
     * @param k the number of elements
     */
    private void reverseSubArray(int[]a,int k)
    {
        int n = 0;
        int m = k-1;
        int temp;

        //Cycle through the subarray swapping elements
        while(n<m)
        {
            temp = a[n];
            a[n]=a[m];
            a[m]=temp;
            n++;
            m--;
        }
        print(a);
    }
    /**
     * Finds kth smallest element in a array with distinct elements
     * @param a the array
     * @param k the element
     */
    private void findKSmallElement(int[]a,int k)
    {
        sort(a);
        System.out.println(a[k-1]);
    }
    /**
     * Simulates a rain water volume measurement using an array
     * @param a the array
     */
    private void measureArrayVolume(int[]a)
    {
        int volume = 0;
        boolean start = false;
        int lWall = 0;
        int lWallIndex = 0;
        //Cycle through array
        for(int i = 0; i < a.length; i++)
        {
            //Check if the end of the array has been reached
            if(i == a.length-1)
            {
                //Check if the ending wall is lower the the starting wall
                start =false;
                if(a[i]<lWall)
                {
                    //Subtract extra values if necessary
                    volume -= (i-lWallIndex-1)*(lWall-a[i]);
                }
            }
            //Starts the counting process if requirements are met to begin adding
            else if(a[i]!=0&&start==false&&i!=a.length-1)
            {
                start = true;
                lWall = a[i];
                lWallIndex = i;
            }
            //Handles case of adding to the volume
            else if(start==true&&a[i]<lWall)
            {
                volume += lWall-a[i];
            }
            //Handles the case of adding should end and reset for the next cycle
            else if(start==true&&a[i]>lWall)
            {
                lWall=a[i];
                lWallIndex = i;
            }
        }
        System.out.println(volume);
    }
    /**
     * Checks for pythagorean triplets in an array where 3 elements satisfy a^2+b^2=c^2
     * @param a the array
     */
    private void findPythTriplets(int[]a)
    {
        int c;
        //Cycle through array
        for(int i = 0; i < a.length; i++)
        {
            //For each element in array cycle through array to look for possible matches
            for(int l = 0; l < a.length; l++)
            {
                //Remove elements that match themselves
                if(l!=i)
                {
                    c=(int)(Math.pow(a[i],2)+Math.pow(a[l],2));
                    //Cycle again to look for potential matches for the answer
                    for(int j = 0; j < a.length; j++)
                    {
                        if(c==(int)Math.pow(a[j],2))
                        {
                            System.out.println(a[i]+"^2 + "+a[l]+ "^2 = "+ a[j]);
                        }
                    }
                }
            }
        }
    }
    /**
     * Finds a subarray of k size with minimum distance between maximum and minimum value
     * @param a the array
     * @param k the size of the subarray
     */
    private void subArrayMaxMin(int[]a, int k)
    {
        int n = 0;
        int m = k;
        a = sort(a);
        int retN = a[n];
        int retM = a[m];
        print(a);
        int difference = a[m]-a[n];
        for( int i = 0; i < a.length-k;i++){
            if(a[m+i]-a[n+i]<difference)
            {
                retN = a[n+i];
                retM = a[m+i];
            }
        }
        System.out.println(retM+"-"+retN+"="+(retM-retN));
    }
    //Main
    public static void main(String[] args) 
    {
        //Testing values for each method
        //Note: current values may not be applicable for all methods
        SubArray arr = new SubArray();
        int[] a = {3,4,1,9,56,7,9,12};
        int[] b = {910,1200,1120,1130,1900,2000};
        int i = 5;

        arr.subArrayMaxMin(a, i);
    }
}
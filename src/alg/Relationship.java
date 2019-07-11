package alg;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.relation.Relation;
/**
 * Simulates a relationship between two sets
 */
public class Relationship
{
    /**
     * Size of sets
     */
    private int size;
    /**
     * Set 1
     */
    private String[] set1;
    /**
     * Set 2
     */
    private String[] set2;
    /**
     * Relationship between the two sets
     */
    private String[] relation;

    /**
     * Creates a basic relationship
     */
    public Relationship(String[] set1, String[] set2)
    {
        this.set1 = set1;
        this.set2 = set2;
        this.relation = null;   
        size = 0;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelation(String[] relation) {
        this.relation = relation;
    }
    /**
     * @param set1 the set1 to set
     */
    public void setSet1(String[] set1) {
        this.set1 = set1;
    }
    /**
     * @param set2 the set2 to set
     */
    public void setSet2(String[] set2) {
        this.set2 = set2;
    }
    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * @return the relation
     */
    public String[] getRelation() {
        return relation;
    }
    /**
     * @return the set1
     */
    public String[] getSet1() {
        return set1;
    }
    /**
     * @return the set2
     */
    public String[] getSet2() {
        return set2;
    }
    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Creates a relationship between the two sets
     */
    public void createRelationship()
    {
        for(int i = 0; i < size; i++)
        {
            
        }
    }

    public static void main(String[] args) 
    {
        Relationship r = Relationship.userInput();
    }
    /**
     * @return a user defined relationship object
     */
    private static Relationship userInput()
    {
        Scanner scan = new Scanner(System.in);
        String[] set1;
        String[] set2;
        int setSize = 0;
        System.out.print("Hello. This class is meant to simulate a relationship between two sets. To continue, hit enter...");    
        scan.nextLine();

        //Enter the size
        setSize = Relationship.inputSize(scan);
        
        set1 = new String[setSize];
        set2 = new String[setSize];
        
        //Enter the elements into the sets
        set1 = inputSet(setSize, "set 1",scan);
        set2 = inputSet(setSize, "set 2",scan);

        Relationship r1 = new Relationship(set1,set2);

        scan.close();
        System.out.println("\nProgram exiting...\n");
        return null;
    }
    /**
     * Creates and returns a string array from user input
     * @param size the size of array to return
     * @param set the set name
     * @param scan1 the scanner
     * @return the string array
     */
    private static String[] inputSet(int size, String set, Scanner scan1)
    {
        String[] set1 = new String[size];
        String confirm = "N";
        System.out.println();
        do
        {
            for(int i = 0; i < size; i ++)
            {
                System.out.print("Please enter element "+ (i+1) + " of "+set+": ");
                set1[i] = scan1.nextLine();
            }
            System.out.println("\nPlease confirm that your enteries were correct.");
            for(int i = 0; i < size; i ++)
            {
                if(i == size-1)
                {
                    System.out.print(set1[i]);
                }
                else
                {
                    System.out.print(set1[i] + "-");
                }
            }
            System.out.print("\nIs this correct? (Y/N) : ");
            confirm = scan1.nextLine();
        }
        while(!confirm.equalsIgnoreCase("Y"));
        return set1;
    }
    /**
     * @param scan the scanner
     * @return the input size
     */
    private static int inputSize(Scanner scan)
    {
        int setSize = 0;
        do
        {
            System.out.print("\nPlease enter the number of elements in both sets: ");
            try 
            {
                setSize = scan.nextInt();
                System.out.print("Size of " + setSize + " was entered. Is this correct? (Y/N) : ");
                scan.nextLine();
                confirm = scan.nextLine();
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("An illegal arguement was entered.");
                confirm = "N";
                scan.next();
            }    
        }
        while(!confirm.equalsIgnoreCase("Y"));
        return setSize;
    }
}
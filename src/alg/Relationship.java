package alg;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Simulates a relationship between two sets
 */
public class Relationship
{
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
     * Creates a relationship between the two sets
     */
    public void createRelationship()
    {

    }

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String[] set1;
        int setSize = 0;
        String confirm;
        System.out.print("Hello. This class is meant to simulate a relationship between two sets. To continue, hit enter...");    
        scan.nextLine();
        do
        {
            System.out.print("\nPlease enter the number of elements in both sets: ");
            try 
            {
                setSize = scan.nextInt();
                set1 = new String[setSize];
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
        
        scan.close();
        System.out.println("\nProgram exiting...\n");
    }
}
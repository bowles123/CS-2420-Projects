// This program demonstrates how a priority queue works.
// Brian Bowles, 11/17/14
package bowlproj10;

// Main class.

import java.util.Scanner;

public class BowlProj10 {

    /**
     * @param args the command line arguments
     */
    // Main method.
    public static void main(String[] args) {
        // Variables.
        PriorityQueue queue = new PriorityQueue();
        
        System.out.println ("Hello this program demonstrates the basic idea"
                + "behind a priority queue.");
            menu(queue);
    }
    
    // This method allows the user to choose from a selection of options.
    public static void menu (PriorityQueue pq) {
        // Variables.
        Scanner in = new Scanner (System.in);
        int response;
        final int QUIT = 4;
        float newValue;
        
        // Display menu while user doesn't want to quit.
        do {
            // Ask user what they'd like to do and get response.
            System.out.println ("Please select an option from the following list:");
            System.out.println ("1. Check to see if the priority queue is empty\n"
                    + "2. Insert\n" + "3. Retrieve\n" + "4. Quit");
            response = in.nextInt();

            // Switch on the response doing the corresponding operation.
            switch (response) {
                case 1:
                    // Check to see if priority queue is empty and report back to user.
                    if (pq.IsEmpty())
                        System.out.println ("The priority queue is empty.");
                    else
                        System.out.println ("The priority queue has available space.");
                    break;
                case 2:
                    // Insert the item into the priority queue.
                    System.out.println ("What is the item you would like to insert?");
                    newValue = in.nextFloat();
                    // Try inserting, if pq is full catch thrown exception.
                    try {
                        pq.Insert (newValue);
                    }
                    catch (Exception e) {
                        System.out.println (e);
                    }
                    break;
                case 3:
                    try {
                        // Retrieve item and report that item to the user.
                        System.out.println ("The value that was retrieved is: " 
                                + pq.Retrieve() + ".");
                    }
                    catch (Exception e) {
                        System.out.println (e);        
                    }
                    break;
            }
        }
        while (response != QUIT);
    }
}

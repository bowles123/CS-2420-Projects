// This program demonstrates a reference based implementation of the deque interface
// Brian Bowles, 10/10/14.

// Import needed packages
package bowlproject7;
import java.util.Scanner;

// Main class to call other methods to demonstrate implementation.
public class BowlProject7 {

    /**
     * @param args the command line arguments
     */
    // Main method to call the menu to do the work.
    public static void main(String[] args) {
        // Variable
        int option_;
        QueueGeneric<String> queue_ = new QueueGeneric();
        
        // Call the menu while the quit option was not selected.
        do {
           option_ = menu(queue_); 
        }
        while (option_ != 5);
    }
    
    // This method is a menu asking the user what they would like to do
    // returns the value of option back to the main method.
    public static int menu (QueueGeneric<String> queue) {
        // Variables and references.
        int option;
        String item;
        Scanner input = new Scanner (System.in);
        
        // Get the option from the user.
        System.out.println ("What would you like to do?");
        System.out.println ("1. Insert a new item\n" + "2. Remove the next item\n" 
                + "3. Retrieve the next item\n" + "4. See if queue is empty.\n" + "5. Quit.");
        option = input.nextInt();
        input.nextLine();
        
        // Switch on the option according to the request of the user.
        switch (option) {
            case 1:
                // Get the item to be inserted.
                System.out.println ("What is the item you'd like to insert?");
                item = input.nextLine();
                
                // Add item to the beginnning of the queue.
                queue.enqueue(item);
                break;
            case 2:
                try {
                    // Remove the first item of the queue.
                    item = queue.dequeue();
                    System.out.println ("The item you removed is: " + item);
                }
                // Catch exception if the item cannot be removed.
                catch (Exception e) {
                    System.out.println ("Error: "+ e.getMessage());
                }
                break;
            case 3:
                try {
                // Look at the first item in the queue.
                item = queue.peek();
                System.out.println ("The item currently in the front of the queueu is: "
                        + item);
                }
                // Catch exception if the queue is empty.
                catch (Exception e) {
                    System.out.println ("Error: "+ e.getMessage());
                }
                break;
            case 4:
                // Report whether the queue is empty or not.
                if (queue.isEmpty() == true)
                    System.out.println ("The queue is empty.");
                else
                    System.out.println ("The queue is not empty.");
                break;
        }
        return option;
    }
}

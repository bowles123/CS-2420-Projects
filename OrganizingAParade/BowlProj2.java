// This program demonstrates the problem of organizing a parade as illustared
// in the textbook, Brian Bowles, 09/08/14.
package bowlproj2;

// Import necessary packages.
import java.util.Scanner;

// This is the main class that calls other function to execute the program.
public class BowlProj2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Call the GetParade method to solve the problem.
        GetParade();
    }
    
    // This method is the recursive solution for solving the problem
    public static int Parade(int number) throws Exception {
        // Base case 1, returns 2.
        if (number < 1)
            throw new Exception ("Can't have a negative value.");
        if (number == 1)
            return 2;
        else
            // Base case 2, returns 3.
            if (number == 2)
                return 3;
        else
                // If Base case isn't found simplify the problem until base case is reached.
                return Parade(number - 1) + Parade(number - 2);
    }
    
    // This method gets the information from the user and solves the problem.
    public static void GetParade () {
        // Variables.
        Scanner in = new Scanner(System.in);
        int tempNum, parade = 0;
        String repeat;
        
        // Repeats as long as user desires.
        do {
            // Get number of items that will be in the parade.
            System.out.print("What is the number of items in your parade? ");
            tempNum = in.nextInt();
            try {
            parade = Parade(tempNum);
            System.out.println(parade);
            }
            catch (Exception e) {
               System.out.println(e.getMessage ());
            }
            
            // Ask the user if they would like to repeat and do if they'd like.
            System.out.println("Would you like to repeat the program? Y or N.");
            in.nextLine();
            repeat = in.nextLine();
            
        }
        while (repeat.equals("Y") || repeat.equals("y"));
    }
}

// This program demonstrates the use of a polynomial class.
// Brian Bowles, September 19, 2014.
package bowlproject4;
import java.util.Scanner;

/**
 *
 * @author 00153401
 */
// This class contains the methods used to demonstrate the polynomial function.
public class BowlProject4 {
    private static Polynomial f = new Polynomial (), g = new Polynomial (), temp = new Polynomial ();
    /**
     * @param args the command line arguments
     */
    // This method gets information from the user to send to the menu method.
    public static void main(String[] args) {
        // Variables.
        int menuOption;
        Scanner in = new Scanner (System.in);
        
        // Display the menu as long as the user wants to continue.
        do {
            System.out.println ("What would you like to do?\n" + "1. Create a polynomial.\n"
            + "2. Add two polynomials.\n3. Evaluate polynomial.\n"
            + "4. Display Polynomial.\n5. Quit");
            menuOption = in.nextInt();
            menu (menuOption);  
        }
        while (menuOption != 5);
    }
    
    // This method demonstrates the different functions of the polynomial class.
    static void menu (int option) {
        // Variables.
        int x, power, coeff;
        Scanner in = new Scanner (System.in);
        double sum = 0;
        
        // Switch statement on the variable option to perform whichever operation user insists on.
        switch (option) {
            case 1:
                // Get the order of the polynomial.
                System.out.println ("Please enter the highest power of your polynomial: ");
                power = in.nextInt();
                f = new Polynomial ();
                
                // Get the coefficients of the polynomial as long as they haven't been specified.
                for (int i = 0; i <= power; i++) {
                        System.out.println ("Please enter coefficient " + (power - i) + ": ");
                        coeff = in.nextInt();
                        f.setCoefficient (coeff, power - i);
                   }
                break;
            case 2:
                // Get the order of the new polynomial that you'll be adding to.
                System.out.println ("Please enter the highest power of your new polynomial: ");
                power = in.nextInt();
                
                // Get the coefficients as long as they haven't been specified.
                for (int i = 0; i <= power; i++) {
                        System.out.println ("Please enter coefficient " + (power - i) + ": ");
                        coeff = in.nextInt();
                        g.setCoefficient (coeff, power - i);
                   }
                
                // Use a temporary Polynomial to store and display the sum of the two polynomials.
                temp = f.add(g);
                System.out.println ("The two polynomials added together are: " + temp.toString());
                break;
            case 3:
                // Get the value of x from the user.
                System.out.println ("Please enter the value of x: ");
                x = in.nextInt();
                try {
                        sum = f.evaluate (x);
                        System.out.println ("The evaluated polynommial is: " + sum);
                    }
                // If the polynomials can't be added output an error message.
                catch(PolynomialException e){
                    System.out.println("Error: "+ e.getMessage());
                }
                break;
            case 4:
                // Get the polynomial the user wants you to display.
                System.out.println ("Which polynomial would you like to display? 1 or 2? ");
                option = in.nextInt();
                if (option == 1)
                    // Display polynomial 1.
                    System.out.println ("The polynomial is: " + f.toString());
                else
                    // Display polynomial 2.
                    System.out.println("The polynomial is: " + g.toString());
                break;
            default:
                break;
        }
    }
}

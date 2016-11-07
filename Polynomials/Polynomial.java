// This class demonstrates a math function that is a polynomial using linked lists.
// Brian Bowles, September 19, 2014.
package bowlproject4;

/**
 *
 * @author 00153401
 */
// Polynomial class.
public class Polynomial {
    // Data Fields
    private Node head;
    private int degree;
    
   //  Polynomial constructor.
    public Polynomial () {
        degree = -1;
        head = null;
    }
    
    // This method gets the coefficient of a polynomial given its power.
    public int getCoefficient (int power) throws PolynomialException {
        // Reference.
        Node cur = head;
        
        // Check to see if the linked list is empty, and throw an exception if it is.
        if (cur == null)
            throw new PolynomialException ("There is no coefficient to get.");
        
        // Returns the coefficient of the node at a give power.
        else {
            while (cur.next != null && cur.power > power)
                cur = cur.next;
            return cur.coefficient;
        }
    }
    
    // Sets the coefficient of a polynomial given its power.
    public void setCoefficient (int coeff, int pow) {
        // Reference.
        Node prev, cur = head;
        
        // If the linked list is empty create a new node with the give variables.
        if (head == null) {
            head = new Node();
            head.coefficient = coeff;
            head.power = pow;
            head.next = null;
        }
        // Otherwise set the coefficient of the polynomial given its power.
        else if (coeff == 0) {
                if (head.next != null) {
                   prev = head; 
                   
                   // Traverse linked list to find given power.
                   while (cur.next != null && cur.power != pow) {
                       prev = cur;
                       cur = cur.next;
                   }
                   prev = cur.next;
                }
        }
        else {
            while (cur.next != null && cur.power > pow)
            cur = cur.next;
        cur.next = new Node ();
        cur.next.next = null;
        cur.next.coefficient = coeff;
        cur.next.power = pow;
        }
    }
    
    // This method converts a polynomial to a string.
    @Override
    public String toString () {
        // Variable and Reference.
        String polynomial;
        Node cur = head;
        
        // If there's an empty linked list let the user know there's no polynomial.
        if (head == null)
            return "No polynomial.";
        else {
            // Display the polynomial.
            polynomial = (cur.coefficient + "x^" + cur.power);
            cur = cur.next;
            while (cur != null) {
              polynomial += (" + " + cur.coefficient + "x^" + cur.power);
              cur = cur.next;
            }
            return polynomial;
        }
    } 
    
    // This method evaluates a polynomial given a value for x.
    public double evaluate (double x) throws PolynomialException {
        // Variable and Reference.
        Node cur = head;
        double sum = 0;
        
        // If the linked list is empty throw an exception, otherwise evaluate.
        if (head == null)
            throw new PolynomialException ("No polynomial to evaluate.");
        else 
            while (cur != null) {
                sum += cur.coefficient * Math.pow(x, cur.power);
                cur = cur.next;
            }
            return sum;
    }
    
    // This method adds two polynomials together.
    public Polynomial add (Polynomial other) {
        // Variables and References.
        Polynomial newPolynomial = new Polynomial ();
        Node otherCur = other.head, newCur = newPolynomial.head = new Node (), thisCur = head;
        
        // If the linked list is empty return the original polynomial.
        if (head == null)
            return other;
        else {
            // If there is a polynomial to add to do this by adding the coefficients of like powers.
            while (thisCur != null && otherCur != null) {
                if (thisCur.power == otherCur.power) {
                    newCur.next = new Node (thisCur.coefficient + otherCur.coefficient, thisCur.power);
                    thisCur = thisCur.next;
                    otherCur = otherCur.next;
                    newCur = newCur.next;
                }
                // Add the nonlike terms to the new polynomial.
                else if (thisCur.power > otherCur.power) {
                    newCur.next = new Node (thisCur.coefficient, thisCur.power);
                    thisCur = thisCur.next;
                    newCur = newCur.next;
                }
                else {
                    newCur.next = new Node (otherCur.coefficient, otherCur.power);
                    otherCur = otherCur.next;
                    newCur = newCur.next;
                }
            }
            if (thisCur == null)
                while (otherCur != null) {
                    newCur.next = new Node (otherCur.coefficient, otherCur.power);
                    newCur = newCur.next;
                    otherCur = otherCur.next;
                }
            else 
                while (otherCur != null) {
                    newCur.next = new Node (otherCur.coefficient, otherCur.power);
                    newCur = newCur.next;
                    otherCur = otherCur.next;
                }  
            return newPolynomial;
        }
    } 
} 

// PolynomialException class.
class PolynomialException extends Exception {
    public PolynomialException (String s) {
        super (s);
    }
}

// Node class.
class Node {
    // Data fields.
    int coefficient;
    int power;
    Node next;
    
    // Default Consturctor.
    Node () {
        coefficient = 0;
        power = 0;
        next = null;
    }
    
    // Explicit Value constructor.
    Node (int coeff, int pow) {
        coefficient = coeff;
        power = pow;
        next = null;
    }
}

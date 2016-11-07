// This program is a basic AI, allowing for growth as it runs.
// Brian Bowles 11/03/14.
package bowlproj09;
import java.util.Scanner;

// Main class to call methods to execute the program.
public class BowlProj09 {

    /**
     * @param args the command line arguments
     */
    // Main method in the class that does all the calling of methods.
    public static void main(String[] args) {
        // Variables.
        String contin = "NO";
        Scanner in = new Scanner (System.in);
        BinaryTree rightSubtree = new BinaryTree<String> ("Cat?");
        BinaryTree leftSubtree = new BinaryTree<String> ("Snake?");
        BinaryTree tree = new BinaryTree<String> ("Does it have legs?", 
                rightSubtree, leftSubtree);
        
        // Greeting.
        System.out.println ("Hello this program is a basic AI like 20 questions.");
        
        do {
            System.out.println ("Think of an animal and I will guess it!");
            traverse(tree);
            
            System.out.println ("Continue? (Yes or No)");
            contin = in.nextLine();
        }while ("YES".equals(contin.toUpperCase()));
    }
    
    public static void traverse (BinaryTree<String> root) {
        // Variables.
        Scanner in = new Scanner(System.in);
        String response, leftAnswer, rightAnswer;
        BinaryTree leftSubtree, rightSubtree;
        
        // Detach subtrees and assign them to be their own tree temporarily.
        leftSubtree = root.detachLeftSubtree();
        rightSubtree = root.detachRightSubtree();
        
        // If the subtrees aren't empty then continue to ask questions.
        if (!leftSubtree.isEmpty() && !rightSubtree.isEmpty()) {
            System.out.println (root.getRootItem());
            response = in.nextLine();
            
            // If the answer to the question is yes, then traverse the leftSubtree.
            if ("YES".equals(response.toUpperCase())) {
                traverse(leftSubtree);
                root.attachLeftSubtree(leftSubtree);
                root.attachRightSubtree(rightSubtree);
            }
            // Otherwise traverse the rightSubtree.
            else {
                traverse(rightSubtree);
                root.attachLeftSubtree(leftSubtree);
                root.attachRightSubtree(rightSubtree);
            }
        }
        // If the root is the only item in the tree then guess the animal.
        else {
            System.out.println ("Is it a " + root.getRootItem());
            response = in.nextLine();
            
            // If the answer is correct output that.
            if ("YES".equals(response.toUpperCase()))
                System.out.println("I win!");
            // Otherwise give up and learn from the user.
            else {
                System.out.println ("I give up. What is it?");
                leftAnswer = in.nextLine();
                rightAnswer = root.getRootItem();
                System.out.println ("Please type a question whose answer is"
                        + " yes for a/an " + leftAnswer + " and no for a/an " 
                        + rightAnswer + ".");
                // Attach what was learned from the user to the tree.
                root.setRootItem(in.nextLine());
                root.attachLeft(leftAnswer);
                root.attachRight(rightAnswer);
            }
        }
    }
}

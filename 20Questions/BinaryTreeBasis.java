// This class is a basis for a binary tree. Brian Bowles, 11/03/14.
package bowlproj09;

// Tree Exception class to deal with errors.
class TreeException extends RuntimeException {
  public TreeException(String s) {
    super(s);
  }
}

// Tree node class to deal with the nodes of a binary tree.
class TreeNode<T> {
  // Data fields.
  T item;
  TreeNode<T> leftChild;
  TreeNode<T> rightChild;

  // This method initializes the nodes of a tree with one node.
  public TreeNode(T newItem) {
  // Initializes tree node with item and no children.
    item = newItem;
    leftChild  = null;
    rightChild = null;
  }

  // This method initializes the nodes of a tree with more than one node.
  public TreeNode(T newItem,
                  TreeNode<T> left, TreeNode<T> right) {
  // Initializes tree node with item and the left and right children references.
    item = newItem;
    leftChild  = left;
    rightChild = right;
  }
}

// The binary tree basis abstract class.
public abstract class BinaryTreeBasis<T> {
  // Data field.
  protected TreeNode<T> root;

  // Default Constructor, sets root to null.
  public BinaryTreeBasis() {
    root = null;
  }

  // Explicit-value Constructor, sets root to a tree with one node.
  public BinaryTreeBasis(T rootItem) {
    root = new TreeNode<T>(rootItem, null, null);
  }

  // This method checks to see if a binary tree is empty.
  public boolean isEmpty() {
    // Returns true if the tree is empty, else returns false.
    return root == null;
  }

  // This method deletes all the nodes of a binary tree.
  public void makeEmpty() {
    // Removes all nodes from the tree.
    root = null;
  }

  // This node returns the item in the root node of the binary tree.
  public T getRootItem() throws TreeException {
    // Returns the item in the tree's root.
    if (root == null) {
      throw new TreeException("TreeException: Empty tree");
    }
    else {
      return root.item;
    }
  }

  // This method sets the root node of a binary tree.
  public abstract void setRootItem(T newItem);
    // Throws UnsupportedOperationException if operation is not supported.

}
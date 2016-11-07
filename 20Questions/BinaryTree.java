// This class represents a binary tree. Brian Bowles, 11/03/14.
package bowlproj09;

// Class defintion.
public class BinaryTree<T> extends BinaryTreeBasis<T> {

  // Default Constructor.
  public BinaryTree() {
  }

  // Explicit-value Constructor setting the root node.
  public BinaryTree(T rootItem) {
    super(rootItem);
  }

  // Explicit-value Constructor setting the root node and 
  // left and right subtrees.
  public BinaryTree(T rootItem,
                    BinaryTree<T> leftTree,
                    BinaryTree<T> rightTree) {
    root = new TreeNode<T>(rootItem, null, null);
    attachLeftSubtree(leftTree);
    attachRightSubtree(rightTree);
  }

  // This method sets the root node of a binary tree.
  @Override
  public void setRootItem(T newItem) {
    if (root != null) {
      root.item = newItem;
    }
    else {
      root = new TreeNode<T>(newItem, null, null);
    }
  }

  // This method attaches a left child to the binary tree.
  public void attachLeft(T newItem) {
    if (!isEmpty() && root.leftChild == null) {
      // Assertion: nonempty tree; no left child.
      root.leftChild = new TreeNode<T>(newItem, null, null);
    }
  }
  
  // This method attaches a right child to the binary tree.
  public void attachRight(T newItem) {
    if (!isEmpty() && root.rightChild == null) {
      // Assertion: nonempty tree; no right child.
      root.rightChild = new TreeNode<T>(newItem, null, null);
    }
  }

  // This method attaches a left subtree to the binary tree.
  public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else if (root.leftChild != null) {
      // A left subtree already exists; it should have been deleted first.
      throw new TreeException("TreeException: " +
                           "Cannot overwrite left subtree");
    }
    else {
      // Assertion: nonempty tree; no left child.
      root.leftChild = leftTree.root;
      // don't want to leave multiple entry points into our tree.
      leftTree.makeEmpty();
    }
  }

  // This method attaches a right subtree to the binary tree.
  public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else if (root.rightChild != null) {
      // A right subtree already exists; it should have been deleted first.
      throw new TreeException("TreeException: " +
                          "Cannot overwrite right subtree");
    }
    else {
      // Assertion: nonempty tree; no right child.
      root.rightChild = rightTree.root;
      // Don't want to leave multiple entry points into our tree.
      rightTree.makeEmpty();
    }
  }

  // Protected Constructor.
  protected BinaryTree(TreeNode<T> rootNode) {
    root = rootNode;
  }

  // This method detaches a left subtree from the binary tree.
  public BinaryTree<T> detachLeftSubtree() throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else {
      // Create a new binary tree that has root's left node as its root.
      BinaryTree<T> leftTree;
      leftTree = new BinaryTree<T>(root.leftChild);
      root.leftChild = null;
      return leftTree;
    }
  }

  // This method detaches a right subtree from the binary tree.
  public BinaryTree<T> detachRightSubtree() throws TreeException {
    if (isEmpty()) {
      throw new TreeException("TreeException:  Empty tree");
    }
    else {
      BinaryTree <T> rightTree;
      rightTree = new BinaryTree<T>(root.rightChild);
      root.rightChild = null;
      return rightTree;
    }
  }
}

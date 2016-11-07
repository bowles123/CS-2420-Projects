// This class implements the Deque inteface of the JCF.
// Brian Bowles, 10/10/14.

package bowlproject7;

// This class implements the double ended queue interface.
public class QueueGeneric <T> {

    // Node class to implement the Deque using references.
    class Node <T> {
        // Data fields.
        private Node<T> next;
        private T item;
        
    }
    
    // References to point to the front and the back of the queue repsectively.
    private Node<T> head;
  
    // This  method reports whether the deque is empty or not.
    public boolean isEmpty () {
        if (head == null)
            return true;
        else 
            return false;
    }
    
    // This method adds an item to the beginning of the deque
    // Reports true if possible, false if not.
    public void enqueue (T item) {
        Node<T> newNode = new Node(), cur = head;
        
        // Add item to the front of the queue if it's empty
        if (isEmpty()) { 
            head = newNode;
            newNode.next = null;
            newNode.item = item;
        }
        // Add item to the back of the nonempty queue.
        else {
            while (cur.next != null)
                cur = cur.next;
            cur.next = newNode;
            newNode.item = item;
            newNode.next = null;
        }
    }
    
    // This method removes the first item in the deque and returns it.
    public T dequeue () throws Exception {
        // Variable.
        Node <T> cur = head;
        
        // If the queue is empty let the user know item cannot be removed.
        if (isEmpty())
            throw new Exception ("Cannot remove from empty queue.");
        
        // Point around the first item and return it.
        head = head.next;
        return cur.item;
    }
    
    // This method returns the first item in the deque leaving it unchanged
    // Returns null if the deque is empty.
    public T peek () throws Exception {
        // If the queue is empty throw exception.
        if (isEmpty())
            throw new Exception ("Queue is empty.");
        else 
            return head.item;
    }
    
    // This method removes all of the items from the queue.
    public void dequeueAll () {
        head = null;
    }
}
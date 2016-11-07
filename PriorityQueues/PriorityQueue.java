// Implementation of the priority queue using an array, Brian Bowles,
// 11/17/14.
package bowlproj10;

// Class defintion.
public class PriorityQueue {
    // Data fields.
    private float items [];
    private static final int SIZE = 100;
    private int front;
    
    // Constructor.
    PriorityQueue () {
        items = new float [SIZE];
        front = -1;
    }
    
    // Returns true if priority queue is empty, returns false otherwise.
    public boolean IsEmpty () {
        if (front == -1)
            return true;
        else
            return false;
    }
    
    // Returns true if priority is full, returns false otherwise.
    public boolean IsFull () {
        if (front == SIZE - 1)
            return true;
        else
            return false;
    }
    
    // Inserts an item into the proper position of the priority queue.
   public void Insert (float newItem) throws Exception {
        // If the priority queue is full throw an exception
        if (IsFull ())
            throw new Exception("No more room in the priority queue.");
        // If priority queue is empty place item at beginning of array,
        // increment front. Else traverse until proper position is found.

        for (int i = 0; i < front + 1; i++) {
            // When proper position is found place item there,
            // break out of loop.
            if (newItem < items[i]) {
                shiftItem (newItem, i);
                front++;
                return;
                }
        } 
            items[++front] = newItem;
        
    }
   
   // Shift the items in the priority queue to place the new item.
   private void shiftItem (float item, int index) {
       if (index < front+1) {
           float swap = items[index];
           items[index] = item;
           shiftItem(swap, ++index);
       }
       else {
           items[index] = item;
       }
   }

    // Retrieves the front item of the priority queue and returns it.
   public float Retrieve () throws Exception {
        if (IsEmpty())
            throw new Exception("Can't retrieve from an empty priority queue.");
        float item;
        item = items [front];
        front--;
        return item;
    }
}

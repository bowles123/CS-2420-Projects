// This program compares five implementations for sorting data.
// Selection, Bubble, Insertion, Merge, and Quic sorts.
// Brian Bowles 10/27/14.
package bowlproj08;

import java.util.Random;
import java.util.Scanner;


// Main class containing the methods to execute the program.
public class BowlProj08 {

    /**
     * @param args the command line arguments
     */
    // Main class, executes calls the sort methods to compare them.
    public static void main(String[] args) {
        // Variables.
        long startTime = System.nanoTime();
        long runTime;
        Integer array [], size;
        Scanner in = new Scanner (System.in);
        String again;
        Random generator = new Random();
        Integer [] tempArray;
        final int milli = 1000000;
        
        // Greeting
        System.out.println ("Welcome, this program calculates the running time of "
                + "Several different implementation to sort an array.");
        
        // Sort the array using the different sorts as long as the user would like.
        do {
            // Get the array size.
            System.out.println ("What size of array would you like to use?");
            size = in.nextInt();
            array = new Integer [size];
            
            // Generate random numbers and add them to the array.
            for (int i = 0; i < size; i++)
            {
                array [i] = generator.nextInt();
            }
            
            // Copy the array to pass it to the selection sort.
            tempArray = new Integer [size];
            tempArray = array.clone();
            
            // Get the start time and calculate the time it takes to sort the
            // Array using the selection sort.
            startTime = System.nanoTime();
            selectionSort(tempArray, size - 1);
            runTime = (System.nanoTime() - startTime) / milli;
            // Output the runtime.
            System.out.println ("The selection sort sorted in " + runTime + " ms.");
            
            // Copy the array to send it to the bubble sort.
            tempArray = array.clone();
            
            // Get the start time and calculate the time it takes to sort the 
            // Array using the bubble sort.
            startTime = System.nanoTime();
            bubbleSort(tempArray, size - 1);
            runTime = (System.nanoTime() - startTime) / milli;
            // Output the runtime.
            System.out.println ("The bubble sort sorted in " + runTime + " ms.");
            
            // Copy the array to send it to the insertion sort.
            tempArray = array.clone();

            // Get the start time and calculate the time it takes to sort the 
            // Array using the insertion sort.
            startTime = System.nanoTime();
            insertionSort(tempArray, size - 1);
            runTime = (System.nanoTime() - startTime) / milli;
            // Output the runtime.
            System.out.println ("The insertion sort sorted in " + runTime + "ms.");
            
            // Copy the array to send it to the merge sort.
            tempArray = array.clone();

            // Get the start time and calculate the time it takes to sort the 
            // Array using the merge sort.
            startTime = System.nanoTime();
            mergesort(tempArray);
            runTime = (System.nanoTime() - startTime) / milli;
            // Output the runtime.
            System.out.println ("The merge sort sorted in " + runTime + " ms.");
            
            // Copy the array to send it to the quick sort.
            tempArray = array.clone();

            // Get the start time and calculate the time it takes to sort the
            // Array using the quick sort.
            startTime = System.nanoTime();
            quickSort(tempArray, 0, size - 1);
            runTime = (System.nanoTime() - startTime) / milli;
            // Output the runtime.
            System.out.println ("The quick sort sorted in " + runTime + " ms.");
            
            // Ask the user if they'd like to run program again, if so do that.
            System.out.println ("Would you like to run the program again? (Y or N)");
            in.nextLine();
            again = in.nextLine();
        }
        while (again.equals("Y") || again.equals ("y"));
    }
    
    // This method sorts an array of random integers via selection.
    public static <T extends Comparable<? super T>>
    void selectionSort(T[] theArray, int n) {

        for (int last = n-1; last >= 1; last--) {
        // Invariant: theArray[last+1..n-1] is sorted
        // and > theArray[0..last]

        // select largest item in theArray[0..last].
        int largest = indexOfLargest(theArray, last+1);

        // swap largest item theArray[largest] with theArray[last].
        T temp = theArray[largest];
        theArray[largest] = theArray[last];
        theArray[last] = temp;
        }
    } 
    
    // This method returns the index of the largest element.
    private static <T extends Comparable<? super T>>
    int indexOfLargest(T[] theArray, int size) {
        // Index of largest item found so far.
        int indexSoFar = 0; 

        // Invariant: theArray[indexSoFar]>=theArray[0..currIndex-1]
        for (int currIndex = 1; currIndex < size; ++currIndex) {
          if (theArray[currIndex].compareTo(theArray[indexSoFar])>0) {
            indexSoFar = currIndex;
          }  // end if
        } // end for
        
        // Return index of largest item.
        return indexSoFar;  
    }
    
    // This method sorts an array of random integers via bubbling.
    public static <T extends Comparable<? super T>>
    void bubbleSort(T[] theArray, int n) {
        
        // Variable.
        boolean sorted = false; 

        for (int pass = 1; (pass < n) && !sorted; ++pass) {
        // Invariant: theArray[n+1-pass..n-1] is sorted
        //            and > theArray[0..n-pass]
        
        // Assume sorted.
        sorted = true;  
        
        for (int index = 0; index < n-pass; ++index) {
        // Invariant: theArray[0..index-1] <= theArray[index]
            int nextIndex = index + 1;
            if (theArray[index].compareTo(theArray[nextIndex]) > 0) {
                // Exchange items.
                T temp = theArray[index];
                theArray[index] = theArray[nextIndex];
                theArray[nextIndex] = temp;
                
                // Signal exchange.
                sorted = false;  
                }
            }

        // Assertion: theArray[0..n-pass-1] < theArray[n-pass]
        }
    } 

    // This method sorts an array of random intergers via insertion.
    public static <T extends Comparable<? super T>>
    void insertionSort(T[] theArray, int n) {

        for (int unsorted = 1; unsorted < n; ++unsorted) {
        // Invariant: theArray[0..unsorted-1] is sorted.

        // Find the right position (loc) in
        // theArray[0..unsorted] for theArray[unsorted],
        // which is the first item in the unsorted
        // region; shift, if necessary, to make room.
        T nextItem = theArray[unsorted];
        int loc = unsorted;

        while ((loc > 0) && (theArray[loc-1].compareTo(nextItem) > 0)) {
          // Shift theArray[loc-1] to the right.
          theArray[loc] = theArray[loc-1];
          loc--;
        }
        
        // Assertion: theArray[loc] is where nextItem belongs
        // insert nextItem into sorted region
        theArray[loc] = nextItem;
        }
    }

    // This method sorts an array of random integers via merging.
    public static<T extends Comparable<? super T>>
    void mergesort(T[ ] theArray) {
        
        // Declare temporary array used for merge, must do
        // unchecked cast from Comparable<?>[] to T[]
        T[] tempArray = (T[])new Comparable<?>[theArray.length];
        mergesort(theArray, tempArray, 0, theArray.length - 1 );
    }

    // This method merges arrays that have been sorted.
    private static<T extends Comparable<? super T>>
    void merge(T[] theArray, T[] tempArray, int first, int mid, int last) {

        // initialize the local indexes to indicate the subarrays
        int first1 = first;    // Beginning of first subarray.
        int last1  = mid;      // End of first subarray.
        int first2 = mid + 1;  // Beginning of second subarray.
        int last2  = last;     // End of second subarray.
        
        // while both subarrays are not empty, copy the
        // smaller item into the temporary array
        int index = first1;    // Next available location in tempArray.

        while ((first1 <= last1) && (first2 <= last2)) {
          // Invariant: tempArray[first1..index-1] is in order
          if (theArray[first1].compareTo(theArray[first2])<0) {
            tempArray[index] = theArray[first1];
            first1++;
          }
        else {
        tempArray[index] = theArray[first2];
        first2++;
        }
        index++;
        }

        // finish off the first subarray, if necessary
        while (first1 <= last1) {
          // Invariant: tempArray[first1..index-1] is in order
          tempArray[index] = theArray[first1];
          first1++;
          index++;
        }
        
        // finish off the second subarray, if necessary
        while (first2 <= last2) {
          // Invariant: tempArray[first1..index-1] is in order
          tempArray[index] = theArray[first2];
          first2++;
          index++;
        }

        // copy the result back into the original array
        for (index = first; index <= last; ++index) {
          theArray[index] = tempArray[index];
        }
    }

    // This method sorts an array of random integers via merging.
    public static <T extends Comparable<? super T>>
    void mergesort(T[] theArray, T[] tempArray, int first, int last) {

        if (first < last) {
        // sort each half
        int mid = (first + last)/2;   // index of midpoint
        // sort left half theArray[first..mid]
        mergesort(theArray, tempArray, first, mid);
        // sort right half theArray[mid+1..last]
        mergesort(theArray, tempArray, mid+1, last);

        // merge the two halves
        merge(theArray, tempArray, first, mid, last);
        }
    }

    // This method chooses a pivot point for the quicksort.
    private static <T extends Comparable<? super T>>
    void choosePivot(T[] theArray, int first, int last) {

    // Implementation left as an exercise.
    }

    // This method partitions the array for the quicksort.
    private static <T extends Comparable<? super T>>
    int partition(T[] theArray, int first, int last) {

        // tempItem is used to swap elements in the array
        T tempItem;
        // place pivot in theArray[first]
        choosePivot(theArray, first, last);
        T pivot = theArray[first];   // reference pivot

        // initially, everything but pivot is in unknown
        int lastS1 = first;          // index of last item in S1

        // move one item at a time until unknown region is empty
        // firstUnknown is the index of first item in unknown region

        for (int firstUnknown = first + 1; firstUnknown <= last;
                                          ++firstUnknown) {
          // Invariant: theArray[first+1..lastS1] < pivot
          //            theArray[lastS1+1..firstUnknown-1] >= pivot
          // move item from unknown to proper region
          if (theArray[firstUnknown].compareTo(pivot) < 0) {
            // item from unknown belongs in S1
            ++lastS1;
            tempItem = theArray[firstUnknown];
            theArray[firstUnknown] = theArray[lastS1];
            theArray[lastS1] = tempItem;
          }
        // else item from unknown belongs in S2
        }

        // place pivot in proper position and mark its location
        tempItem = theArray[first];
        theArray[first] = theArray[lastS1];
        theArray[lastS1] = tempItem;
        return lastS1;
}

    // This method sorts an array of random integers via partitioning.
    public static <T extends Comparable<? super T>>
    void quickSort(T[] theArray, int first, int last) {

        int pivotIndex;

        if (first < last) {
          // create the partition: S1, Pivot, S2
          pivotIndex = partition(theArray, first, last);

          // sort regions S1 and S2
          quickSort(theArray, first, pivotIndex-1);
          quickSort(theArray, pivotIndex+1, last);
        }
    }
}

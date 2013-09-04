// Binary search in java
// 1. divide and conqure 
//
class binarySearch {
    public static int[] aChar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13} ;   
    public static int key = 3;
    public static void main(String[] args) {
        // iterative binary search
        
        // recursive binary search
        int result = binarySearch(key,0, aChar.length-1);
        System.out.println("The search is found at index " + result);
    }
     
    public static int findMiddle(int start, int end ) {
        int mid = ((end - start)+1)/2;
        return mid;
    }
        
    public static void binarySearch(int key, int start, int end) {
        if(aChar.length == 1) // base case
            return;
        else {    // main case
            // find the middle element
            try {
                int mid = findMiddle(start, end);
                System.out.println("middle " + mid);
                // sleep(1);
            // compare and call the binary search function
            if(aChar[mid] == key) {
                System.out.println("Search found at index " + mid);
                return;
            }
            else if(aChar[mid] < key) {
                System.out.print("Entering right part of array: with start " + mid + " and end " + end);
                binarySearch(key, start, end);
            }
            else {
                System.out.print("Entering left part of array: with start " + start + " and end " + end);
                binarySearch(key, 0, mid-1);
            }} catch(Exception ex) {System.out.println("exception " + ex);}
        } 
    }
}

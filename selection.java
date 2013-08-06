// selection.java is a programe for selection sort

import static Mypack.Util.Print.*;


public class selection {
    //int[] arr={1,2,3,4,5,6,7,8,9,10};
    int[] arr={10,9,8,7,6,5,4,3,2,1};
    public int[] selection() {
        for(int i=0; i<arr.length; i++) {
            int min=i;  // starts by making the ith the minimum
                        // in a reduced array
            for(int in=min+1; in<arr.length; in++) {
                // compare and swap the ith with jth element
                if(arr[min] > arr[in])
                    //just change min to index
                    min = in;
            }// swap the minimum value found.
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
        }
        return arr;
    }

    public static void main(String args[]) {
        // testing the printing of array
        //int[] arr = {1,2,3,4,5};
        //printarr(arr);
        int[] arr;
        selection obj = new selection();
        arr= obj.selection();
        nbprint("The sorted array is: ");
        printarr(arr);
    }
}

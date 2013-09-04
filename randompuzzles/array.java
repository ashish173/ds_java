// recursively find maximum in an array.

class array {
    static int arr[] = { 144, 23, 21, 89 }; 
    static int max=0;

    public static void main(String[] args) {
        int maximum = find(0, max);
        System.out.println("Maximum in the array is " + maximum);
    }
    
    public static int find(int index,int max) {
        if(index==arr.length)
            return max;
        else {
            // compare 
            if(arr[index] > max)
                max = arr[index];
            // recursive call
            return find(index+1, max);
        }
    }
}

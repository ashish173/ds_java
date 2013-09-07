// find subsets in array whose sum equal to a given number?? 
// example: S={1,3,5,2,7} and k=10, answer is {1,2,7},{3,5,2},{3,7} 
//
//
//
//
class ArraySubset {
    static int[] arr= { 1, 3, 5, 2, 7 };
    static int sum = 10;

    public static void main(String[] args) {
        
        subset(0);
    }
    
    public static int subset(int index) {
        if(index==arr.length-1) {
            System.out.println("returning form " + arr[index]);
            return arr[index];
        }
        else {
            int add = 0;
            for(int i=index; i<(arr.length); i++) {
                System.out.println("entering " + arr[i]);
                add = arr[index] + subset(i+1);
                if(add==sum) {
                    System.out.println(" " + arr[i]);
                    return 0; 
                }
                // if(add==sum)
                //    System.out.println(" " + arr[index]);
                System.out.println("retruning from " + arr[i]);
            }
        }
        return 0;
    }

}

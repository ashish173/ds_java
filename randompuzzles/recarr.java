class recarr {
    public static int[] arr = {1, 2, 3, 4, 5, 6};
    
    public static void main(String[] args) {
            
        rec_print(0);
    }

    public static void rec_print(int index) {
        if(index == arr.length)
            return;
        else {
            rec_print(index+1);
            System.out.println(" " + arr[index]);
        }
    }
}

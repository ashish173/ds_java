// rope cutting in such a way such that the product of the 
// lengths is maximum 

class RopeCutting {

    public static void main(String[] args) {
         System.out.println("Max value can be " + maxProd(5));

    }
    public static int max(int a, int b) { 
        return (a>b)? a : b;
    }

    public static int max3(int a, int b, int c) {
        return max(max(a, b), c);
    }

    public static int maxProd(int n) {
        System.out.println("Entering in " + n);
        if(n==1 || n==0) {
            System.out.println("Returning from 1");
            return 0;
        }
        int maxVal=0;
        for(int i=1; i<n; i++) {
            maxVal=max3(maxVal, (n-i)*i, maxProd(n-i)*i);
            System.out.println("Returning from " + n);
        }
        return maxVal;
    }
}

class primefactors {
    static int number = 14;

    public static void main(String args[]) {
        int mid = number/2;
        int i,j;
        for(i=mid,j=2; i>j; j++,i--) {
            if(isprime(i) && isprime(j) && i*j == number)
                System.out.println("number are " + i + " " + j);    
        }
    }
    
    public static boolean isprime(int number) {
        for(int i=2; i<number; i++) {
            if(number%i == 0)
                return false;     
        }
        return true;
    }
}

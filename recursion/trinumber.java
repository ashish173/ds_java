// finding nth term in triangular numbers using a loop
// triangular numbers are like 1, 3, 6, 10, 15, 21  
// to find nth number you do (n + previous number)
// 
import java.io.*;

class trinumber {
    public static void main(String[] args) {
        System.out.print("Enter n for nth number you seek: ");
            int num = getInt();  
            // int result = findNum(num);  // normal method used
            int result = recursiveFind(num);
            System.out.println("\n"+ num +"th number is :" + result);
    }
    
    public static int findNum(int n) {
        int num=0;
        System.out.print("Triangular numbers: ");
        for(int i=1; i<=n; i++) {
            num += i;
            System.out.print(" " + num);
        }
        return num;
    }
    // simulation of recursive calling
    public static int recursiveFind(int num) {
        System.out.println("Entering " + num);
        if(num==1) {
            System.out.println("returning 1");
            return 1;
        }    
        else {
            num = num + recursiveFind(num -1);
            System.out.println("returning " + num);
            return num;
        }
    }

    public static int getInt() {
        String ch=null;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        try {
            ch = br.readLine();
        }
        catch(IOException ex) {}
        return Integer.parseInt(ch);
    }
}

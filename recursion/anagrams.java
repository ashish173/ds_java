// anagrams.java
// A simple programe to print all possible permutations
// of a given string
//        Fixed   excange
// cat -->  c  ->  a  t
//          c  ->  t  a
//          c  ->  a  t  // but will not be printed this is original state
//          rotate the string 
//          a  ->  t  c
//          a  ->  c  t
//          a  ->  t  c   // original 
//          rotate the string
//          t  ->  c  a
//          t  ->  a  c
//          t  ->  c  a
//          rotate the string
//          c  ->  a  t  // back to original string 
//          // stop here...:)


import java.io.*;

class anagrams {
    static int size, ch;
    static String str=null; 
    static char[] arrChar = new char[100];
    public static void main(String[] args) throws IOException {
        // str = "CAT";
        System.out.println("\n\t\t Anagrams (String permutations)\n\t\t\t\t\t\tauthor -> ashish singh\n"); 
        while(true) {
            System.out.println();
            System.out.print("\t\tEnter string: ");
            str = getString();
            size = str.length();
            if (size==0)
                continue;
        // put string in an array
            arrChar = new char[100];
            for(int i=0; i<size; i++)
                arrChar[i] = str.charAt(i);

            System.out.println("\n\t1. Simple recursion");
            System.out.println("\n\t2. Detailed recusion with stack calls");
            System.out.print("\n\n\tEnter your choice: ");
            try {
             ch = getInt();
            }catch(NumberFormatException ex) { System.exit(1); }

            switch(ch) {
                case 1: 
                    System.out.println("case 1");
                    anagram(size);   // simple recursion
                    break;
                case 2:
                    anagram_simul(size);  // stack calls 
                    break;
                default:
                    System.out.println("Enter valid values");
            }
        }
    }

    public static void anagram_simul(int size) {
        if(size == 1) {
            System.out.println("returning for size == 1");
            return;
        }    
        else {
            for(int j=0; j<size; j++) {
                System.out.println();
                System.out.print("Calling anagram recusively for size " + size);
                System.out.print(" and for string "); 
                showString();
                System.out.println();
                anagram_simul(size-1);
                if(size==2) {
                    System.out.println("printing when size == 2");
                    showString();
                    System.out.println();
                }    
                System.out.println("rotating for size " + size);
                rotate(size); // this rotate will ensure that every character get to sit at first position
                              // size is same during the loop 
            }
        }
    }
    
    public static void anagram(int size) {
        if(size == 1)
            return;
        else {
            for(int j=0; j<size; j++) {
                anagram(size-1);
                if(size==2){
                    System.out.println();
                    showString();
                }    
                rotate(size);
            }
        }        
    }

    public static int getInt() {
        int ch=0;
        String str = getString();
        return Integer.parseInt(str);
    }

    public static String getString() {
        String str=null;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        try {
            str = br.readLine();
        }    
        catch(Exception ex) { }
        return str;
    }

    public static void showString() {
       System.out.print("Showing string: "); 
       for(int i=0; i<size; i++)
           System.out.print(arrChar[i]);
       System.out.print(" ");
       System.out.flush();
    }
    
    public static void rotate(int newSize) {
        // save first character
        int position = size - newSize;
        char temp = arrChar[position];  
        // now swap array
        for(int i=position+1; i<size; i++)
            arrChar[i-1] = arrChar[i];
        arrChar[size-1] = temp;
    }
}

/* BinaryCode.java
 *
class:
BinaryCode
Method:
decode
Parameters:
String
Returns:
String[]
Method signature:
String[] decode(String message)
(be sure your method is public)
*/


public class BinaryCode {

    public static void main(String[] args) {
        String str = "123210122";
        String[] decoded_strings = new String[2];
        decoded_strings = decode(str);
        System.out.println(" { " + decoded_strings[0] + " , " + decoded_strings[1] + " }");
    }

    public static String[] decode(String str) {
        String[] decoded_array=new String[2];    // holds the 2 strings for decoded string
        decoded_array[0] = test(str, 0);    // assuming the string starts with 0
        decoded_array[1] = test(str, 1);    // assuming the string starts with 1
        return decoded_array;
    }
    
    public static String test(String encrypt,int num) {
        int[] q = strToArray(encrypt);   // encrypted string
        int[] p = new int[q.length];    // decrypted string
        int i=0;
        //for the first case
        p[0] = num;
        p[1] = q[0] - p[0];
        // for loop for the rest of array
        for(i=1; i<(q.length-2); i++) {
            p[i+1] = q[i]-p[i-1]-p[i];
            if(p[i+1]>1 || p[i+1]<0)
                return "NONE";
        }
        p[i+1] = q[i+1]-p[i];      // checking for end of string
        if(p[i+1]>1 || p[i+1]<0)
            return "NONE";
        return arrToString(p);
    }

    public static int[] strToArray(String str) {
        int[] arr=new int[str.length()];
        for(int i=0; i<str.length(); i++) {
            Character ch = new Character(str.charAt(i));
            String s = ch.toString();          // toString is method for a Character
            arr[i] = Integer.parseInt(s);      // parseInt works only for a string
        }
        return arr;
    }

    public static String arrToString(int[] arr) {
        String str="";      // god i wasted so much time in initializing the string to an empty string 
                            // for god sake now remember that from now on
        for(int i=0; i<arr.length; i++)
                str = str + arr[i];
        return str;
    }
}

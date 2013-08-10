// Hashing in java(linear probing)
import java.io.*; 

// DataItem class
class DataItem {
    private int iData;
    // constructor
    public DataItem(int ii) { 
        iData = ii;
    }
    // returns keys
    public int getKey() {
        return iData;
    }
}// end of DataItem

class HashTable {
    private DataItem[] hashArray;   // hashArray holds DataItems it is main hashtable
    private int arraySize;          // size of hashArray  
    // constructor
    public HashTable(int size) {
       arraySize = size;
       hashArray = new DataItem[arraySize];
    }
    // display table
    public void displayTable() {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++) {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }
    // hash the key
    public int hashFunc(int key) {
        return key % arraySize;
    }
    // insert method
    public void insert(DataItem aDataItem) {
        int key = aDataItem.getKey();  // extract key
        int hashVal = hashFunc(key);   // calculate index 
        while(hashArray[hashVal] != null)
        {
            ++hashVal;              // go to next cell
            hashVal %= arraySize;   // wraparound if neccessary in case of hasVal exceeding arraySize
        }
        hashArray[hashVal] = aDataItem;
    }
    // find method
    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        while(hashArray[hashVal] != null) {
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;  // for raparround condition
        }    
        return null;        
    }
}

class hash {
    public static void main(String args[]) {
        DataItem aDataItem;   // a new dataitem reference 
        int size=0, aKey, keysPerCell=10, n=0;
        System.out.print("Enter size of hash table");
        size = getInt();
        System.out.print("How many values you want to enter: ");
        n = getInt();
        HashTable theHashTable = new HashTable(size);
        // enter random values 
        for(int i=0; i<n; i++) {
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new DataItem(aKey);
            // insert into hashtable
            theHashTable.insert(aDataItem);
        }
        // write show, insert, delete, find
        while(true) {
            System.out.println("Enter first letter of: ");
            System.out.println("show, insert, delete or find: ");
            char ch = getChar();
            switch(ch) {
                case 's': 
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem); 
                    break;    
                case 'd':
                    break;
                case 'f':
                    System.out.print("Enter Key value to find in hash: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null) 
                        System.out.print("Match found");
                    else
                        System.out.print("Match not found");
                    break;
                default:
                    System.out.print("Invalid Entry"); 
            }
        }
    }
    public static String getString() {
        InputStreamReader isr = new InputStreamReader(System.in);  // InputStreamReader Object
        BufferedReader br = new BufferedReader(isr);               // BufferedReader Object
        try {
            String s = br.readLine();       
            return s;
        } catch(IOException ex) {}
        return null;
    }
    public static char getChar() {
        String s = getString();
        return s.charAt(0);  // returns the first char of string
    }
    public static int getInt() {
        String s = getString();
        return Integer.parseInt(s);
    }
}

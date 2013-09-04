// Magic square puzzle such that the square made
// has sum of all the sides and diagonals 
// according to (n(n^2 + 1))/2 
// for 3 sides sum would be 15

public class magicsquare {
    static int size = 3;  // size of the magic square
    // by default Math.pow returns a double typecasting to int
    static int sum = (size * ((int)Math.pow(size, 2) + 1))/2;

    public static void main(String[] args) {
        int mat[][] = new int[size][size];        // magic square 
        int used_numbers[] = new int[size*size];  // numbers entered in magic sqare
        
            
        // display magic square 
        display(mat);
    
    }

    static void display(int mat[][]) {
        for(int i=0; i<3; i++){
            System.out.println();
            for(int j=0; j<3; j++)
               System.out.print(" " + mat[i][j]); 
        }
        System.out.println();
    }
}

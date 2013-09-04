// Sprial matrix is program that prints a given matrix in 
// spiral order(asked in amazon interview)
// Given a matrix
// 1  2  3  4 
// 5  6  7  8 
// 9  10 11 12
// 13 14 15 16
//
// Output :- 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10

import java.io.*;

class spiralmatrix {
    static int[][] mat = new int[10][10];    // initialized the matrix

    public static void main(String[] args) {
        int rows, cols,num=1;
        mat[3][3] = 16;
        System.out.print("Enter the number of rows of matrix: ");
        rows = getInt();
        System.out.print("Enter the number of columns of matrix: ");
        cols = getInt();
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                mat[i][j]=num++;
        
        // calling the spiralprint recursively for inner matrixes
        System.out.println("  1. Outer to inner matrix");
        System.out.println("  2. Inner to outer matrix");
        System.out.print("  Enter your choice: ");
        int choice = getInt();
        switch(choice) {
            case 1: 
                spiralPrint1(0, 0, rows, cols);
                break;
            case 2: 
                spiralPrint2(0, 0, rows, cols);  
                break;
                
        }
        

        System.out.println("\n\t\t\tHappy Coding!!!");
    }

    public static void spiralPrint1(int x, int y, int row, int col) {
        if(row<1)
            return;
        else {
            showOuterMatrix(x, y, row, col); // for outer to inner
            spiralPrint1(x+1, y+1, row-2, col-2);
        }
    }
    
    public static void spiralPrint2(int x, int y, int row, int col) {
        if(row<1)
            return;
        else {
            spiralPrint2(x+1, y+1, row-2, col-2);
            showOuterMatrix(x, y, row, col); // for outer to inner
        }
    }

    public static int getInt() {
        String str=null;
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        try { 
            str = br.readLine();
        } catch(Exception ex) { System.out.print("Readline() failed"); }
        return Integer.parseInt(str);
    }

    // shows outer layer of a matrix
    public static void showOuterMatrix(int x, int y, int row, int col) {
        // print row to right
        for(int i=0; i<col; i++) 
            System.out.print(" " + mat[x][y+i]); 
        // print col downwards
        for(int i=1; i<row; i++)
            System.out.print(" " + mat[x+i][y+col-1]);
            // System.out.print(" " + mat[x+i][col-1]);
        // print row to left
        for(int i=1; i<col; i++)
            System.out.print(" " + mat[x+row-1][y+col-i-1]);
        // print col upwards
        for(int i=1; i<row-1; i++)
            System.out.print(" " + mat[x+row-i-1][y]);
    }
}

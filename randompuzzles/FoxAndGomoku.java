// fox and gomoku problem


public class FoxAndGomoku {
    public static void main(String[] args) {
        String[] board = {"..........",
             "..........",
              "..oooo.o..",
               "..o.......",
                "..o.......",
                 "..o.oooo..",
                  ".......o..",
                   ".......o..",
                    "..oooo.o..",
                     ".........."};
                        
        String s = win(board);
        System.out.println(s);
    }

    public static String win(String[] board) {
        int size =board[0].length();
        char[][] mat= new char[size][size]; 
        for(int i=0; i< size; i++) {
            for(int j=0; j<size; j++) {
                mat[i][j] = board[i].charAt(j);
            }
        }
        
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(size-j >= 5) {
                    // System.out.println("called for horizontal");
                    boolean hor = horizontal(mat, i, j);
                    if(hor == true)
                        return "Found";
                }
                if(size-i >= 5) {
                    // System.out.println("called for vertical");
                    boolean vert = vertical(mat, i, j);
                    if(vert == true)
                        return "Found";
                }
                if(size-i >= 5 && size-j >= 5) {
                    // System.out.println("called for diagonal");
                    boolean diag = diagonal(mat, i, j);
                    if(diag == true)
                        return "found";
                }    
            }
        }
        return "Not Found";
    }

    public static boolean horizontal(char mat[][],int i, int j) {
        for(int k=j; k<j+5; k++) {
            // System.out.println("testing for horizontal i= " + i + "j= " + k);
            if(mat[i][k] != 'o')  
                return false;
        }
        return true;
    }
    public static boolean vertical(char mat[][], int i, int j) {
        for(int k=i; k<i+5; k++) {
            // System.out.println("testing for vertical i= " + k + "j= " + j);
            if(mat[k][j] != 'o') 
                return false;
        }
        return true;
    }

    public static boolean diagonal(char mat[][], int i,int j) {
        for(int k=i,l=j; k<i+5&&l<j+5; k++,l++ ) {
            // System.out.println("testing for diagonal i =" + k + " j=" + l);
            if(mat[k][l]!='o')
                return false;
        }
        return true;
    }
}

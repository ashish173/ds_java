// Fox and Go Problem 
// returns the maximum kill by placing one black piece.
// component is the collection of simillar pieces that share an edge. 
// all components are processed seperately

class FoxAndGo {
    
    static String[] board = {"ooooo",
         "xxxxo",
          "xxxx.",
           "xxxx.",
            "ooooo"};

    static int size = board.length, blanks;
    static int[][] visited = new int[size][size];

    public static void main(String args[]) {
        int maxKill = maxKill(board);
        System.out.println(maxKill);
    }
    
    public static int maxKill(String[] board) {
        char[][] boardMat = new char[size][size];
        // find all the contexts that have atleast one empty cell
        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                boardMat[i][j] = board[i].charAt(j);
        int contextsFound = context(boardMat);
        return contextsFound;     // returns the max kill;
    }

    public static int context(char[][] boardMat) {
        // int[][] contextsFound = new int[size][2];
        int maxKillVal = 0, numOfWhiteCells=0;
        int k=0,l=0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                //Arrays.fill(visited, 0); // intilizing visited array to '0'
                for(int m=0; m<size; m++)
                    for(int n=0; n<size; n++)
                        visited[m][n]=0;
                numOfWhiteCells=0;  // for different context
                if(boardMat[i][j]=='o') {
                    // System.out.println("calling for i = "+ i + " j = "+j);
                    blanks = 0;
                    numOfWhiteCells = findContextOfCell(boardMat, i, j, 1);
                    // System.out.println("Number of white cells " + numOfWhiteCells);
                    if(maxKillVal < numOfWhiteCells &&( blanks==1 || blanks==0 ))
                        maxKillVal = numOfWhiteCells;
                }
            }
        }
        return maxKillVal; 
    }
    // recursive function that finds the number of empty cells starting from (i, j) forming a COMPONENT
    public static int findContextOfCell(char[][] Mat, int i, int j, int sum) {
        if(i < 0 || i >= size || j < 0 || j >= size || Mat[i][j]=='x') { 
            System.out.println("returning from i="+i+" j="+j);
            return 0;
        }
        else if(Mat[i][j] == '.') {
            System.out.println("returning from i="+i+" j="+j);
            blanks++;
            return 0;
        }
        else if(visited[i][j]!=1){
            if(Mat[i][j]=='o')
                visited[i][j]=1;
            System.out.println("calling for i="+i+" j="+j);
            return sum += findContextOfCell(Mat, i+1, j, sum) + findContextOfCell(Mat, i, j+1, sum) + findContextOfCell(Mat, i, j-1, sum) + findContextOfCell(Mat, i-1, j, sum);
        }
        return 0;
    }
}

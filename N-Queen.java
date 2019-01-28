import java.util.*;

public class Main {
    static class Position{
        int row;
        int col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static Position pos[];
    public Main(int n){
        pos = new Position[n];
    }
    public static void main(String[] args) {
        int n = 8;
        Main m = new  Main(n);
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, pos);
        if(hasSolution){
            for(int i = 0 ;i < n; i++){
                //System.out.println(pos[i].row + "-" + pos[i].col);
                for (int j = 0; j < n; j++){
                    if (pos[i].row == i && pos[i].col == j)
                        System.out.print('Q');
                    else
                        System.out.print('.');
                }
                System.out.println();
            }
        }else{
            System.out.println("No solution found");
        }
    }

    private static boolean solveNQueenOneSolutionUtil(int n, int row, Position[] pos) {
        if (n == row)
            return true;
        for (int col = 0 ; col < n; col++){
            boolean safe = true;
            //checking
            for (int queen = 0; queen < row; queen++){
                if (pos[queen].col == col ||
                        pos[queen].row + pos[queen].col == row + col ||
                        pos[queen].row - pos[queen].col == row - col) {
                    safe = false;
                    break;
                }
            }
            if (safe){
                pos[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row+1, pos)){
                    return true;
                }
            }
        }
        return false;
    }
}

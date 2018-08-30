import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class kot {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Print {
        private BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(out));
        }


        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }


        public void close() throws IOException {
            bw.close();
        }

    }
    static int matrix[][];
    static boolean visited[][];
    static int row;
    static int column;
    public kot(int n,int m){
        row = n;
        column = m;
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        matrix = new int[11][11];
        visited = new boolean[11][11];
        for (int i = 0 ; i < 11; i++)
            for (int j = 0 ;j < 11; j++)
                visited[i][j] = false;
        int n = fr.nextInt();
        int m = fr.nextInt();
        kot k = new kot(n,m);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                matrix[i][j] = fr.nextInt();
            }
        }
        if (dfs(1,1, n, m))
            print.println("Yes");
        else
            print.println("No");

        print.close();
    }
    public static boolean dfs(int x, int y,
                           int des_x, int des_y){
        if ((x == des_x) && (y == des_y))
            return true;
        if (x > row || y > column)
            return false;
        if (x < 0 || y < 0)
            return false;
        if (visited[x][y]==true)
            return false;
        visited[x][y] = true;
        if (matrix[x][y] == 0)
            return false;

        if (dfs(x+1, y, des_x, des_y) == true)
            return true;
        if (dfs(x, y+1,des_x, des_y) == true)
            return true;
        if (dfs(x-1, y, des_x, des_y)== true)
            return true;
        if (dfs(x, y-1, des_x, des_y) == true)
            return true;
        return false;
    }

}


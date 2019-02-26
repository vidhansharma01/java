import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Main {
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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        String s = "ababbbabbababa";
        int cut = partition(s);
        System.out.println(cut);
        print.close();
    }
    public static int partition(String s){
        int n = s.length();
        int C[] = new int[n];
        boolean P[][] = new boolean[n][n];
        int i, j, k, L;
        for (i = 0; i < n; i++){
            P[i][i] = true;
        }
        for (L = 2; L <= n; L++){
            for (i = 0; i < n - L + 1; i++){
                j = i + L - 1;
                if(L == 2)
                    P[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    P[i][j] = (s.charAt(i) == s.charAt(j))
                            && P[i+1][j-1];
            }
        }
        for (i = 0 ;i < n; i++){
            if(P[0][i] == true){
                C[i] = 0;
            }else{
                C[i] = Integer.MAX_VALUE;
                for (j = 0; j < i; j++){
                    if (P[j+1][i] == true &&
                            ( 1 + C[j] < C[i] ) )
                        C[i] = 1 + C[j];
                }
            }
        }
        return C[n-1];
    }
}
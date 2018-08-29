import java.io.*;
import java.util.*;

import static java.lang.System.out;

class kot {

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
    static int INF = 100000;
    static int V = 4;
    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int graph[][] = {
            {0, 3, 6, 15},
            {INF, 0, -2, INF},
            {INF, INF, 0, 2},
            {1, INF, INF, 0}
        };
        floydWarshall(graph);

        print.close();
    }
    public static void floydWarshall(int graph[][]){
        int distance[][] = new int[V][V];
        for(int i = 0 ; i < V; i++)
            for (int j = 0 ; j < V; j++)
                distance[i][j] = graph[i][j];

        for (int k = 0; k < V; k++){
            for (int i = 0 ; i < V; i++){
                for (int j = 0; j < V; j++){
                    if (distance[i][j] > distance[i][k]+distance[k][j])
                        distance[i][j] = distance[i][k]+distance[k][j];
                }
            }
        }
        for (int i = 0; i < V; i++){
            for (int j = 0 ; j < V; j++){
                if (distance[i][j] == INF)
                    System.out.print("INF" + "   ");
                else
                    System.out.print(distance[i][j] + "  ");
            }
            System.out.println();
        }
    }

}


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
    static int V;
    static int E;
    static Edge edge[];

    public kot(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
    }
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        kot k = new kot(V, E);
        for(int i = 0; i < E; i++)
            edge[i] = new Edge(fr.nextInt(), fr.nextInt(), fr.nextInt());
        int src = 0;
        bellmanFord(src);

        print.close();
    }
    public static void bellmanFord(int src){
        int distance[] = new int[V];
        for (int i = 0 ;i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;
        for (int i = 1; i < V; i++){
            for (int j = 0; j < E; j++){
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (distance[v] > distance[u] + weight &&
                        distance[u]!= Integer.MAX_VALUE)
                    distance[v] = distance[u] + weight;
            }
        }
        //if there is negative-cycle...
        for (int j = 0; j < E; j++){
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (distance[v] > distance[u] + weight &&
                    distance[u] != Integer.MAX_VALUE)
                System.out.println("Graph contains negative weight-cycle");
        }
        //printing shortest path
        for (int i = 0 ; i < V; i++){
            System.out.println(i + " " + distance[i]);
        }
    }

}


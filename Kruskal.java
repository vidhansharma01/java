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
    static int MAX = (int)1e4+5;
    static int id[] = new int[MAX];
    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int w;
        public Edge(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    static int V;
    static int E;
    static Edge result[];
    public kot(int v, int e){
        V = v;
        E = e;
        result = new Edge[E];
    }
    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        initialise();
        int V = fr.nextInt();
        int E = fr.nextInt();
        kot k  = new kot(V, E);
       // Edge result[] = new Edge[E];
        for (int i = 0; i < E; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            int w = fr.nextInt();
            result[i] = new Edge(x, y , w);
        }
        Arrays.sort(result);
        long min_cost = kruskal();
        print.println(min_cost);

        print.close();
    }
    public static void initialise(){
        for (int i = 0 ;i < MAX; i++){
            id[i] = i;
        }
    }
    public static int root(int x){
        while (id[x] != x){
            x = id[x];
        }
        return x;
    }
    public static void union(int x, int y){
        int root_x = root(x);
        int root_y = root(y);
        id[root_x] = id[root_y];
    }
    public static long kruskal(){
        long mincost = 0;
        for (int i = 0; i < E; i++){
            int x = result[i].x;
            int y = result[i].y;
            int cost = result[i].w;
            if (root(x)!=root(y)){
                mincost += cost;
                System.out.println(x + " " + y);
                union(x,y);
            }
        }
        return mincost;
    }

}


import java.io.*;
import java.util.*;

import static java.lang.System.out;
class Shellsort {
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
    static ArrayList<Integer> adj[];
    static int NIL = -1;
    static int V;
    static int E;
    public Shellsort(int v, int e){
        V = v;
        E = e;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
        visited = new boolean[V];
        dis = new int[V];
        low = new int[V];
        parent = new int[V];
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        Shellsort s = new Shellsort(V, E);
        for (int i =  0 ; i < E; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        bridge();

        print.close();
    }
    static boolean visited[];
    static int dis[];
    static int low[];
    static int parent[];
    static int time;
    public static void bridge(){
        for (int i = 0 ; i < V; i++){
            parent[i] = NIL;
            visited[i] = false;
        }
         for (int i = 0 ;i < V; i++){
            if (visited[i]==false){
                dfs(i);
            }
        }
    }
    public static void dfs(int u){
        visited[u] = true;
        dis[u]=low[u]=time++;
        for (int i = 0; i < adj[u].size(); i++){
            int v = adj[u].get(i);
            if (visited[v]==false){
                parent[v] = u;
                dfs(v);

                low[u] = Math.min(low[u], low[v]);
                if (low[v]>dis[u])
                    System.out.println(u + " " + v);
            }else if (v != parent[u])
                low[u] = Math.min(low[u], dis[v]);
        }
    }
}




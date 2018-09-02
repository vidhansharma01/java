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

    static ArrayList<Integer> adj[];

    static int V;
    static int E;
    public kot(int v, int e){
        V = v;
        E = e;
        adj = new ArrayList[V];
        for (int i = 0 ;  i < V; i++)
            adj[i] = new ArrayList<>();
        visited = new boolean[V];
        dis = new int[V];
        low = new int[V];
        parent = new int[V];
        AP = new boolean[V];
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        kot k = new kot(V,E);
        for (int i = 0; i < E; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        ap();
        print.close();
    }
    static boolean visited[];
    static int dis[];
    static int low[];
    static int parent[];
    static boolean AP[];
    static int time = 0;
    public static void ap(){
        for (int i = 0 ;i < V; i++){
            parent[i] = -1;
            visited[i] = false;
            AP[i] = false;
        }
        dfs(0); // node
        for (int i = 0 ; i < V; i++)
            if (AP[i]==true)
                System.out.println(i+ " ");

    }
    public static void dfs(int u){
        visited[u] = true;
        low[u]=dis[u]= time++;
        int child = 0;
        for (int i = 0 ;i < adj[u].size(); i++){
            int v = adj[u].get(i);
            if (visited[v] == false){
                child++;
                parent[v] = u;
                dfs(v);

                low[u] = Math.min(low[v], low[u]);
                if (parent[u] != -1 && low[v]>= dis[u])
                    AP[u] = true;
                if (parent[u]== -1 && child > 1)
                    AP[u] = true;
            }else if(v != parent[u]){
                low[u] = Math.min(low[u], dis[v]);
            }
        }
    }
}
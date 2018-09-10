import java.io.*;
import java.util.*;

import static java.lang.System.out;
class Example {
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
    static ArrayList<Integer> adj[];
    static ArrayList<Integer> adj_rev[];
    public Example(int v, int e){
        V = v;
        E = e;
        adj = new ArrayList[V];
        adj_rev = new ArrayList[V];
        for (int i = 0 ; i < V; i++) {
            adj[i] = new ArrayList<>();
            adj_rev[i] = new ArrayList<>();
        }
        visited = new boolean[V];
        for (int  i=  0 ; i < V ;i++)
            visited[i] = false;
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        Example s = new Example(V, E);
        for (int i = 0  ; i  <E; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
        }
        scc();

        print.close();
    }
    static Stack<Integer> stack = new Stack<>();
    static boolean visited[];

    public static void scc(){
        for (int i =  0 ; i < V; i++){
            if (visited[i] == false)
                fillOrder(i);
        }
        //create a reversed graph
        reverse();
        //fill all vertices false again...
        for (int  i=  0 ; i < V ;i++)
            visited[i] = false;
        while (!stack.isEmpty()){
            int v = stack.pop();
            if (visited[v] == false){
                dfs(v);
                System.out.println();
            }
        }
    }
    public static void dfs(int u){
        visited[u] = true;
        System.out.print(u + " ");
        for (int i = 0 ; i < adj_rev[u].size(); i++){
            int v = adj_rev[u].get(i);
            if (visited[v]==false)
                dfs(v);
        }
    }
    public static void fillOrder(int u){
        visited[u] = true;
        for (int i = 0  ; i < adj[u].size(); i++){
            int v = adj[u].get(i);
            if (visited[v]==false)
                fillOrder(v);
        }
        stack.push(u);
    }
    public static void reverse(){
        for (int i =  0 ; i < V; i++){
            for (int j = 0 ; j < adj[i].size(); j++){
                int v = adj[i].get(j);
                adj_rev[v].add(i);
            }
        }
    }
}

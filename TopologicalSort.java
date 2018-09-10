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
    public Example(int v, int e){
        V = v;
        E = e;
        adj = new ArrayList[V];
        for (int i = 0 ; i < V; i++)
            adj[i] = new ArrayList<>();
        visited = new boolean[V];
        for (int i = 0 ; i < V; i++)
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
        topo_sort();
        print.close();
    }
    static Stack<Integer> stack = new Stack<>();
    static boolean visited[];
    public static void topo_sort(){
        for (int i =  0 ; i <V; i++){
            if (visited[i] == false)
                dfs(i);
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop()+ " ");
    }
    public static void dfs(int u){
        visited[u] = true;
        for (int i = 0 ; i < adj[u].size() ; i++){
            int v = adj[u].get(i);
            if (visited[v] == false)
                dfs(v);
        }
        stack.push(u);
    }
}

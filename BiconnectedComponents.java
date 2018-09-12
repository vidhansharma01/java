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
    static class Edge{
        int u;
        int v;
        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }

    static ArrayList<Integer> adj[];
    static int V;
    static int E;

    public kot(int v, int e) {
        V = v;
        E = e;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();
        dis = new int[V];
        low = new int[V];
        parent = new int[V];
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        kot k = new kot(V, E);
        for (int i = 0; i < E; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        bcc();
        print.close();
    }
    static int dis[];
    static int low[];
    static int parent[];
    static LinkedList<Edge> list = new LinkedList<>();
    public static void bcc(){
        for (int i = 0 ; i  < V; i++){
            dis[i] = -1;
            low[i] = -1;
            parent[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (dis[i] == -1)
                dfs(i);

            int j = 0;
            while (!list.isEmpty()) {
                j = 1;
                System.out.print(list.getLast().u + "--" + list.getLast().v
                        + " ");
                list.removeLast();
            }
            if (j == 1) {
                System.out.println();
                count++;
            }
        }

    }
    static int time;
    static int count;
    public static void dfs(int u){
        dis[u] = low[u] = ++time;
        int child = 0;
        for (int i = 0; i < adj[u].size(); i++){
            int v = adj[u].get(i);
            if (dis[v] == -1){
                child++;
                parent[v] = u;
                list.add(new Edge(u, v));
                dfs(v);

                low[u] = Math.min(low[v], low[u]);
                if (low[v] >= dis[u]){
                    while (list.getLast().u != u ||
                            list.getLast().v != v ){
                        System.out.print(list.getLast().u + "--" +
                        list.getLast().v + " ");
                        list.removeLast();
                    }
                    System.out.println(list.getLast().u + "--" +
                            list.getLast().v + " ");
                    list.removeLast();
                    count++;
                }
            }else if (v != parent[u] && dis[v] < low[u]){
                low[u] = dis[v];
                list.add(new Edge(u, v));
            }
        }
    }
}

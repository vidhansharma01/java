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
    static int V;
    static int E;
    static List<Edge> adj[];
    static boolean marked[] = new boolean[MAX];
    public kot(int v, int e){
        V = v;
        E = e;
        adj = new ArrayList[V+1];
    }
    static class Edge{
        int w;
        int y;
        public Edge(int w, int y){
            this.w = w;
            this.y = y;
        }
    }
    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        kot k = new kot(V, E);
        for (int i = 0 ; i< V+1; i++){
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(marked, false);
        for (int i = 0 ; i < E; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            int w = fr.nextInt();
            adj[x].add(new Edge(w,y));
            adj[y].add(new Edge(w,x));
        }
        long min_cost = prims(0);
        print.println(min_cost);
        print.close();
    }
    public static long prims(int x){
        Comparator<Edge> com = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if (o1.w >= o2.w)
                    return 1;
                else
                    return -1;
            }
        };
        PriorityQueue<Edge> pq = new PriorityQueue<>(com);
        long min_cost = 0;
        pq.add(new Edge(0, x));
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            x = edge.y;
            if (marked[x] == true)
                continue;
            min_cost += edge.w;
            marked[x] = true;
            for (int i = 0; i < adj[x].size(); i++){
                int y = adj[x].get(i).y;
                if (marked[y] == false)
                    pq.add(adj[x].get(i));
            }
        }
        return min_cost;
    }


}


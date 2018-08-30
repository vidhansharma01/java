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
        long to;
        long w;
        public Edge(long to, long w){
            this.to = to;
            this.w = w;
        }
    }
    static class Vertex implements Comparable<Vertex>{
        long index;
        long w;
        @Override
        public int compareTo(Vertex o) {
            if (w > o.w)
                return 1;
            if (w < o.w)
                return -1;
            return 0;
        }
        public Vertex(long index, long w){
            this.index = index;
            this.w = w;
        }
    }
    static ArrayList<Edge> graph[];
    static int V;
    static int E;
    public kot(int v, int e){
        V = v;
        E = e;
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        kot k = new kot(V,E);
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++){
            int a = fr.nextInt() - 1;
            int b = fr.nextInt() - 1;
            long w = fr.nextLong();
            graph[a].add(new Edge(b,w));
            graph[b].add(new Edge(a,w));
        }
        dijkstra(0);
        if (depth[V-1]==Long.MAX_VALUE){
            print.println(-1);
        }else{
            ArrayList<Long> route = new ArrayList<>();
            long from = V-1;
            while(from!=-1){
                route.add(from);
                from = path[(int)from];
            }
            for (int i = route.size()-1; i >= 0; i--)
                print.print((route.get(i)+1) + " ");
            print.println("");
            for (int i = 0; i < V; i++)
               print.print(depth[i]+ " ");
        }


        print.close();
    }
    static long depth[];
    static long path[];

    public static void dijkstra(int init){
        depth = new long[V];
        path = new long[V];
        Arrays.fill(path, -1);
        Arrays.fill(depth, Long.MAX_VALUE);
        depth[init] = 0;
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(init, 0));
        while (pq.size()!=0){
            Vertex v = pq.poll();
            if (depth[(int)v.index] != v.w)
                continue;
            int from = (int)v.index;
            for (Edge edge: graph[from]){
                if (depth[(int)edge.to] > depth[from]+ edge.w){
                    depth[(int)edge.to] = depth[from] + edge.w;
                    pq.add(new Vertex(edge.to, depth[(int)edge.to]));
                    path[(int)edge.to] = from;
                }
            }
        }
    }

}


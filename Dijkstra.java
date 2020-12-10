    import java.util.*;
    import java.io.*;
    public class Codeforces {
        public static void main(String args[]){
            InputReader in = new InputReader();
            PrintWriter out = new PrintWriter(System.out);
            Task solver = new Task();
            solver.solve(1, in, out);
            out.close();
        }
        static class Edge implements Comparable<Edge>{
            int y;
            long w;
            public Edge(int y, long w){
                this.y = y;
                this.w = w;
            }
     
            @Override
            public int compareTo(Edge o) {
                if (w != o.w)
                    return w > o.w ? 1 : -1;
                return 0;
            }
        }
        static class Task{
            int V, E;
            List<Edge> adj[];
            long dis[];
            int parent[];
            public void solve(int testNumber, InputReader in, PrintWriter out){
                V = in.nextInt();
                E = in.nextInt();
                adj = new ArrayList[V];
                for(int i = 0; i < V; ++i)
                    adj[i] = new ArrayList<>();
                for(int i = 0; i < E; ++i){
                    int u = in.nextInt() - 1;
                    int v = in.nextInt() - 1;
                    int w = in.nextInt();
                    adj[u].add(new Edge(v, w));
                    adj[v].add(new Edge(u, w));
                }
                int res[] = dijkstra(0, V-1);
                if (res == null){
                    out.println(-1);
                }else {
                    Stack<Integer> stack = new Stack<Integer>();
                    int node = V - 1;
                    while(node != -1)
                    {
                        stack.push(node);
                        node = res[node];
                    }
                    while(!stack.isEmpty())
                        out.print(stack.pop() + 1 + " ");
                }
                out.flush();
                out.close();
            }
            public int[] dijkstra(int S, int T){
                dis = new long[V];
                parent = new int[V];
                long INF = (long)1e16;
                Arrays.fill(dis, INF);
                Arrays.fill(parent, -1);
                dis[S] = 0;
                PriorityQueue<Edge> pq = new PriorityQueue<>();
                pq.add(new Edge(S, 0));
                while (!pq.isEmpty()){
                    Edge cur = pq.remove();
                    if (cur.y == T)
                        return parent;
                    for (Edge next : adj[cur.y]){
                        if (next.w + cur.w < dis[next.y]){
                            dis[next.y] = next.w + cur.w;
                            pq.add(new Edge(next.y, dis[next.y]));
                            parent[next.y] = cur.y;
                        }
                    }
                }
                return null;
            }
        }
        static class InputReader {
            BufferedReader br;
            StringTokenizer st;
     
            public InputReader() {
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
    }

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
    static ArrayList<Integer> adj[];

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int S = fr.nextInt();
        int N = fr.nextInt();
        int E = fr.nextInt();
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        dis = new int[N+1];
        for (int i = 0 ; i< N+1; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0 ;i < E; i++){
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        bfs(N);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= S; i++){
            if (dis[i] > max)
                max = dis[i];
        }
        int c = 0;
        for (int i = 1; i <= S; i++){
            if (dis[i] == max)
                c++;
        }
        print.println(c);
        print.close();
    }
    static boolean visited[];
    static int dis[];
    public static void bfs(int n){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        while (!queue.isEmpty()){
            int f = queue.poll();
            for (int i = 0; i < adj[f].size(); i++){
                int x = adj[f].get(i);
                if (!visited[x]){
                    visited[x] = true;
                    queue.add(x);
                    dis[x] = dis[f] + 1;
                }
            }
        }
    }

}


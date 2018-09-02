import java.io.*;
import java.util.*;

//import static java.lang.System.out;
public class Recursion {
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
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
    static int v;
    static ArrayList<Integer> adj[];
    static int level[];
    static boolean visited[];

    public Recursion(int v){
        this.v = v;
        level = new int[v];
        visited = new boolean[v];
        adj = new ArrayList[v];
        for (int i = 0; i< v; i++)
            adj[i] = new ArrayList<>();
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        int N = fr.nextInt(); //nodes
        int M = fr.nextInt();  //edges
        Recursion r = new Recursion(N+1);
        while(M-->0){
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        int head = fr.nextInt();
        dfs(head);
        print.println(N-c);

        print.close();
    }
    static int c =0;
    public static void dfs(int head){
        visited[head] = true;
        c++;
        for (int i = 0; i < adj[head].size(); i++){
            int q = adj[head].get(i);
            if (visited[q]== false){
                dfs(q);
            }
        }
    }

}
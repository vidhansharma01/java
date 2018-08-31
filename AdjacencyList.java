import java.util.*;
import java.lang.*;
import java.io.*;
import static java.lang.System.out;

class Codechef
{
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
    
	public static void main (String[] args) throws java.lang.Exception
	{
        FastReader fr = new FastReader();
        Print print = new Print();
        int V = fr.nextInt();
        int E = fr.nextInt();
        adj = new ArrayList[V+1];
        for(int i = 0 ; i< V+1; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0;i < E ;i++ ){
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
        }
        for(int i = 1; i <= V; i++){
            System.out.print("nodes of "+ i + ":");
            for(int j = 0; j < adj[i].size(); j++){
                if(j == adj[i].size()-1)
                    System.out.println(adj[i].get(j));
                else
                    System.out.print(adj[i].get(j) + " ");
            }            
        }
	}
}

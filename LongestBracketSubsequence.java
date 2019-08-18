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
    static int mod = (int)1e9+7;
    static class Node{
        int pairs;
        int open;
        int close;
        Node(){
            pairs = open = close = 0;
        }
    }
    static class Task{
        Node segment[];
        String s;
        public void solve(int testNumber, InputReader in, PrintWriter out){
            s = in.nextLine();
            int n = s.length();
            segment = new Node[4*n];
            for (int i = 0; i < 4*n; i++)
                segment[i] = new Node();
            build(0, n-1, 0);
            int m = in.nextInt();
            while (m-->0){
                int l = in.nextInt()-1;
                int r = in.nextInt()-1;
                Node val = query(l, r, 0, n-1, 0);
                out.println(2*val.pairs);
            }
        }

        private Node query(int l, int r, int low, int high, int pos) {
            if (l > high || r < low){
                return new Node();
            }
            if (l <= low && r >= high)
                return segment[pos];
            int mid = (low+high)/2;
            Node left = query(l, r, low, mid, 2*pos+1);
            Node right = query(l, r, mid+1, high, 2*pos+2);
            Node res = merge(left, right);
            return res;
        }
        private void build(int low, int high, int pos) {
            if (low == high){
                segment[pos].pairs = 0;
                segment[pos].open = s.charAt(low) == '(' ? 1 : 0;
                segment[pos].close = s.charAt(low) == ')' ? 1 : 0;
            }else{
                int mid = (low+high)/2;
                build(low, mid, 2*pos+1);
                build(mid+1, high, 2*pos+2);
                segment[pos] = merge(segment[2*pos+1], segment[2*pos+2]);
            }
        }

        private Node merge(Node leftChild, Node rightChild) {
            Node parentNode = new Node();
            int minMatched = Math.min(leftChild.open, rightChild.close);
            parentNode.pairs = leftChild.pairs + rightChild.pairs + minMatched;
            parentNode.open = leftChild.open + rightChild.open - minMatched;
            parentNode.close = leftChild.close + rightChild.close - minMatched;
            return parentNode;
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
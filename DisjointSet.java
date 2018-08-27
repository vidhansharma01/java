import java.io.*;
import java.util.*;

import static java.lang.System.out;

class Harry {

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
    static class Node{
        long data;
        int rank;
        Node parent;
    }
    static Map<Long, Node> map = new HashMap<>();
    public static void makeSet(long data){
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }
    public static void union(long data1, long data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        //if they are part of same set
        if (parent1.data == parent2.data)
            return;
        //rank is higher becomes parent
        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 :
                    parent1.rank;
            parent2.parent = parent1;
        }else{
            parent1.parent = parent2;
        }
    }
    public static long findSet(long data){
        return findSet(map.get(data)).data;
    }
    public static Node findSet(Node node){
        Node parent = node.parent;
        if (parent == node){
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }
    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        makeSet(1);
        makeSet(2);
        makeSet(3);
        makeSet(4);
        makeSet(5);
        makeSet(6);
        makeSet(7);

        union(1,2);
        union(2,3);
        union(4,5);
        union(6,7);
        union(5,6);
        union(3,7);

        print.println(findSet(1));
        print.println(findSet(2));
        print.println(findSet(3));
        print.println(findSet(4));
        print.println(findSet(5));
        print.println(findSet(6));
        print.println(findSet(7));


        print.close();
    }
}
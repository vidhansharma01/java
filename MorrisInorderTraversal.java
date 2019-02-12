import java.io.*;
import java.util.*;

import static java.lang.System.out;
class Spam {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
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
    static  class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }

    static Node root;

    public static void insert(int key){
        root = insertRec(root, key);
    }
    public static Node insertRec(Node root, int key){
        if(root==null){
            root = new Node(key);
            return root;
        }
        if(root.key > key) {
            root.left = insertRec(root.left, key);
        }
        else if(root.key < key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public static void main(String args[]) throws IOException {
        FastReader fr = new FastReader();
        Print print = new Print();
        root = null;
        int a[] = {10, 5, 6, 8, -2, 2, -1, 30, 40};
        for(int i = 0; i < a.length; i++){
            insert(a[i]);
        }
        inorder(root);
    }
    public static void inorder(Node root){
        Node current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.key + " ");
                current = current.right;
            }else{
                Node predecessor = current.left;
                while( predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{
                    predecessor.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
                }
            }
        }
    }

}
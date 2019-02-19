import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int maxArea  = m.maxHistogram(new int[]{2,1,2});
        System.out.println(maxArea);
    }
    public int maxHistogram(int input[]){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < input.length; ){
            if (stack.isEmpty() || input[stack.peek()] <= input[i])
                stack.push(i++);
            else{
                int top = stack.pop();
                if (stack.isEmpty())
                    area = input[top]*i;
                else
                    area = input[top]*(i-stack.peek()-1);
                if (area > maxArea)
                    maxArea = area;
            }
        }
        while (!stack.isEmpty()){
            int top = stack.pop();
            if (stack.isEmpty())
                area = input[top]*i;
            else
                area = input[top]*(i-stack.peek()-1);
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
}
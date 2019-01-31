import java.util.*;

public class Main {

    public static void main(String[] args) {
        int a[] = {1, 2};
        int b[] = {3, 4};
        Main m = new Main();
        System.out.println(m.findMedianSortedArrays(a, b));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if(x > y)
            return findMedianSortedArrays(nums2, nums1);

        int l = 0, r = x;
        while(l <= r){
            int partitionX = (l+r)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            //first array
            int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x)? Integer.MAX_VALUE : nums1[partitionX];
            //second array
            int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y)? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x+y)%2 == 0){
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }else{
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                r = partitionX - 1;
            }else{
                l = partitionX + 1;
            }

        }
        throw new IllegalArgumentException("not found");
    }
}

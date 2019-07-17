import java.util.*;
public class TernarySearch {
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int l = 0, r = 9;
        int key = 5;
        int index = ternarySearch(l, r, key, arr);
        System.out.println("Index of " + key + " is " + index);
    }
    public static int ternarySearch(int l, int r, int key, int arr[]){
        while (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;

            if (arr[mid1] == key) {
                return mid1;
            }
            if (arr[mid2] == key) {
                return mid2;
            }
            if (key < arr[mid1]) {
                r = mid1 - 1;
            }
            else if (key > arr[mid2]){
                l = mid2 + 1;
            }
            else {
                l = mid1 + 1;
                r = mid2 - 1;
            }
        }
        return -1;
    }
}

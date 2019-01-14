# quicksort
pivot取 2头 会出现极端情况 

取第一个数 已经排好序 很不均匀

取中间值比较合适,两端数和pivot相等时 也相互交换 就算全是1也会交换一下

这样会比较均匀

也可以取random pivot 但是会有一定时间耗费
```
import java.util.Random;

public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    public Random rand;
    public void sortIntegers2(int[] A) {
        rand = new Random();
        // write your code here
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = rand.nextInt(end - start + 1)  + start;
        int pivot = A[index];
        int left = start;
        int right = end;
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left ++;
            }
            while (left <= right && A[right] > pivot) {
                right --;
            }
            
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                
                left ++;
                right --;
            }
        }
        // A[start... right] 
        quickSort(A, start, right);
        // A[left ... end]
        quickSort(A, left, end);
    }
}
```

# QuickSelect


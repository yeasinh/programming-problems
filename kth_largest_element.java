import java.util.*;

public class KLargestElements {

    public static int findKthLargest(int[] nums, int k) {
        // Easy solution:
        /* 
        Arrays.sort(nums);
        return nums[nums.length - k];
        */

        // Hard coded solution using heap:
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        for(int i = 1; i < k; i++) {
            maxHeap.poll();
        }
        
        return maxHeap.peek();
    }

    public static void main(String[] args) {

        int[] array = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int kLargest = findKthLargest(array, k);

        System.out.println("The " + k + "th largest element: " + kLargest);
    }
}

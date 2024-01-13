import java.util.*;

public class MaxSumOfSubarrays {
    public static int findMaxSumOfSubarrays(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;

        for(int i = 0; i < nums.length; i++) {
            // reset when sum becomes negative
            if(currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int maxSum = findMaxSumOfSubarrays(nums);
        System.out.println("Maximum sum of consecutive subarrays: " + maxSum);
    }
}

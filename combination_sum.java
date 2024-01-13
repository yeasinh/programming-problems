import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        
        // Sort array to skip duplicates later
        Arrays.sort(nums);
        backtrack(resultList, currentCombination, nums, target, 0);
        return resultList;
    }
    
    public static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int start) {
        
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                // Skip duplicates
                if(i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                current.add(nums[i]);
                backtrack(result, current, nums, target - nums[i], i);
                current.remove(current.size() - 1);
        }
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        
        List<List<Integer>> combinations = combinationSum(candidates, target);
        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}

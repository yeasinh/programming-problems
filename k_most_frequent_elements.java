import java.util.*;

public class KMostFrequentElements {

    public static List<Integer> kMostFrequent(int[] nums, int k) {
        // Create a frequency map
        Map<Integer, Integer> frequency = new HashMap<>();
        // Each key represents an element 
        // and each value represents its frequency
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // Create a list of buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        // For each frequency, there will be corresponding list of 
        // elements that has that frequency
        for (int key : frequency.keySet()) {
            int freq = frequency.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Extract k most frequent elements from buckets
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        return result.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        List<Integer> result = kMostFrequent(nums, k);
        System.out.println("K most frequent elements: " + result);
    }
}

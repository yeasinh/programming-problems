public class LongestSubstring {

    public static String longestSubstring(String s) {
        int n = s.length();
        boolean[] visited = new boolean[256];

        int maxLength = 0, start = 0, end = 0, left = 0, right = 0;

        while (left < n && right < n) {
            if (!visited[s.charAt(right)]) {
                visited[s.charAt(right)] = true;
                // Increase the window to the next character
                right++;

                // Update the substring
                if (right - left > maxLength) {
                    maxLength = right - left;
                    start = left;
                    end = right;
                }
            } else {
                visited[s.charAt(left)] = false;
                // Restart the window from the next character
                left++;
            }
        }

        // return maxLength;
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String example = "abcabcbb";
        
        // int result = longestSubstring(example);
        // System.out.println("Length of the longest substring: " + result);

        String result = longestSubstring(example);
        System.out.println("Longest substring without repeating characters: " + result);
    }
}

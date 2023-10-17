
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true; // No meetings, so return true
        }

        quickSort(intervals, 0, intervals.length - 1);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // There is an overlap, cannot attend all meetings
            }
        }

        return true; // No overlap, can attend all meetings
    }

    private void quickSort(int[][] intervals, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(intervals, low, high);
            quickSort(intervals, low, pivotIndex - 1);
            quickSort(intervals, pivotIndex + 1, high);
        }
    }

    private int partition(int[][] intervals, int low, int high) {
        int[] pivot = intervals[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (intervals[j][0] < pivot[0]) {
                i++;
                swap(intervals, i, j);
            }
        }

        swap(intervals, i + 1, high);
        return i + 1;
    }

    private void swap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solution.canAttendMeetings(intervals1)); // Output: false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(solution.canAttendMeetings(intervals2)); // Output: true
    }
}


public class Solution {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        int MOD = (int) 1e9 + 7;
        // dp[i][0] stores the number of subarrays until index i that have the same number of 0s and 1s
        // dp[i][1] stores the number of subarrays until index i that have more 1s than 0s
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with 0 difference, count = 1
        int sum = 0; // Sum of 1s and -1s
        int res = 0; // Result

        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1] == 1 ? 1 : -1;
            dp[i][0] = map.getOrDefault(sum, 0);

            if (nums[i - 1] == 1) {
                dp[i][1] = (dp[i - 1][1] + dp[i - 1][0] + 1) % MOD;
            } else {
                dp[i][1] = (dp[i - 1][1] - dp[i][0] + MOD) % MOD;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // Add the count of subarrays with more 1s than 0s to the result
            res = (res + dp[i][1]) % MOD;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {0, 1, 1, 0, 1};
        System.out.println(solution.subarraysWithMoreZerosThanOnes(nums1)); // Output: 9

        int[] nums2 = {0};
        System.out.println(solution.subarraysWithMoreZerosThanOnes(nums2)); // Output: 0

        int[] nums3 = {1};
        System.out.println(solution.subarraysWithMoreZerosThanOnes(nums3)); // Output: 1
    }
}





import java.util.Arrays;

public class ThreeSumProblem {


    /**
     * Approach : Two-Pointers
     * Intuition:
     * The problem is essentially about efficiently finding three numbers in the array
     * whose sum equals the target. A brute-force approach would involve checking
     * all possible triplets, which would be O(n^3) in complexity. To optimize this,
     * we reduce it to O(n^2) by:
     * 1. Sorting the array: Sorting helps in efficiently finding pairs using the two-pointer technique.
     * 2. Fixing one element and then finding the other two: For each element, treat the problem of finding
     * the other two elements as a two-sum problem, where we use two pointers to find the complementary sum.
     * By leveraging sorting and the two-pointer approach, we avoid checking unnecessary combinations,
     * which drastically reduces the computation time.
     *
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public static boolean threeSum(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false;
    }

}

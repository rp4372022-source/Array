public class A38_MaxCircularArrSum{
    static int find(int[] nums){
        if (nums == null || nums.length == 0) return 0;

        int totalSum = 0;
        int currentMax = 0;
        int maxSum = nums[0];
        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's to find maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Inverted Kadane's to find minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative, return the maximum single element
        if (maxSum < 0) {
            return maxSum;
        }

        // Return the better choice between wrapped and non-wrapped solutions
        return Math.max(maxSum, totalSum - minSum);
    }
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println(find(nums));
    }

}

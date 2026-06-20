public class A32_LongestMountain {
    static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int maxLength = 0;
        int n = nums.length;

        // A mountain needs at least 1 element on the left and 1 on the right
        for (int i = 1; i < n - 1; i++) {
            // Identify a valid peak
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand left (downhill to the left)
                while (left > 0 && nums[left] > nums[left - 1]) {
                    left--;
                }

                // Expand right (downhill to the right)
                while (right < n - 1 && nums[right] > nums[right + 1]) {
                    right++;
                }

                // Calculate current mountain length
                int currentLength = right - left + 1;
                maxLength = Math.max(maxLength, currentLength);

                // Move the iterator forward to optimize time complexity
                i = right;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5};
        int[] nums2 = {2, 2, 2, 2};

        System.out.println("Test 1 (Expected 11): " + findMaxLength(nums1));
        System.out.println("Test 2 (Expected 0): " + findMaxLength(nums2));
    }
}

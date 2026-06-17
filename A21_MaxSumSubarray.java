public class A21_MaxSumSubarray {
    //Kadens algo
    static int find(int[] nums){
        int maxSumSoFar = 0;
        int currSum = 0;

        for(int i=0;i<nums.length;i++){
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSumSoFar = Math.max(maxSumSoFar, currSum);
        }

        return maxSumSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(find(nums));
    }
}

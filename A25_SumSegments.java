import java.util.Arrays;

public class A25_SumSegments {
    static int[] findIndex(int[] nums){
        if(nums == null || nums.length <= 2) return new int[]{-1,-1};
        //calc sum
        int sum = 0;
        for(int n:nums) sum += n;

        if(sum % 3 != 0) return new int[]{-1,-1};
        sum /= 3;

        int i = -1, j = -1, k = -1;
        int tempTotal = 0;
        
        for(int a=0;a<nums.length;a++){
            tempTotal += nums[a];
            if(tempTotal == sum){
                if( i == -1){
                    i = a;
                    tempTotal = 0;
                } else if(j == -1){
                    j = a;
                    tempTotal = 0;
                } else if (k == -1 && a == nums.length-1){
                    k = a;
                }
            }
        }
        if( i != -1 && j != -1 && k != -1) return new int[]{i,j};

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        // int[] nums = {1, 3, 4, 0, 4}; // 1, 2
        // int[] nums = {2, 3, 4}; //-1,-1
        // int[] nums = {1, -1, 1, -1, 1, -1, 1, -1};
        // int[] nums = {2, 2, -2, 2, 2};
        // int[] nums = {3, 3, 3, 0};
        // int[] nums = {3, 3, 3, 1, 0, -1};
        // int[] nums = {1, 1, 2, 1, 1};
        int[] nums = {1, 1, 1, 1, -1, 1, 2};
        System.out.println(Arrays.toString(findIndex(nums)));
    }
}

import java.util.Arrays;
public class A33_ArrSortByEq {
    static int[] find(int[] nums,int a,int b,int c){
        if(nums == null || nums.length == 0) return new int[]{};
        
        int[] result = new int[nums.length];

        for(int i=0;i<result.length;i++){
            result[i] = (a * (int) Math.pow(nums[i],2)) + (b * nums[i]) + c;
        }

        Arrays.sort(result);

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 2, 4};
        int a = 1, b = 3, c = 5;
        System.out.println(Arrays.toString(find(nums, a, b, c)));
    }
}

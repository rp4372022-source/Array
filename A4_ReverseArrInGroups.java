import java.util.Arrays;
public class A4_ReverseArrInGroups{
        static int[] reverse(int[] nums,int k){
                if(nums.length < 2 || nums == null || k == 1) return nums;
                //2 pointer approach
                for(int i=0;i<nums.length;i+=k){
                        int left = i, right = Math.min(i+k-1,nums.length-1);//right have huge line bcz of condition in question
                        while(left < right){
                                int temp = nums[left];
                                nums[left] = nums[right];
                                nums[right] = temp;
                                left++; right--;
                        }
                }
                return nums;
        }
        public static void main(String[] args){
                int[] nums = {1,2,3,4,5};
                int k = 3;
                reverse(nums,k);
                System.out.println(Arrays.toString(nums));
        }
}
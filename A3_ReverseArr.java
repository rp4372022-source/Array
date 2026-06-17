import java.util.Arrays;
public class A3_ReverseArr{
        //2 pointer approach
        static int[] reverse(int[] nums){
                if(nums.length < 2 || nums == null) return nums;
                int left=0,right = nums.length-1;
                while(left < right){
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        left++; right--;
                }
                return nums;
        }
        // single pointer approach
        static int[] reverseBySinglePointer(int[] nums){
                if(nums.length < 2 || nums == null) return nums;
                for(int i=0;i<nums.length;i++){
                        int temp = nums[i];
                        nums[i] = nums[nums.length-1-i];
                        nums[nums.length-1-i] = temp;
                }
                return nums;
        }
        public static void main(String[] args){
                int[] nums = {1,2,3,4,5};
                System.out.println(Arrays.toString(reverse(nums)));
        }


static int[] reverse(int[] nums,int start,int end){
        if(nums.length < 2 || nums == null) return nums;
        int left = start,right = end - 1;
        while(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right--;
        }
        return nums;
}

}
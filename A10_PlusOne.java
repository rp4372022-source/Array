public class A10_PlusOne { //not official but get work done
    static int plusOne(int[] nums){
        if(nums == null || nums.length < 2) {
            System.out.println("Insufficient length");
            return -1;
        }
        int carry = 0;
        for(int i=nums.length-1;i>=0;i--){
            if (nums[i] == 9){
                nums[i] = 0;
                carry = 1;
            }
            else if(carry == 1){
                nums[i] += 1;
                carry = 0;
            }
        }

        if (carry == 1){
            System.out.print(1);
        }
        for(int a: nums){
            System.out.print(a);
        }

        return 0;
    }
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9};
        plusOne(nums);
    }
}

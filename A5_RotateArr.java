public class A5_RotateArr {
    private static void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    /*Left Rotate Algorithm To left-rotate an array by (k) places:
        Reverse the first \(k\) elements.   
        Reverse the remaining \(N-k\) elements.
        Reverse the entire array.
    */

    static void rotateLeft(int[] nums,int k){
        k = k % nums.length;
        System.out.println(k);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }


     /*Right Rotate AlgorithmTo right-rotate an array by k places:
        Reverse the entire array.
        Reverse the first k elements.
        Reverse the remaining N-k elements.
    */
    static void rotateRight(int[] nums,int k){
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        rotateRight(nums,2);
        for(int a:nums) System.out.print(a+" ");
    }

static void rotateRight(int[] nums,int k,int start,int end){
    k = k % nums.length;
    reverse(nums,start,end);
    reverse(nums, start, k-1);
    reverse(nums, k, end);
}
}
public class A9_WaveArr { //peak is at even position
    static int arrange(int[] nums){
        if( nums == null|| nums.length < 2 ) {
            System.out.println("Insufficient length");
            return -1;
        }
        for(int i=0;i<nums.length;i+=2){//for traversing to even position only
            if(i > 0 && nums[i] < nums[i-1]){
                swap(nums, i, i-1);
            }
            else if(i < nums.length - 1 && nums[i] < nums[i+1]){
                swap(nums, i, i+1);
            }
        }
        return 0;
    }

    static void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        // int[] nums = null;
        arrange(nums);
        for(int n:nums) System.out.print(n+" ");
    }
}

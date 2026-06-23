public class A34_MinimumSwapTogroup {
    static int find(int[] nums){
        if(nums == null || nums.length < 2) return -1;

        // count the ones
        int onesCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1) onesCount++;
        }

        if(onesCount == 0) return -1;//if no ones in array
        if(onesCount == nums.length-1) return 0;//if all ones no swap

        // create the window
        int start = 0;int end = 0;
        int zerosCount = 0;
        while(end < onesCount){
            if(nums[end] == 0) zerosCount++;
            end++;
        }

        //silde the window
        int swaps = zerosCount;
        while(end < nums.length){
            if(nums[start] == 0) zerosCount--;
            if(nums[end] == 0) zerosCount++;
            swaps = Math.min(swaps,zerosCount);
            start++;
            end++;
        }

        return swaps;
    }
    public static void main(String[] args) {
        // int[] nums = {1,0,1,0,1};
        int[] nums = {1, 1, 0, 1, 0, 1, 1};
        System.out.println(find(nums));
    }
}

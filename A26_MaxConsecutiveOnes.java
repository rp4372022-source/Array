public class A26_MaxConsecutiveOnes {
    static int find(int[] nums,int k){
        if(nums == null || nums.length < 1) return -1;
        else if(nums.length == 1 && k!= 0) return 1;

        int oneCntSoFar = 0;
        int onesCurrCnt = 0;
        int start = 0;
        int zCnt = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                onesCurrCnt++; 
            }
            else if(nums[i] == 0){
                zCnt++;
                if(zCnt > k){
                    oneCntSoFar = Math.max(oneCntSoFar,onesCurrCnt);
                    while(zCnt > k){
                        if(nums[start] == 0)zCnt--;
                        start++;
                        onesCurrCnt--;
                    }
                }
                onesCurrCnt++;
            } 
        }

        oneCntSoFar = Math.max(oneCntSoFar, onesCurrCnt);
        return oneCntSoFar;
    }  
    
    //using standard sliding window template
    static int find1(int[] nums,int k){
        if(k == 0 || nums == null || nums.length == 0) return 0;
        else if(nums.length == 1) return 1;

        int left = 0, right = 0, zCnt = 0, maxLen = 0;
        for( right = 0;right<nums.length;right++){
            if(nums[right] == 0) zCnt++;
            while(zCnt > k){
                if(nums[left] == 0) zCnt--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    static int findMaxConsecutiveOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Instead of a 'while' loop, use an 'if' statement
            // If invalid, we don't shrink; we just shift the left pointer by 1
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++; 
            }
        }

        // The maximum window size ever achieved is exactly the final window size
        return nums.length - left;
    }

    public static void main(String[] args) {
        // int[] arr = {1,0,0,1,0,1,1,0,1};
        // int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int[] arr = {1,0,1,0,1,1,0,1,1};
        int k = 2;
        System.out.println(findMaxConsecutiveOnes(arr, k));
    }
}

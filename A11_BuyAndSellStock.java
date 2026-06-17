public class A11_BuyAndSellStock {
    static int calc(int[] nums){
        if(nums == null || nums.length < 2) return 0;

        int minSoFar = nums[0];
        int res = 0;

        for(int i=0;i<nums.length;i++){
            minSoFar = Math.min(minSoFar,nums[i]);
            res = Math.max(res,nums[i]-minSoFar);
        }

        return res;
    }
    public static void main(String[] args) {
        // int[] stock = {5,4,3,2,1};
        int[] stock  = {1,2,3,4,5};
        System.out.println(calc(stock));
    }
}

public class A22_MaxProductSubarray {
    // track min max method
    static int maxProduct(int[] nums){
        int max = 1;
        int min = 1;
        int productSoFar = 1;
        for(int i=0;i<nums.length;i++){
            
            int temp = Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
            
            min = Math.min(nums[i],Math.min(nums[i]*max,nums[i]*min));

            max = temp;

            productSoFar = Math.max(productSoFar,max);
        }

        return productSoFar;
    }
    //track maxproduct left to right & right to left
    static int findMaxProduct(int[] nums){
        int leftToRight = 1, rightToLeft = 1, maxP = 1;

        for(int i=0;i<nums.length;i++){
            if(leftToRight == 0) leftToRight = 1;
            if(rightToLeft == 0) rightToLeft = 1;

            leftToRight *= nums[i];

            rightToLeft *= nums[nums.length-1 - i];

            maxP = Math.max(maxP,Math.max(leftToRight,rightToLeft));
        }

        return maxP;
    }
    public static void main(String[] args) {
        int[] arr = { -2, 6, -3, -10, 0, 2 };
        System.out.println(findMaxProduct(arr));
    }
}

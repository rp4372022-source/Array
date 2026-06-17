import java.util.Arrays;

public class A23_ProductExceptSelf {
    static int[] findPdoduct(int[] nums){
        int[] productArr = new int[nums.length];

        if(nums == null || nums.length < 1) return new int[]{};
        
        if(nums.length == 1) return nums;

        if(nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;

            return nums;
        }

        int right = 1, left = 1;

        //pre calc right
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
            right *= nums[i];
        }

        //calc product with left 
        for(int i=0;i<nums.length;i++){
            right /= nums[i];
            productArr[i] = right*left;
            left *= nums[i];
        }

        return productArr;
    }

    //on same array
    static int[] findPdoduct1(int[] nums){ //optimzed(not fully)
        
        if(nums == null || nums.length < 1) return new int[]{};
        
        if(nums.length == 1) return nums;

        if(nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;

            return nums;
        }

        //count zeros
        int zeroCnt = 0;
        int zeroPosition = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) {
                zeroPosition = i;
                zeroCnt++;
            }
            else if(zeroCnt > 1){
                break;
            }
        }

        //if more than 1 zeros return nums with all zeros
        if(zeroCnt > 1){
            for(int i=0;i<nums.length;i++){
                if(nums[i] !=0) nums[i] = 0;
            }
            return nums;
        } 
        int right = 1, left = 1;
        //pre calc right
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0) right *= nums[i];
        }

        //if only one zero
        if(zeroCnt == 1){
            for(int i=0;i<nums.length;i++){
                if(i == zeroPosition) nums[i] = right;
                else nums[i] = 0;
            }
            return nums;
        }
        //calc product with left 
        if (zeroCnt == 0){
            for(int i=0;i<nums.length;i++){
                int temp = nums[i];
                right /= nums[i];
                nums[i] = right*left;
                left *= temp;
            }
        }
        
        return nums;
    }
    //on same array using only right
    static int[] findPdoduct2(int[] nums){ //optimzed 
        
        if(nums == null || nums.length < 1) return new int[]{};
        
        if(nums.length == 1) return nums;

        if(nums.length == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;

            return nums;
        }

        //count zeros
        int zeroCnt = 0;
        int zeroPosition = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) {
                zeroPosition = i;
                zeroCnt++;
                if(zeroCnt > 1){
                    break;
                }
            }
            
        }

        //if more than 1 zeros return nums with all zeros
        if(zeroCnt > 1){
            for(int i=0;i<nums.length;i++){
                if(nums[i] !=0) nums[i] = 0;
            }
            return nums;
        } 
        int totalProduct = 1;
        //pre calc right
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0) totalProduct *= nums[i];
        }

        //if only one zero
        if(zeroCnt == 1){
            for(int i=0;i<nums.length;i++){
                if(i == zeroPosition) nums[i] = totalProduct;
                else nums[i] = 0;
            }
            return nums;
        }
        //calc product with left 
        if (zeroCnt == 0){
            for(int i=0;i<nums.length;i++){
                nums[i] = totalProduct/nums[i];
            }
        }
        
        return nums;
    }
    // if division is not
    static int[] findProductNoDivision(int[] nums) {
        if (nums == null || nums.length <= 1) return nums == null ? new int[]{} : nums;
        
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 1: Calculate prefix products and store them directly in the result array
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Step 2: Calculate suffix products on the fly and multiply with the prefix products
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {10, 3, 5, 6, 2};
        // int[] nums = {1, 2, 3, 4, 5};
        // int[] nums = {1, 2, 3, 4};
        int[] nums = {3,3,3};
        // int[] nums = {12, 0};
        System.out.println(Arrays.toString(findPdoduct2(nums)));
    }
}

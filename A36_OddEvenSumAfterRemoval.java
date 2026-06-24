
public class A36_OddEvenSumAfterRemoval {
    static int find(int[] nums){
        int res = 0;
        // by prefix and suffix calc
        int rightEvenSum = 0,rightOddSum = 0;

        for(int i=0;i<nums.length;i++){
            if(i%2 == 0) rightEvenSum +=nums[i];
            else rightOddSum += nums[i];
        }

        int leftEvenSum = 0,leftOddSum = 0;
        for(int i=0;i<nums.length;i++){

            if(i%2 == 0) rightEvenSum -= nums[i];
            else rightOddSum -= nums[i];

            // now as ele shifts pos by one to left, order changes even-> odd and vv 
            if(leftEvenSum+rightOddSum == rightEvenSum+leftOddSum) 
                res++;

            if(i%2 == 0) leftEvenSum += nums[i];
            else leftOddSum += nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        System.out.println(find(arr));
    }
}

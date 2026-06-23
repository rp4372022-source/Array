import java.util.Arrays;

public class A35_EqualizeArr {
    // without formula
    static int count(int[] nums){
        
        if(nums == null || nums.length < 2) return 0;

        int steps = 0;
        boolean toStop = false;
        while(!toStop){
            int max = nums[0];
            int ptr = 0;
            // find max
            for(int i=1;i<nums.length;i++){
                if(nums[i] >= max) {
                    max = nums[i];
                    ptr = i;
                } 
            }
            // increment everyone except max
            for(int i=0;i<nums.length;i++){
                if(i == ptr) continue;
                nums[i] += 1;
            }
            steps++;
            // Check if all elements are equal
            boolean allEqual = true;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[0]) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                toStop = true;
            }

            //to see iterations
            System.out.println(
                "max = "+max +", ptr = "+ptr+", steps = "+steps+
                Arrays.toString(nums)
            );
            // temp
            try{Thread.sleep(300);}
            catch(InterruptedException e){
                System.out.println("Interrupted"+e.getMessage());
            }          
        }

        return steps;//final steps
    }

    // with formula
    public static int minOps(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int minVal = Arrays.stream(arr).min().getAsInt();
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum - n * minVal;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(count(nums));
    }
}
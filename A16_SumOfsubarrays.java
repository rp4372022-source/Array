public class A16_SumOfsubarrays {
    static int find(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i] * (i + 1) * (nums.length - i));
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 3, 2};
        System.out.println(find(arr));
    }
}
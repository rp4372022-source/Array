class A24_SubArrKProduct{
    static int find(int[] nums,int k){

        if( k <= 1) return 0; 
        int start = 0;
        long product = 1;
        int res = 0;

        for(int end = 0;end<nums.length;end++){

            product *= nums[end];
            
            while( product >= k && start <= end){
                product /= nums[start++];
            }

            res += end - start + 1;
        }

        return res;
    }
    public static void main(String[] args){
        // int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 9, 2, 8, 6, 4, 3};
        int k = 100;

        System.out.println(find(nums,k));
    }
}
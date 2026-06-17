public class A8_MoveZerosToEnd {
    //two travarsal
    static void twoTraversal(int[] nums){
        int c = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0 && i == c){
                c++;
            }
            else if(nums[i] != 0 && i != c){
                nums[c++] = nums[i];
                nums[i] = 0; 
            }
        }
    }
    // one traversal
    static void moveZeros(int[] nums){
        int ptr = 0;//slow pointer
        for(int i=0;i<nums.length;i++){ // fast pointer
            if(nums[i] != 0){
                if(ptr == i) {  ptr++; continue;}
                nums[ptr++] = nums[i];
            }
        }
        while(ptr < nums.length){
            nums[ptr++] = 0;
        }
    }

    // another method -> navie approach
    static void moveZeros1(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                int temp = i;
                while (nums[temp] != 0 && temp < nums.length) {
                    temp++;
                }
                if(nums[temp] != 0){
                    nums[i] = nums[temp];
                    nums[temp] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums= {1,1,1,0,0,0,1};
        twoTraversal(nums);
        for(int n:nums){
            System.out.print(n+" ");
        }
    }
}

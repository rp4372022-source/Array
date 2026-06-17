public class A2_ThirdLargestElement{
        static int find(int[] nums){
                int largest = -1;
                int secondLargest = -1;
                int thirdLargest = -1;
                for(int i=0;i<nums.length;i++){
                        if(nums[i] > largest){ thirdLargest = secondLargest; secondLargest = largest; largest = nums[i];}
                        else if(nums[i] > secondLargest && nums[i] != largest){ thirdLargest = secondLargest; secondLargest = nums[i]; }
                        else if(nums[i] > thirdLargest && nums[i] != secondLargest){ thirdLargest = nums[i]; }
                }
                return thirdLargest;
        }
        public static void main(String[] args){
                int[] nums = {5,4,3,2,1};
                System.out.println(find(nums));
        }
}
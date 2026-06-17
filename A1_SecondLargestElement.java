
public class A1_SecondLargestElement{
        //Most good brother
        static int find(int[] nums){
                if (nums.length < 2 || nums == null) return -1;//provided in condition that if not then return -1
                int largest = nums[0];
                int secondLargest = nums[1];
                if (largest < secondLargest){
                        largest = nums[1];
                        secondLargest = nums[0];
                }
                if (nums.length == 2) return secondLargest;
                for(int i=2;i<nums.length;i++){
                        if(nums[i] > largest){
                                secondLargest = largest;
                                largest = nums[i];
                        }else if(nums[i] > secondLargest && nums[i] != largest){
                                secondLargest = nums[i];
                        }
                }
                return secondLargest;
        }

        //another fkin method
        // Arrange array in increasing method than we know its 2largest is on n-1

        static int sortAndFind(int[] nums){
                //sort(Insertion sort)
                for(int i=1;i<nums.length;i++){
                        int j = i-1;
                        while(nums[j] > nums[j+1] && j > -1){
                                int temp = nums[j];
                                nums[j] = nums[j+1];
                                nums[j+1] = temp;
                                j--;
                        }

                }
                return nums[nums.length-2];//Seconf Largest

        }


        // Two Pass Search
        // The approach is to traverse the array twice. In the first traversal, find the maximum element. In the second traversal, find the maximum element ignoring the one we found in the first traversal.
        static int tps(int[] nums){
                if (nums.length < 2 || nums == null) return -1;
                int largest = nums[1];
                int secondLargest = -1;
                for(int i=1;i<nums.length;i++){
                        if(nums[i] > largest) largest = nums[i];
                }
                for(int i=0;i<nums.length;i++){
                        if(nums[i] > secondLargest && nums[i] != largest) secondLargest = nums[i];
                }
                return secondLargest;//Seconf Largest

        }
        public static void main(String[] args){
                int[] nums = {15};
                System.out.println(sortAndFind(nums));
        }
}
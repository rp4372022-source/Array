import java.util.Arrays;
public class A6_ThreeGreateCandidates {
    // we have to find max product

    //greedy approach
    static int find(int[] nums){
        int firstGreatest = nums[0];
        int secondGreatest = -1;
        int thirdGreatest = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > firstGreatest){
                thirdGreatest = secondGreatest;
                secondGreatest = firstGreatest;
                firstGreatest = nums[i];
            } else if(nums[i] > secondGreatest){
                thirdGreatest = secondGreatest;
                secondGreatest = nums[i];
            } else if (nums[i] > thirdGreatest){
                thirdGreatest = nums[i];
            }
        }

        return firstGreatest*secondGreatest*thirdGreatest;
    }

    //by build in sort method
    static int find1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(find1(nums));
    }
}

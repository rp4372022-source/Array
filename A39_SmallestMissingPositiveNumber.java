import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class A39_SmallestMissingPositiveNumber {
    static int find(int[] nums){ //tc - N*M ,m is maxNum
        List<Integer> presentNums = new ArrayList<>();
        int maxNum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                presentNums.add(nums[i]);
                maxNum = Math.max(maxNum, nums[i]);
            }
        }

        for(int i = 1;i<maxNum;i++){
            if(!presentNums.contains(i)){
                return i;
            }
        }

        return maxNum+1;
    }
    static int find1(int[] nums){//tc - n, sc = n
        Set<Integer> presentNums = new HashSet<>();
        for (int n : nums) {
            presentNums.add(n);
        }

        Integer i=1;
        while(presentNums.contains(i)){
            i++;
        }

        return i;
    }
    public static void main(String[] args) {
        // int[] nums = {2, -3, 4, 1, 1, 7};
        int[] nums = {3, 2, 1};
        System.out.println(find1(nums));
    }
}

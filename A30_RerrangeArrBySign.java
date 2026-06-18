import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class A30_RerrangeArrBySign {

    static int[] arrange(int[] nums){
        List<Integer> negativeNumList = new ArrayList<>();
        List<Integer> positiveNumList = new ArrayList<>();
        int[] result = new int[nums.length];

        //seperating +ve numand -ve num
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                positiveNumList.add(nums[i]);
            } else {
                negativeNumList.add(nums[i]);
            }
        }

        System.out.println(positiveNumList+" ,"+negativeNumList);
        //adding to result arr
        int ptr1 = 0,ptr2 = 0;
        for(int j=0;j<result.length;j++){
            if(j%2 == 0 && ptr1 < positiveNumList.size()){
                result[j] = positiveNumList.get(ptr1++);
            }
            else if(j%2 != 0 && ptr2 < negativeNumList.size()) {
                result[j] = negativeNumList.get(ptr2++);
            }
            else if(ptr1 < positiveNumList.size()){
                result[j] = positiveNumList.get(ptr1++);
            }
            else {
                result[j] = negativeNumList.get(ptr2++);
            }
        }
        return result;
    }

    static int[] arrange1(int[] nums){
        List<Integer> negativeNumList = new ArrayList<>();
        List<Integer> positiveNumList = new ArrayList<>();
        int[] result = new int[nums.length];

        //seperating +ve numand -ve num
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                positiveNumList.add(nums[i]);
            } else {
                negativeNumList.add(nums[i]);
            }
        }

        System.out.println(positiveNumList+" ,"+negativeNumList);
        //adding to result arr
        int ptr1 = 0,ptr2 = 0;
        for(int j=0;j<result.length;j++){
            if(j%2 == 0 && ptr1 < positiveNumList.size()){
                result[j] = positiveNumList.get(ptr1++);
            }
            else if(j%2 != 0 && ptr2 < negativeNumList.size()) {
                result[j] = negativeNumList.get(ptr2++);
            }
            else if(ptr1 < positiveNumList.size()){
                result[j] = positiveNumList.get(ptr1++);
            }
            else {
                result[j] = negativeNumList.get(ptr2++);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,-4,-1,4};
        System.out.println(Arrays.toString(arrange(nums)));
    }
}
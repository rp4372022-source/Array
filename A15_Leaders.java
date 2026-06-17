import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class A15_Leaders {

    //its creativity dont use it, feel it!
    static int find(int[] arr){
        //assuming length >= 2

        int finalLength = 0;
        int maxNum = arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            // for(int a:arr) System.out.print(a+" ");
            // System.out.println();
            if(i == finalLength-1) break;
            else if(arr[i] >= maxNum){
                maxNum = arr[i];
                A5_RotateArr.rotateRight(arr,1,0,i);//i is index not length that why give i+1
                finalLength++;
                i++;
            }
        }

        return finalLength;
    }

    // answer
    static int[] findLeaders(int[] arr){
        //assuming length >= 2
        ArrayList<Integer> leaders = new ArrayList<>();
        int maxNum = arr[arr.length-1];
        leaders.add(maxNum);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] >= maxNum) {
                maxNum = arr[i];
                leaders.add(maxNum);
            } 
        }
        // revArrlist(leaders);
        Collections.reverse(leaders); //for reverssingn purpose
        return leaders.stream().mapToInt(Integer::intValue).toArray();
    }
    static void revArrlist(ArrayList<Integer> leaders){
        int left=0,right = leaders.size()-1;
        while(left < right){
                int temp = leaders.get(left);
                leaders.set(left,leaders.get(right));
                leaders.set(right,temp);
                left++; right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        
        System.out.println(Arrays.toString(findLeaders(arr)));
    }
}

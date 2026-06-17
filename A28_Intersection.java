import java.util.List;
import java.util.ArrayList;
public class A28_Intersection {
    
    static List<List<Integer>> find1(int[][] arr1,int[][] arr2){

        List<List<Integer>> result = new ArrayList<>();

        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            
            int start = -1, end = -1;
            
            start = Math.max(arr1[ptr1][0],arr2[ptr2][0]);
            end = Math.min(arr1[ptr1][1],arr2[ptr2][1]);
            
            //check validity and add it
            if(start <= end){
                result.add(List.of(start,end));
            }
            
            //ptr incrementation
            if(arr1[ptr1][1] < arr2[ptr2][1]){
                ptr1++;
            } else ptr2++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{0, 4}, {5, 10}, {13, 20}, {24, 25}};
        int[][] arr2 = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        System.out.println(find1(arr1, arr2));
    }
}

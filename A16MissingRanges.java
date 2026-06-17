import java.util.ArrayList;
import java.util.List;
public class A16MissingRanges {

    static List<List<Integer>>  getIntervalsList(int[] arr,int lower,int upper){
        List<List<Integer>> ranges = new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){
            int diff = 0;
            if(i == 0){
                diff = arr[i] - lower;
                if(diff > 1){
                    ranges.add(List.of(lower,arr[i]-1));
                }
            }
            diff = arr[i+1] - arr[i];
            if(diff > 1){
                ranges.add(List.of(arr[i] + 1,arr[i+1]-1));
            }
            
        }

        if(upper - arr[arr.length-1] > 1){
            ranges.add(List.of(arr[arr.length-1]+1, upper));
            
        }
        return ranges;
    }

    
    public static void main(String[] args) {
        int[] arr = {14, 15, 20, 30, 31, 45};
        int lower = 10;
        int upper = 50;

        List<List<Integer>> list = getIntervalsList(arr, lower, upper);

        for(int a=0;a<list.size();a++){
            System.out.print(list.get(a));
        }
    }
}

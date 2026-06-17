import java.util.ArrayList;
import java.util.Arrays;

class Yes{
    //try hard method
    static int[] find(int[] arr){
        int lastMajority = -1; // second majority ele
        // int lmcount = 0;
        int currentMajority = arr[0];
        int cmcount = 1;

        for(int i=1;i<arr.length;i++){
            if (arr[i] != currentMajority){
                cmcount--;
                if (cmcount == 0){
                    lastMajority = currentMajority;
                    currentMajority = arr[i];
                    cmcount = 1; 
                }
            }
            else {
                cmcount++;
            }
        }

        int tempcount1stele = 0;
        int tempcount2ndele = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == currentMajority) tempcount1stele++;
            else if(arr[i] == lastMajority) tempcount2ndele++;
        }

        if(tempcount1stele > arr.length/3 && tempcount2ndele > arr.length/3){
            int[] ans = {lastMajority,currentMajority};
            if(ans[0] > ans[1]){
                Arrays.sort(ans);
            }
            return ans;
        }else if(tempcount1stele > arr.length/3){
            return new int[]{currentMajority};
        }
        else {
            return new int[]{};
        }
    }

    static int[] find1(int[] arr){
        int candidate1 = arr[0], candidate2 = arr[1];
        int c1cnt = 1, c2cnt = 1;

        for(int i=2;i<arr.length;i++){
            if( arr[i] == candidate1){c1cnt++;}
            else if( arr[i] == candidate2){c2cnt++;}
            else if(c1cnt == 0){candidate1 = arr[i];c1cnt = 1;}
            else    if(c2cnt == 0){candidate2 = arr[i];c2cnt = 1;}
            else{
                c1cnt--;
                c2cnt--;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        c1cnt = 0; c2cnt = 0;
        for(int a:arr){
            if(a == candidate1) c1cnt++;
            else if(a == candidate2) c2cnt++;
        }

        if (c1cnt > arr.length/3 && c2cnt > arr.length/3 && candidate1 != candidate2){
            if (candidate1 < candidate2){
            list.add(candidate1);
            list.add(candidate2);
            } else {
                list.add(candidate2);
                list.add(candidate2);
            }
        }
        else if(c1cnt > arr.length/3){
            list.add(candidate1);
        }else if(c2cnt >arr.length/3){
            list.add(candidate2);
        }

        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();

        return ans;
    }
    public static void main(String[] args) {
        //int[] arr = {2, 2, 3, 1, 3, 2, 1, 1};
        // int[] arr = {-5, 3, -5};
        // int[] arr = {3, 2, 2, 4, 1, 4};
        // int[] arr = {2, 1, 2, 3, 2, 4, 2};
        // int[] arr = {1, 2, 3, 2, 3, 2, 3};
        // int[] arr = {2, 2, 2, 2, 3, 4, 5};
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 4};
        System.out.println(Arrays.toString(find1(arr)));
    }
}
import java.util.Arrays;

public class A14_AlternateNums {
    static int arrange(int[] arr){
        if(arr == null) return -1;
        if(arr.length < 2) return (arr.length == 0) ? -1 : arr[0];

        boolean needPositive = true;

        for(int i=0;i<arr.length;i++){
            if (needPositive && arr[i] < 0){
                int ptr = i+1;
                while(ptr < arr.length){
                    if(arr[ptr] >= 0) {
                        rotate(arr, i, ptr);
                        break;
                    }
                    ptr++;
                }
            } 
            else if (!needPositive && arr[i] > 0){
                int ptr = i+1;
                while(ptr < arr.length){
                    if(arr[ptr] < 0) {
                        rotate(arr, i, ptr);
                        break;
                    }
                    ptr++;
                }
            } 
            if(needPositive) needPositive = false;
            else if(!needPositive) needPositive = true;
        }
        return 0;
    }

    private static void rotate(int[] arr,int start, int end){
        int k = 1;
        //we need right rotate by 1
        if(arr[start+1] == arr[end]){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;    
        }
        else {
            reverse(arr,start,end);
            reverse(arr, start, start+k-1);//start+k-1 -> start + 1 -1 -> start
            reverse(arr, start+k, end);
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-4,-1,4};
        arrange(arr);
        for(int a:arr) System.out.print(a+" ");
    }
}

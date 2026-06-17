public class A13_RMDuplicates {
    static int removeD(int[] arr){
        if(arr == null || arr.length < 2) {
            System.out.println("Invalid length");
            return -1;
        } 
        //arr is sorted hence
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] == arr[i]){
                arr[i-1] = -1;
            }
        }

        //now moving -1 at end 
        int ptr = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != -1 && ptr != i-1){
                arr[++ptr] = arr[i];
            }
        }
        ptr++;
        while(ptr < arr.length){
            arr[ptr] = -1;
            ptr++;
        }

        //returning length of new arr
        int length = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1) continue;
            length++;
        }
        return length;
    }

    //best approach -> Single pass -> 2 ptr
    static int removeDu(int[] arr){
        if(arr == null) return 0;
        if(arr.length < 2) return arr.length;

        int ptr = 0;

        for(int i=1;i<arr.length;i++){
            if(arr[ptr] != arr[i]){
                arr[++ptr] = arr[i];
            }
        }
        ptr++;
        return ptr;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,3};
        int ptr = removeDu(arr);
        System.out.println(ptr);
        for(int i=0;i<ptr;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

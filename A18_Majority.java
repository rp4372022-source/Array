public class A18_Majority {
    static int find(int[] arr){
        int majorityN = arr[0], cnt = 1;

        for(int i=1;i<arr.length;i++){
            if(arr[i] != majorityN){
                cnt--;
                if(cnt == 0){
                    majorityN = arr[i];
                    cnt = 1;
                }
            } else {
                cnt++;
            }
        }

        //add verification step
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == majorityN) count++;
        }
        if(count == arr.length/2) return majorityN;

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3};
        System.out.println(find(arr));
    }
}

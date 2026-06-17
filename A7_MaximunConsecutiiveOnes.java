public class A7_MaximunConsecutiiveOnes {
    static int calc(int[] arr){
        if(arr.length == 0 || arr == null) return -1;
        if(arr.length == 1) return 1; 
        int lenOfLongest = 1;
        int temp = 1;
        for(int i=1;i<arr.length;i++){
            if((arr[i-1] ^ arr[i]) == 0) temp++; // ^ -> its XOR operator which return 0 if both nums are same
            else {
                temp = 1;
            }
            lenOfLongest = Math.max(lenOfLongest,temp);
        }
        return lenOfLongest;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1};
        System.out.println(calc(arr));
    }
}

import java.util.Arrays;
class NextPermutation{
        static int[] find(int[] arr){
                int[] per = arr;

                boolean isFound = false;
                for(int i=arr.length-1;i>=1;i--){
                        if(per[i-1]<per[i]){
                                int temp1 = per[i-1];
                                per[i-1] = per[i];
                                per[i] = temp1;
                                isFound = true;
                                break;
                        }
                }

                if (!isFound) {
                    Arrays.sort(per);
                }
                return per;
        }
        public static void main(String[] args){
                int[] arr = {3,2,1};
                System.out.println(Arrays.toString(find(arr)));
        }
}

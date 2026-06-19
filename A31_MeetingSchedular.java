import java.util.Arrays;
public class A31_MeetingSchedular {
    static int[] find(int[][] p1Slots,int[][] p2Slots,int d){
            int ptr1 = 0,ptr2 =0;
            while(ptr1<p1Slots.length && ptr2 <p2Slots.length){
                    int start = Math.max(p1Slots[ptr1][0], p2Slots[ptr2][0]);
                    int end   = Math.min(p1Slots[ptr1][1], p2Slots[ptr2][1]);
                    //for validity
                    if(start<end && d <= end-start){
                            return new int[]{start,start+d};
                    }
                    //if(ptr1 == p1Slots.length-1 || ptr2 == p2Slots.length-1) break;
                    if(p1Slots[ptr1][1] < p2Slots[ptr2][1] || ptr2 == p2Slots.length-1) ptr1++;
                    else if(p1Slots[ptr1][1] > p2Slots[ptr2][1] || ptr1 == p1Slots.length-1) ptr2++;
                    // the second line can be shortend
            }
            return new int[]{};
    }
    public static void main(String[] args){
            // int[][] p1 = {{10,50}, {60,120}, {140,210}};
            // int[][] p2 = {{0,15}, {60,70}};
            // int d = 8;

            int[][] p1 = {{10,50}, {}, {60,120}, {140,210}};
            int[][] p2 = {{0,15}, {17,20}, {21,30}};
            int d = 21;
            System.out.println(Arrays.toString(find(p1,p2,d)));
    }
}
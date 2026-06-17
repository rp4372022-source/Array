import java.util.Arrays;
public class A20_Heights {
    static int find(int[] heights,int k){
        //assuming length of arr >= 2

        //avg calc
        int avg = 0;
        for(int h:heights) avg += h;
        avg /= heights.length;

        for(int i=0;i<heights.length;i++){
            if(heights[i] < avg){
                heights[i] += k;
            } else {
                heights[i] -= k;
            }
        }

        //find largest and smallest 
        int largest = heights[0], smallest = heights[1];
        if(largest < smallest){
            int temp = largest;
            largest = smallest;
            smallest = temp;
        }
        for(int i=2;i<heights.length;i++){
            if(heights[i] > largest) largest = heights[i];
            else if(heights[i] < smallest) smallest = heights[i];
        }
        
        return largest - smallest;
    }

    //best solution
    static int calc1(int[] heights,int k){
        Arrays.sort(heights);

        int ans = heights[heights.length-1] - heights[0];

        for(int i=0;i<heights.length-1;i++){
            int minH = Math.min(heights[0] + k,heights[i + 1] - k);
            int maxH = Math.max(heights[i] + k,heights[heights.length-1] - k);
            ans = Math.min(ans,maxH - minH);
        }
        return ans;
    }
    public static void main(String[] args) {
        int k = 2;
        int[] arr = {1, 5, 8, 10};
        System.out.println(calc1(arr,k));
    }
}









































import java.util.List;
import java.util.ArrayList;

public class A27_AntFallProblem {
    // its actually not solved, the solution is comming bcz we speed of ants during collision is same 
    // if speed were not same then its was op
    static int find(List<Integer> left,List<Integer> right,int n){
        int time = -1;

        while(right.size() != 0 || left.size() != 0){
            for(int i=0;i<right.size();i++){
                right.set(i,right.get(i)+1);
                if(right.get(i) >= n) {
                    right.remove(i);
                    i--;
                }
                // System.out.println("right "+right);
            }
            for(int i=0;i<left.size();i++){
                left.set(i,left.get(i)-1);
                if(left.get(i) <= 0) {
                    left.remove(i);
                    i--;
                }
                // System.out.println("left :"+left);
            }
            time++;
        }
        return time;
    }

    // another approach
    static int find1(List<Integer> left,List<Integer> right,int n){
        int maxTime = 0;

        
        for(int l:left){
            maxTime = Math.max(maxTime,l);
        }
        for(int r:right){
            maxTime = Math.max(maxTime,n-r);
        }
            
        
        return maxTime;
    }
    public static void main(String[] args) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int n = 4;
        
        // left.add(2);
        // right.add(0);
        // right.add(1);
        // right.add(3);

        right.add(0);
        right.add(1);
        right.add(2);
        right.add(3);
        right.add(4);
        System.out.println(find(left,right,n));
    }
}
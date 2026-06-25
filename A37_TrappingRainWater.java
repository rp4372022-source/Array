public class A37_TrappingRainWater {
    static int find(int[] height){

        int lMax = height[0];
        int rMax = height[height.length-1];
        int res = 0;

        int left = 1, right = height.length-2;

        while(left<=right){
            if(lMax <= rMax){
                res += Math.max(0,lMax-height[left]);
                lMax = Math.max(lMax,height[left]);
                left++;
            } else {
                res += Math.max(0,rMax-height[right]);
                rMax = Math.max(rMax,height[right]);
                right--;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] height = {3, 0, 1, 0, 4, 0, 2};
        System.out.println(find(height));
    }
}

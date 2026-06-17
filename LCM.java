public class LCM {
        //formula to find lcm is
        //lcm(a,b) = |a*b| / gcd(a,b);
        static int findLCM(int a,int b){
                int num1 = a, num2 = b;
                if(num1 < num2){
                        num1 = b;
                        num2 = a;
                }
                if(num1 % num2 == 0) return num1;

                //GCD gcd = new GCD();

                int lcm = Math.abs(num1*num2) / GCD.findGCD(num1,num2);

                return lcm;
        }
        public static void main(String[] args){
                int a = 6, b=8;
                System.out.println(findLCM(a,b));
        }
}
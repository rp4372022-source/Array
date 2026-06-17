public class GCD{
        //Euclidean algo
        static int findGCD(int a,int b){
                if(a == 0) return b;
                else if(b == 0) return a;

                int num1 = a, num2 = b;

                if(num1 < num2){
                        num1 = b;
                        num2 = a;
                }
                int lastremainder = 1;
                int remainder = 1;
                while(remainder > 0){
                        lastremainder = remainder;
                        remainder = num1 % num2;
                        num1 = num2;
                        num2 = remainder;
                }
                return lastremainder;
        }
        public static void main(String[] args){
                int a = 20, b =24;
                System.out.println(findGCD(a,b));
        }
}

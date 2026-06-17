public class Main {
    public static void main(String[] args) {
        // An array in Java is a data structure 
        // used to store multiple values of the same 
        // data type in a single variable. 
        // They are useful for organizing related 
        // data efficiently and allowing fast, constant-time
        // access () to elements using an index. 

        // Key Concepts
        //     Fixed Size: Once an array is created, its length cannot be changed.
        //     Zero-Based Indexing: The first element is always at index 0, and the last element is at length - 1.
        //     Same Data Type: All elements in a single array must be of the same type (e.g., all int or all String). 


        //Declaration
        int[] nums = new int[5];//array of length 5

        //Declaration + Initialization
        // String[] cars = {"M5","Challanger","Chiron"};

        // Enhanced For-Each Loop: A cleaner way 
        // to iterate if you don't need the index.
        for (int num : nums) {
            System.out.println(num);
        }

        String yes = Double.toString(12.5);
        System.out.println(yes);

        if( Math.pow(3,2) == 9){
            System.out.println("yes");
        }

        if (8 != 9){
            throw new IllegalArgumentException("Invalid Num");
        }
    }
}
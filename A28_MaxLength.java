public class A28_MaxLength {

    static int find(String seats){
        if(seats == null || seats.length() < 2) return -1;
        int[] seatsArr = new int[seats.length()];

        for(int i=0;i<seatsArr.length;i++) seatsArr[i] = Character.getNumericValue(seats.charAt(i));

        int result = -1, emptySeats = 0;

        for(int i=0;i<seatsArr.length;i++){
            if(seatsArr[i] == 1 && result == -1){
                result = emptySeats;
                emptySeats = 0;
            } else if(seatsArr[i] == 0){
                emptySeats++;
            } else {
                result = (int) Math.max(result,Math.ceil(emptySeats/2.0));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String seats = "1000101";
        System.out.println(find(seats));
    }
}
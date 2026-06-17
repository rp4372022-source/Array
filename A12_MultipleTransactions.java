public class A12_MultipleTransactions {
    static int calc(int[] prices){
        if(prices == null  || prices.length < 2) return 0;

        int maxProfit = 0;
        int sell = prices[prices.length-1];
        int buy = Integer.MAX_VALUE;
        for(int i=prices.length-2;i>=0;i--){
            if (prices[i] < buy){
                // System.out.println("yes");
                buy = prices[i];
            }
            else if(prices[i] > buy){
                // System.out.println("done");
                maxProfit += sell - buy;
                // System.out.println(maxProfit);
                sell = prices[i];
                buy = Integer.MAX_VALUE;
            }
        }
        maxProfit += sell-buy;

        return maxProfit;
    }

    // temporary answer with approximate correct approach
    static int find(int[] prices){
        int profitSoFar = 0;
        int currProfit = 0;
        int sellP = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if (prices[i] > prices[i-1]) {
                profitSoFar = currProfit;
                sellP = prices[i];
                continue;
            }
            currProfit = Math.max(currProfit, sellP - prices[i]);
        }
        return profitSoFar;
    }
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(calc(prices));
    }
}

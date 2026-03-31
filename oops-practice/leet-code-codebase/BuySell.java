class BuySell {
    public int maxProfit(int[] prices) {
        int temp=prices[0],x=0;;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<temp)
            {
                temp=prices[i];
            }
            x=Math.max(x,prices[i]-temp);
        }
        return x;
    }
}
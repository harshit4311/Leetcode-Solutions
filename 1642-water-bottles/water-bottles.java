class Solution {
    public int numWaterBottles(int n, int exchangeRate) {
        if(n < exchangeRate) {
            return n;
        }

        int sum = n;

        while(n >= exchangeRate) {
            int newBottles = n / exchangeRate;
            int remainingBottles = n % exchangeRate;
            
            // No.of bottles we have had water from
            sum += newBottles;

            // New no.of bottles
            n = newBottles + remainingBottles;
        }

        return sum;
    }
}
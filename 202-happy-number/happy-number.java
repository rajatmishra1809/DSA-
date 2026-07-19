class Solution {
    public boolean isHappy(int n) {
        // Any unhappy number will eventually drop into the endless cycle containing 4
        while (n != 1 && n != 4) {
            n = getNext(n);
        }
        
        // If it broke out because it reached 1, it's happy
        return n == 1;
    }
    
    // Helper method to calculate the sum of the squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }
}
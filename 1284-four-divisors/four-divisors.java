public class Solution {

    public int sumFourDivisors(int[] arr) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int divisorCount = countDivisors(num);

            if (divisorCount == 4) {
                result += sumOfDivisors(num);
            }
        }
        return result;
    }

    public static int countDivisors(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count++;
                } 
                else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public int sumOfDivisors(int num) {
        int sum = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    sum += i;
                } 
                else {
                    sum += i + num / i;
                }
            }
        }
        return sum;
    }
}

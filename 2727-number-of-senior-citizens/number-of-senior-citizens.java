class Solution {
    public int countSeniors(String[] arr) {
        int count = 0;

        for(String detail : arr) {
            int age = Integer.parseInt(detail.substring(11, 13));

            if(age > 60) {
                count++;
            }
        }

        return count;
    }
}
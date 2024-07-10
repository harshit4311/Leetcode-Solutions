class Solution {
    public int minOperations(String[] logs) {
        int count = 0;

        for(String operation : logs) {
            if(operation.equals("../")) {
                if(count > 0) {
                    count--;
                }
            }

            else if(!operation.equals("./")) {
                count++;
            }
        }   

        return count;
    }
}
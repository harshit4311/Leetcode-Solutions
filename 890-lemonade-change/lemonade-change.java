class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_count = 0;
        int ten_count = 0;

        for(int i : bills) {
            if(i == 5) {
                five_count++;
            }

            else if(i == 10) {
                // If $5 notes present,
                // Give $5 change
                if(five_count > 0) {
                    five_count--;
                    ten_count++;
                }

                // $5 notes not present
                else { 
                    return false;
                }
            }

            else if(i == 20) {
                // Prefer to give one $10 and one $5 bill if possible
                if(five_count > 0 && ten_count > 0) {
                    five_count--;
                    ten_count--;
                }

                // If $10 notes aren't present, give 3x($5) bills
                else if(five_count >= 3) {
                    five_count -= 3;
                }
                
                // Not possible
                else {
                    return false;
                }
            }
        }
        return true; 
    }
}
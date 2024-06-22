class Solution {
    public int maxDistance(int[] positionArr, int m) {
        Arrays.sort(positionArr);
        
        int n = positionArr.length;

        int minForce = 1;

        // 'maxForce' can also be written as = positionArr[n - 1] - positionArr[0]
        int maxForce = (int) Math.ceil(positionArr[n - 1] / (m - 1.0));

        int result = 0;

        while(minForce <= maxForce) {
            int mid = minForce + (maxForce - minForce) / 2;

            if(isPossibleToPlaceBalls(mid, m, positionArr)) {
                result = mid;
                minForce = mid + 1;
            }
            
            else {
                maxForce = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossibleToPlaceBalls(int force, int m, int[] positionArr) {
        int prevPosition = positionArr[0];

        int ballsPlaced = 1;

        for(int i = 1; i < positionArr.length; i++) {
            if(positionArr[i] - prevPosition >= force) {
                ballsPlaced++;
                prevPosition = positionArr[i];
            }

            if(ballsPlaced == m) {
                return true;
            }
        }

        return false;
    }
}
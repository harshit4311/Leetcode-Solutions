class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> resultList = new ArrayList<>();

        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < arr1.length; j++) {

                if(arr1[j] == arr2[i]) {
                    resultList.add(arr1[j]);
                    arr1[j] = -1;
                }
            }
        }

        Arrays.sort(arr1);

        // Add the remaining elements of arr1 to resultList
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != -1) {
                resultList.add(arr1[i]);
            }
        }   

        // Convert resultList to resultArr because the function wants an output in integer array
        int[] resultArr = new int[resultList.size()];   
        for(int i = 0; i < resultArr.length; i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }
}
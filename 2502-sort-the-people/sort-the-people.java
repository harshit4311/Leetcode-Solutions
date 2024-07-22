class Pair implements Comparator<Pair> {
    int height;
    String name;

    Pair() {}

    Pair(int height, String name) {
        this.height = height;
        this.name = name;
    }

    @Override
    public int compare(Pair p1, Pair p2) {
        return Integer.compare(p2.height, p1.height);
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<Pair> pairList = new ArrayList<>();

        int n = names.length;

        for(int i = 0; i < n; i++) {
            pairList.add(new Pair(heights[i], names[i]));
        }

        Collections.sort(pairList, new Pair());

        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            result[i] = pairList.get(i).name;
        }

        return result;
    }
}
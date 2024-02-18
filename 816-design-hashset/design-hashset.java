class MyHashSet {
    public boolean[] key;

    public MyHashSet() {
        key = new boolean[1000001];
        Arrays.fill(key, false);
    }

    public void add(int keyValue) {
        key[keyValue] = true;
    }

    public void remove(int keyValue) {
        key[keyValue] = false;
    }

    public boolean contains(int keyValue) {
        return key[keyValue];
    }
}

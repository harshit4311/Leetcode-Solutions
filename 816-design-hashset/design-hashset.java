class MyHashSet {
    public int ARRAY_SIZE = 1000000; // Size of the array
    public LinkedList<Integer>[] set; // Array of LinkedLists

    public MyHashSet() {
        set = new LinkedList[ARRAY_SIZE];
    }

    public void add(int key) {
        int index = hash(key);
        if (set[index] == null) {
            set[index] = new LinkedList<>();
        }
        if (!contains(key)) {
            set[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (set[index] != null) {
            set[index].remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        if (set[index] != null) {
            return set[index].contains(key);
        }
        return false;
    }

    // Hash function to get the index for the key
    public int hash(int key) {
        return key % ARRAY_SIZE;
    }
}

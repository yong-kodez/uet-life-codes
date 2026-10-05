public class Pair<K, V> {
    private K key;
    private V val;
    
    public Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public K getKey() { return this.key; }
    public V getVal() { return this.val; }

    public void setVal(V val) { this.val = val; }
}

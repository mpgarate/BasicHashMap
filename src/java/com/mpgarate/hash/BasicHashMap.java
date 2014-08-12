// Hash table with linked lists for collisions
//
// Supports add, get, update, remove, toString

package com.mpgarate.hash;

public class BasicHashMap<K, V> {

    private Integer tableSize;
    private Bucket<K,V>[] buckets;

    private final Integer DEFAULT_TABLE_SIZE = 128;

    public BasicHashMap() {
        this.tableSize = DEFAULT_TABLE_SIZE;
        initializeTable();
    }

    public BasicHashMap(Integer tableSize) {
        this.tableSize = tableSize;
        initializeTable();
    }

    public void add(K key, V value) {
        Integer index = calculateIndexOf(key);
        buckets[index].add(key, value);
    }

    public V get(K key) {
        Integer index = calculateIndexOf(key);
        V value = buckets[index].get(key);
        return value;
    }

    public V update(K key, V value) {
        Integer index = calculateIndexOf(key);
        Bucket<K,V> bucket = buckets[index];
        V oldValue = bucket.getValue(key);

        bucket.update(key, value);

        return oldValue;
    }

    public V remove(K key) {
        Integer index = calculateIndexOf(key);
        V value = buckets[index].get(key);

        buckets[index].remove(key);

        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < buckets.length; i++) {
            for (BucketNode<K,V> bucketNode : buckets[i].bucketNodes) {
                sb.append("index: " + i + " | ");
                sb.append(bucketNode.getKey() + " => ");
                sb.append(bucketNode.getValue());
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private Integer calculateIndexOf(K key) {
        Integer hashCode = key.hashCode();
        Integer index = Math.abs(hashCode % tableSize);
        return index;
    }

    private void initializeTable() {
        this.buckets = new Bucket[this.tableSize];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket<K,V>();
        }
    }
}

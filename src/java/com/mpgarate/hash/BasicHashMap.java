package com.mpgarate.hash;

public class BasicHashMap<K, V> {

    private final static Integer DEFAULT_TABLE_SIZE = 128;

    private Integer tableSize;
    private Bucket<K, V>[] buckets;


    public BasicHashMap() {
        this(DEFAULT_TABLE_SIZE);
    }

    public BasicHashMap(Integer tableSize) {
        this.tableSize = tableSize;
        this.buckets = new Bucket[tableSize];
    }

    public void add(K key, V value) {
        if (null == key){
            return;
        }

        Integer index = calculateIndexOf(key);

        Bucket<K,V> bucket = buckets[index];

        if (null == bucket) {
            bucket = new Bucket<K, V>();
        }

        bucket.add(key, value);
        buckets[index] = bucket;
    }

    public V get(K key) {
        if (null == key){
            return null;
        }

        Integer index = calculateIndexOf(key);

        Bucket<K,V> bucket = buckets[index];

        if (null == bucket){
            return null;
        } else {
            return bucket.getValue(key);
        }
    }

    public V update(K key, V value) {
        Integer index = calculateIndexOf(key);
        Bucket<K, V> bucket = buckets[index];
        V oldValue = bucket.getValue(key);

        bucket.update(key, value);

        return oldValue;
    }

    public V remove(K key) {
        Integer index = calculateIndexOf(key);
        V value = buckets[index].getValue(key);

        buckets[index].remove(key);

        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < buckets.length; i++) {
            for (BucketNode<K, V> bucketNode : buckets[i].bucketNodes) {
                sb.append("index: " + i + " | ");
                sb.append(bucketNode.getKey() + " => ");
                sb.append(bucketNode.getValue());
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public int getBucketSize(){
        return buckets.length;
    }

    private Integer calculateIndexOf(K key) {
        Integer hashCode = key.hashCode();
        Integer index = Math.abs(hashCode % tableSize);
        return index;
    }

    private void initializeTable() {
        this.buckets = new Bucket[this.tableSize];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket<K, V>();
        }
    }
}

package com.mpgarate.hash;

import java.util.LinkedList;

public class Bucket<K,V> {
    public LinkedList<BucketNode> bucketNodes = new LinkedList<BucketNode>();

    public Bucket() {

    }

    public void add(K key, V value) {
        bucketNodes.add(new BucketNode<K,V>(key, value));
    }

    public void remove(K key) {
        for (BucketNode bucketNode : bucketNodes) {
            if (bucketNode.keyEquals(key)) {
                bucketNodes.remove(bucketNode);
            }
        }
    }

    public void update(K key, V value) {
        remove(key);
        add(key, value);
    }

    public V get(K key) {
        return getValue(key);
    }

    public V getValue(K key) {
        for (BucketNode<K,V> bucketNode : bucketNodes) {
            if (bucketNode.keyEquals(key)){
                return bucketNode.getValue();
            }
        }
        return null;
    }
}
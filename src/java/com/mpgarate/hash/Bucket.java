package com.mpgarate.hash;

import java.util.LinkedList;

public class Bucket<K, V> {
    public LinkedList<BucketNode> bucketNodes = new LinkedList<BucketNode>();

    public Bucket(K key, V value) {
       add(key,value);
    }

    public Bucket(){
       this(null, null);
    }

    public void add(K key, V value) {
        if (null != key) {
            bucketNodes.add(new BucketNode<K, V>(key, value));
        }
    }

    public void remove(K key) {
        if (null == key){
            return;
        }

        for (BucketNode bucketNode : bucketNodes) {
            if (key.equals(bucketNode.getKey())) {
                bucketNodes.remove(bucketNode);
            }
        }
    }

    public void update(K key, V value) {
        remove(key);
        add(key, value);
    }

    public V getValue(K key) {
        if (null == key){
            return null;
        }

        for (BucketNode<K, V> bucketNode : bucketNodes) {
            if (key.equals(bucketNode.getKey())) {
                return bucketNode.getValue();
            }
        }
        return null;
    }
}
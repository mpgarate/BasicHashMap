package com.mpgarate.hash;

/**
 * Created by mike on 8/12/2014.
 */
public class BucketNode<K,V> {
    private K key;
    private V value;

    public BucketNode(K key, V value){
        this.key = key;
        this.value = value;
    }


    public V getValue(){
        return value;
    }

    public K getKey(){
        return key;
    }

    public Boolean keyEquals(K key){
        if (this.key == key){
            return true;
        } else {
            return false;
        }
    }
}

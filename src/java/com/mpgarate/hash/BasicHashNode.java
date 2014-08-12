package com.mpgarate.hash;

import java.util.LinkedList;
public class BasicHashNode {
  public LinkedList<Object[]> list = new LinkedList<Object[]>();

  public BasicHashNode(){

  }

  public void add(Object[] data){
    list.add(data);
  }

  public void remove(String str){
    for (Object[] data : list){
      if (data[0].equals(str)){
        list.remove(data);
      }
    }
  }

  public void update(Object[] data){
    String old_str = data[0].toString();
    remove(old_str);
    add(data);
  }

  public int get(String str){
    return getValue(str);
  }

  public int getValue(String str){
    for (Object[] data : list){
      if (data[0].equals(str)){
        return (Integer)data[1];
      }
    }
    return 0;
  }

  public Object[] getKeyValuePair(String str){
    for (Object[] data : list){
      if (data[0].equals(str)){
        return data;
      }
    }
    return null;
  }
}
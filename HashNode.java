import java.util.*;
public class HashNode{
  public LinkedList<Object[]> list = new LinkedList<Object[]>();

  public HashNode(){

  }

  public void add(Object[] data){
    list.add(data);
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
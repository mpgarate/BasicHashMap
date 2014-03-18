import java.util.*;

public class HashTable {

  private final int TABLE_SIZE = 128;
  private HashNode[] table = new HashNode[TABLE_SIZE];


  //LinkedList<Integer>[] vertex = new LinkedList[5]; 
  public HashTable(){
    initializeTable();
  }

  public void add(String str, int value){
    int key = stringToHashKey(str);
    Object[] data = new Object[2];
    data[0] = str;
    data[1] = value;
    table[key].add(data);
  }

  public int get(String str){
    int key = stringToHashKey(str);
    int value = table[key].get(str);
    return value;
  }

  public int remove(String str){
    int key = stringToHashKey(str);
    int value = table[key].get(str);

    table[key].remove(str);

    return value;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < table.length; i++){
      for(Object[] data : table[i].list){
        sb.append(i + " : ");
        sb.append(data[0] + " : ");
        sb.append(data[1]);
        sb.append("\n");
      }
    }

    return sb.toString();
  }

  private int stringToHashKey(String string){
    int key = string.hashCode();
    key = Math.abs(key % TABLE_SIZE);
    return key;
  }

  // set default values to -999
  private void initializeTable(){
    for (int i = 0; i < table.length; i++){
      table[i] = new HashNode();
    }
  }
}

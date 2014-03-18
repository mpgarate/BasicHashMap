// Hash table with linked lists for collisions
//
// Supports add, get, update, remove, toString

public class HashTable {

  private int tableSize;
  private HashNode[] table;


  //LinkedList<Integer>[] vertex = new LinkedList[5]; 
  
  public HashTable(){
    this.tableSize = 128;
    initializeTable();
  }

  public HashTable(int tableSize){
    this.tableSize = tableSize;
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

  public int update(String str, int value){
    // create the new object
    int key = stringToHashKey(str);
    Object[] data = new Object[2];
    data[0] = str;
    data[1] = value;

    // get the previous value
    int oldValue = table[key].get(str);

    //update the value
    table[key].update(data);

    return oldValue;
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
        sb.append("index: " + i + " | ");
        sb.append(data[0] + " => ");
        sb.append(data[1]);
        sb.append("\n");
      }
    }

    return sb.toString();
  }

  private int stringToHashKey(String string){
    int key = string.hashCode();
    key = Math.abs(key % tableSize);
    return key;
  }

  // set default values to -999
  private void initializeTable(){
    this.table = new HashNode[this.tableSize];
    for (int i = 0; i < table.length; i++){
      table[i] = new HashNode();
    }
  }
}

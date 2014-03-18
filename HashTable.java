public class HashTable {

  private final int TABLE_SIZE = 128;
  private int[] table = new int[TABLE_SIZE];

  public HashTable(){
    initializeTable();
  }

  public void add(String str, int value){
    int key = stringToHashKey(str);
    table[key] = value;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < table.length; i++){
      if (table[i] != -999){
        sb.append(i + " : ");
        sb.append(table[i]);
        sb.append("\n");
      }
    }

    return sb.toString();
  }

  private int stringToHashKey(String string){
    int key = string.hashCode();
    key = Math.abs(key % TABLE_SIZE);
    System.out.println("key is: " + key);
    return key;
  }

  // set default values to -999
  private void initializeTable(){
    for (int i = 0; i < table.length; i++){
      table[i] = -999;
    }
  }
}

// instantiate and make use of the hash table
class HashRunner{
  public static void main(String[] args){
    HashTable hash = new HashTable();

    String key = "Michael";
    int value = 20;

    hash.add(key, value);

    System.out.println(hash.toString());
  }
}

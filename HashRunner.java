// instantiate and make use of the hash table
class HashRunner{
  public static void main(String[] args){
    HashTable hash = new HashTable();

    // store a key and print out the whole hash
    String m_key = "Michael";
    int m_value = 20;

    hash.add(m_key, m_value);
    System.out.println("Hash contains:");
    System.out.println(hash.toString());


    // store another key and get it back
    hash.add("Bill",500);
    int b_value = hash.get("Bill");
    System.out.println("Bill: " + b_value + "\n");

    // see that both keys are now in the hash
    System.out.println("Hash contains:");
    System.out.println(hash.toString());

    // remove a key and see that it is gone
    hash.remove("Michael");
    System.out.println();
    System.out.println("Hash contains:");
    System.out.println(hash.toString());

    // update a value
    hash.update("Bill",45);
    System.out.println();
    System.out.println("Hash contains:");
    System.out.println(hash.toString());


  }
}

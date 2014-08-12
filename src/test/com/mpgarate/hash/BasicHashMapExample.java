package com.mpgarate.hash;

class BasicHashMapExample {
  public static void main(String[] args){
    BasicHashMap hash = new BasicHashMap();

    // store a key and print out the whole hash
    String name = "Michael";
    Integer age = 22;

    hash.add(name, age);
    System.out.println("Hash contains:");
    System.out.println(hash.toString());


    // store another key and get it back
    hash.add("Bill",500);
    int billAge = hash.get("Bill");
    System.out.println("Bill: " + billAge + "\n");

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

    // make a table with a custom array size.
    // This is a table of size 1, so all elements
    // will be in the linked list at index 0.
    BasicHashMap miniTable = new BasicHashMap(1);
    
    miniTable.add("Michael",123);
    miniTable.add("Bill",456);
    miniTable.add("Carl",555);
    miniTable.add("Steve",50);
    miniTable.add("Nathan",20);
    miniTable.add("Prithvi",512);

    System.out.println();
    System.out.println("miniTable contains:");
    System.out.println(miniTable.toString());
  }
}

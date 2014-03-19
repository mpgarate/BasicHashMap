Java-Hash-Table
===============

Hash table with linked lists to handle collisions, created as an exercise. 

Keys are strings and values are of type int.

Built using Java hashCode and java.util.LinkedList. 

### Usage

Instantiate

~~~java
HashTable hash = new HashTable();
~~~

Store a key.

~~~java
String key = "Michael";
int value = 20;
hash.add(m_key, m_value);
~~~

Get a key.
~~~java
int value = hash.get("Michael"); // 20
~~~

Remove a key.
~~~java
hash.remove("Michael");
~~~

Update a value. 
~~~java
hash.add("Bill",22);
hash.update("Bill", 45);
int value = hash.get("Bill") //45
~~~

Initialize a table with a custom array size.
~~~java
// This is a table of size 1, so all elements
// will be in the linked list at index 0.
HashTable miniTable = new HashTable(1);
~~~

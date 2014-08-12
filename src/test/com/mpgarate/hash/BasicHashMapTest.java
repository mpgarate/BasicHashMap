package com.mpgarate.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mike on 8/12/2014.
 */
public class BasicHashMapTest {
    @Test
    public void basicUsageTest() {
        BasicHashMap map = new BasicHashMap();
        String name = "Michael";
        Integer age = 22;

        map.add(name, age);

        assertEquals((Object) age, map.get(name));
    }

    @Test
    public void genericTypeUsageTest() {
        BasicHashMap<Float, String> map = new BasicHashMap<Float, String>();
        Float key = 5.75f;

        String value = "lorem ipsum";

        map.add(key, value);
        assertEquals(value, map.get(key));
    }

    @Test
    public void removeEntryTest(){
        BasicHashMap<String, Integer> map = new BasicHashMap<String, Integer>();
        String name = "Michael";
        Integer age = 22;

        map.add(name, age);
        map.remove(name);
        assertEquals(null, map.get(name));
    }


    @Test
    public void integerAsKeyTest(){
        BasicHashMap<Integer, String> map = new BasicHashMap<Integer, String>();

        map.add(555, "Original Value");
        assertEquals("Original Value", map.get(555));
    }

    @Test
    public void updateEntryTest(){
        BasicHashMap<Integer, String> map = new BasicHashMap<Integer, String>();

        map.add(555, "Original Value");
        assertEquals("Original Value", map.get(555));

        map.update(555, "New Value");
        assertEquals("New Value", map.get(555));
    }

    @Test
    public void multipleEntriesTest(){
        BasicHashMap<String, Integer> map = new BasicHashMap<String, Integer>();
        map.add("Entry 1", 1);
        map.add("Entry 2", 2);

        assertEquals((Integer) 2, map.get("Entry 2"));
        map.remove("Entry 2");
        assertEquals(null, map.get("Entry 2"));

        map.add("Entry 3", 3);
        map.add("Entry 4", 4);
        map.add("Entry 5", 5);
        map.add("Entry 6", 6);

        assertEquals((Integer) 6, map.get("Entry 6"));
        assertEquals((Integer) 5, map.get("Entry 5"));
        assertEquals((Integer) 4, map.get("Entry 4"));
        assertEquals((Integer) 3, map.get("Entry 3"));
        assertEquals((Integer) 1, map.get("Entry 1"));
    }

    @Test
    public void customArraySizeTest(){
        BasicHashMap<String, Integer> map = new BasicHashMap<String, Integer>(1);
        assertEquals(1, map.getBucketSize());
    }
}

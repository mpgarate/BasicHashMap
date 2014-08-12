package com.mpgarate.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mike on 8/12/2014.
 */
public class BasicHashMapTest {
    @Test
    public void basicUsageTest(){
        BasicHashMap map = new BasicHashMap();
        String name = "Michael";
        Integer age = 22;

        map.add(name, age);

        assertEquals((Object)age, map.get(name));
    }

    @Test
    public void genericTypeUsageTest(){
        BasicHashMap<Float, String> map = new BasicHashMap<Float, String>();
        Float key = 5.75f;
        String value = "lorem ipsum";

        map.add(key, value);
        assertEquals(value, map.get(key));
    }
}

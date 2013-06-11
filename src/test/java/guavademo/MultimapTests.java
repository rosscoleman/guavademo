package guavademo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;

public class MultimapTests {

    @Test
    public void testMultimap() {
        //From Daniel Hinojosa's examples
        ArrayListMultimap<String, Integer> superBowlMap = ArrayListMultimap.create();
        superBowlMap.put("Dallas Cowboys", 1972);
        superBowlMap.put("Dallas Cowboys", 1993);
        superBowlMap.put("Dallas Cowboys", 1994);
        superBowlMap.put("Dallas Cowboys", 1996);
        superBowlMap.put("Dallas Cowboys", 1978);
        superBowlMap.put("Pittsburgh Steelers", 1975);
        superBowlMap.put("Pittsburgh Steelers", 1976);
        superBowlMap.put("Pittsburgh Steelers", 1979);
        superBowlMap.put("Pittsburgh Steelers", 1980);
        superBowlMap.put("Pittsburgh Steelers", 2006);
        superBowlMap.put("Pittsburgh Steelers", 2009);
        
        System.out.println(superBowlMap.get("Dallas Cowboys"));
        System.out.println(superBowlMap.get("Buffalo Bills"));
        
        assertEquals(5, superBowlMap.get("Dallas Cowboys").size());
        assertEquals(6, superBowlMap.get("Pittsburgh Steelers").size());
        assertEquals(0, superBowlMap.get("Buffalo Bills").size());
    }

}

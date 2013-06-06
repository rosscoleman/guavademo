package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class MapTests {

    @Test
    public void testImmutableMap() {
        Map<String, String> stateCapitalMap = new HashMap<String, String>();
        stateCapitalMap.put("Maine", "Augusta");
        stateCapitalMap.put("Maryland", "Annapolis");
        stateCapitalMap.put("Massachusetts", "Boston");
        stateCapitalMap.put("Michigan", "Lansing");
        stateCapitalMap.put("Minnesota", "St. Paul");
        stateCapitalMap.put("Mississippi", "Jackson");
        stateCapitalMap.put("Missouri", "Jefferson City");
        stateCapitalMap.put("Montana", "Helena");
        
        assertEquals("Jefferson City", stateCapitalMap.get("Missouri"));
        assertEquals(null, stateCapitalMap.get("Jefferson City"));
        
        Map<String, String> immutable = ImmutableMap.copyOf(stateCapitalMap);
        try {
            immutable.put("Arizona", "Phoenix");
            fail();
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't add to an immutable map");
        }
    }
    
    @Test
    public void testImmutableMapOfMethod() {
        //This works fine
        Map<Integer, String> numMap = ImmutableMap.of(1, "one", 2, "two", 
                                                      3, "three");
        assertEquals("two", numMap.get(2));
        

        //We can only add up to five states & capitals this way
        //ImmutableMap.of is overloaded for up to 5 key/value pairs
        //varargs in Java have limitations with generic types
        Map<String, String> stateCapitalMap = ImmutableMap.of(
                    "Maine", "Augusta",
                    "Maryland", "Annapolis",
                    "Massachusetts", "Boston",
                    "Michigan", "Lansing",
                    "Minnesota", "St. Paul"//,
                    //"Mississippi", "Jackson",
                    //"Missouri", "Jefferson City",
                    //"Montana", "Helena"
        );
        
        assertEquals("Augusta", stateCapitalMap.get("Maine"));
    }
    
    @Test
    public void testImmutableMapBuilder() {        
        // Lets try the builder pattern to construct the map, 
        // because ImmutableMap.of() is limited to 5 key/value pairs
        Map<String, String> immutable = ImmutableMap.<String, String>builder()
                .put("Maine", "Augusta")
                .put("Maryland", "Annapolis")
                .put("Massachusetts", "Boston")
                .put("Michigan", "Lansing")
                .put("Minnesota", "St. Paul")
                .put("Mississippi", "Jackson")
                .put("Missouri", "Jefferson City")
                .put("Montana", "Helena")
                .build();
        
        assertEquals("Helena", immutable.get("Montana"));
        //immutableStateCapitalMap.put("Arizona", "Phoenix");
        
    }
}
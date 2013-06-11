package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

public class BiMapTests {
    
    private Map<String, String> stateCodeMap;
    
    @Before
    public void setUp() {
        stateCodeMap = ImmutableMap.<String, String>builder()
                .put("Maine", "ME")
                .put("Maryland", "MD")
                .put("Massachusetts", "MA")
                .put("Michigan", "MI")
                .put("Minnesota", "MN")
                .put("Mississippi", "MS")
                .put("Missouri", "MO")
                .put("Montana", "MT")
                .build();
    }

    @Test
    public void testMap() {
        assertEquals("MO", stateCodeMap.get("Missouri"));
        assertNull(stateCodeMap.get("MO"));
    }
    
    @Test
    public void testBiMap() {
        BiMap<String, String> biMap = HashBiMap.<String, String>create();
        biMap.putAll(stateCodeMap);
        
        assertEquals(8, biMap.size());
        assertEquals("MO", biMap.get("Missouri"));
        System.out.println(biMap);
        
        // How do we go the opposite direction?
        assertNull(biMap.get("MO")); //Not this
        // Use BiMap.inverse() to get the inverse map
        assertEquals("Missouri", biMap.inverse().get("MO")); 
        
        BiMap<String, String> inverseBiMap = biMap.inverse();
        System.out.println(inverseBiMap);
        assertNull(inverseBiMap.get("AZ"));
        inverseBiMap.put("AZ", "Arizona");
        assertEquals("Arizona", inverseBiMap.get("AZ"));
        
        //We changed the original map too! Inverse BiMap is a view.
        assertEquals("AZ", biMap.get("Arizona")); 
        System.out.println(biMap);
        System.out.println(inverseBiMap);
        
        //This will fail because "MO" is already a value, and BiMaps are 1-1
        //biMap.put("Mordor", "MO"); 
        
        // forcePut() will get rid of the key that was already
        // associated with the value
        biMap.forcePut("Mordor", "MO"); 
        System.out.println(biMap);
    }
    
    @Test
    public void testImmutableBiMap() {
        BiMap<String, String> biMap = ImmutableBiMap.of(
                "Alabama", "AL", 
                "Alaska", "AK", 
                "Arizona", "AZ", 
                "Arkansas", "AR");
        
        assertEquals(4, biMap.size());
        assertEquals("AL", biMap.get("Alabama"));
        System.out.println(biMap);
        
        // How do we go the opposite direction?
        assertNull(biMap.get("AL")); //Not this
        // Use BiMap.inverse() to get the inverse map
        assertEquals("Alabama", biMap.inverse().get("AL")); 
    }

}

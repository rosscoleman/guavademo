package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
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
		
		// How do we go the opposite direction?
		assertNull(biMap.get("MO")); //Not this
		assertEquals("Missouri", biMap.inverse().get("MO")); // Use BiMap.inverse() to get the inverse map
		
		BiMap<String, String> inverseBiMap = biMap.inverse();
		assertNull(inverseBiMap.get("AZ"));
		inverseBiMap.put("AZ", "Arizona");
		assertEquals("Arizona", inverseBiMap.get("AZ"));
		assertEquals("AZ", biMap.get("Arizona")); //We changed the original map too! Inverse BiMap is a view.
	}

}

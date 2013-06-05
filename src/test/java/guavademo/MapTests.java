package guavademo;

import static org.junit.Assert.assertEquals;

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
		
		Map<String, String> immutableStateCapitalMap = ImmutableMap.copyOf(stateCapitalMap);
		try {
			immutableStateCapitalMap.put("Arizona", "Phoenix");
		} catch (UnsupportedOperationException e) {
			System.out.println("Can't add to an immutable map");
		}
		}
	
	@Test
	public void testImmutableMapOfMethod() {
		//This works fine
		Map<Integer, String> numMap = ImmutableMap.of(1, "one", 2, "two", 3, "three");
		assertEquals("two", numMap.get(2));
		

		//We can only add so many states and capitals before we run into problems
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
		//The of method overloads many possibilities, but eventually has to use varargs
		//Varargs have limitations with generic types in Java
		
		assertEquals("Augusta", stateCapitalMap.get("Maine"));
	}
	
	@Test
	public void testImmutableMapBuilder() {		
		//Lets try the builder pattern to construct the map, because ImmutableMap.of() is limited
		Map<String, String> stateCapitalMap = ImmutableMap.<String, String>builder()
				.put("Maine", "Augusta")
				.put("Maryland", "Annapolis")
				.put("Massachusetts", "Boston")
				.put("Michigan", "Lansing")
				.put("Minnesota", "St. Paul")
				.put("Mississippi", "Jackson")
				.put("Missouri", "Jefferson City")
				.put("Montana", "Helena")
				.build();
		
		assertEquals("Helena", stateCapitalMap.get("Montana"));
		//immutableStateCapitalMap.put("Arizona", "Phoenix");
		
	}
}
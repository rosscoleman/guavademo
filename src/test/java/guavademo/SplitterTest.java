package guavademo;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class SplitterTest {

	@Test
    public void simpleSplit() {
        Iterable<String> items = Splitter.on(",").trimResults().split("Larry, Curly, Mo");
        List<String> itemList = Lists.newArrayList(items);
        assertEquals("Larry", itemList.get(0));
        assertEquals("Curly", itemList.get(1));
        assertEquals("Mo", itemList.get(2));
    }
	
	@Test
	public void mapSplit() {
	    String value = "New Mexico -> Santa Fe, Texas -> Austin, Arizona -> Phoenix";
	    Map<String, String> splitKeyValues = Splitter.on(",")
	            .omitEmptyStrings()
	            .trimResults()
	            .withKeyValueSeparator(" -> ")
	            .split(value);
	     assertEquals(splitKeyValues.size(), 3);
	     assertEquals("Santa Fe", splitKeyValues.get("New Mexico"));
	     
	}
}

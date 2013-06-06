package guavademo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

public class JoinerTests {

    @Test
    public void testJava() {
        List<String> list = Arrays.asList("Larry", "Curly", "Mo");
        StringBuilder sb = new StringBuilder();
        boolean started = false;
        for (String item : list) {
            if (started)
                sb.append(", ");
            sb.append(item);
            started = true;
        }
        String joined = sb.toString();
        assertEquals("Larry, Curly, Mo", joined);
    }

    @Test
    public void testJoiner() {
        List<String> list = Arrays.asList("Larry", "Curly", "Mo");
        String joined = Joiner.on(", ").join(list);
        assertEquals("Larry, Curly, Mo", joined);
    }

    @Test
    public void testUseWithMapJavaStyle() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("New Mexico", "Santa Fe");
        map.put("Texas", "Austin");
        map.put("Arizona", "Phoenix");
        
        StringBuffer stringBuffer = new StringBuffer();
        boolean started = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (started)
                stringBuffer.append(", ");
            stringBuffer.append(entry.getKey());
            stringBuffer.append(" -> ");
            stringBuffer.append(entry.getValue());
            started = true;
        }
        String joined = stringBuffer.toString();
        
        assertEquals("New Mexico -> Santa Fe, Texas -> Austin, Arizona -> Phoenix",
                     joined);
    }

    @Test
    public void testUseWithMap() {
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("New Mexico", "Santa Fe");
        map.put("Texas", "Austin");
        map.put("Arizona", "Phoenix");
        
        String joined = Joiner.on(", ").withKeyValueSeparator(" -> ").join(map);
        
        assertEquals("New Mexico -> Santa Fe, Texas -> Austin, Arizona -> Phoenix",
                     joined);
    }
    
    @Test
    public void testUseWithImmutableMap() {
        String joined = Joiner.on(", ").withKeyValueSeparator(" -> ").join(
            ImmutableMap.of("New Mexico", "Santa Fe", 
                            "Texas", "Austin",
                            "Arizona", "Phoenix")
        );
        
        assertEquals("New Mexico -> Santa Fe, Texas -> Austin, Arizona -> Phoenix", 
                     joined);
    }

}

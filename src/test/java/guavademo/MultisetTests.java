package guavademo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultisetTests {

    @Test
    public void testMultiset() {
        //Multiset is also known as a bag
        //From Daniel Hinojosa's examples
        
        Multiset<String> worldCupChampionships = HashMultiset.<String>create();
        worldCupChampionships.add("Brazil");
        worldCupChampionships.add("Brazil");
        worldCupChampionships.add("Brazil");
        worldCupChampionships.add("Brazil");
        worldCupChampionships.add("Brazil");
        worldCupChampionships.add("Italy");
        worldCupChampionships.add("Italy");
        worldCupChampionships.add("Italy");
        worldCupChampionships.add("Italy");
        worldCupChampionships.add("Germany", 3); //explicitly add count
        
        assertEquals(5, worldCupChampionships.count("Brazil"));
        assertEquals(4, worldCupChampionships.count("Italy"));
        assertEquals(3, worldCupChampionships.count("Germany"));
        
        //This doesn't give an exception... just says its in there zero times
        assertEquals(0, worldCupChampionships.count("United States"));
    }

}

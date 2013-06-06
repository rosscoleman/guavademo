package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class SetTests {

	@Test
	public void testSet() {
		List<Integer> l = ImmutableList.of(3, 1, 2, 2, 3, 1);
		Set<Integer> s = new TreeSet<Integer>(l);
		assertEquals("[1, 2, 3]", s.toString());
		s.add(10);
		s.add(1);
		s.add(4);
		assertEquals("[1, 2, 3, 4, 10]", s.toString());
	}
	
	@Test
	public void testSetGuava() {
		List<Integer> l = ImmutableList.of(3, 1, 2, 2, 3, 1);
		Set<Integer> s = Sets.newTreeSet(l);
		assertEquals("[1, 2, 3]", s.toString());
	}
	
	@Test
	public void testImmutableSet() {
		Set<Integer> s = ImmutableSet.of(1, 2, 3, 1, 2, 3);
		assertEquals("[1, 2, 3]", s.toString());
		try {
			s.add(4);
			fail("Shouldn't be able to add to an ImmutableSet.");
		} catch (UnsupportedOperationException e) {
			System.out.println("Can't change an immutable set");
		}
	}

}

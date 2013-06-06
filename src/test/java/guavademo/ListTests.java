package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ListTests {

	@Test
	public void testList() {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		
		assertEquals("[1, 2, 3]", l.toString());
		l.set(2, 10);
		assertEquals("[1, 2, 10]", l.toString());
	}
	
	@Test
	public void testJavaListShortcut() {
		List<Integer> l = Arrays.asList(1, 2, 3);
		
		assertFalse( l instanceof ArrayList );
		
		assertEquals("[1, 2, 3]", l.toString());
		l.set(2, 10);
		assertEquals("[1, 2, 10]", l.toString());
	}
	
	@Test
	public void testGuavaList() {
		List<Integer> arrayList = Lists.newArrayList(1, 2, 3);

		assertEquals(ArrayList.class, arrayList.getClass());
		assertEquals("[1, 2, 3]", arrayList.toString());
		arrayList.set(2, 10);
		assertEquals("[1, 2, 10]", arrayList.toString());
	}
	
	@Test
	public void testGuavaImmutableList() {
		List<Integer> l = ImmutableList.of(1, 2, 3);
		try {
			l.set(2, 10);
			fail();
		} catch (UnsupportedOperationException e) {
			System.out.println("You can't change an immutable list");
		}
	}
	
	@Test
	public void testJavaUnmodifiableList() {
		// Java doesn't really have immutable collections
		// "Unmodifiable" collections really aren't the same thing
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		
		List<Integer> unmodifiableList = Collections.unmodifiableList(l);
		try {
			unmodifiableList.add(4);
			fail();
		} catch (UnsupportedOperationException e) {
			System.out.println("You can't modify a collection using an unmodifiable reference.");
		}
		
		assertEquals("[1, 2, 3]", unmodifiableList.toString());
		l.add(4);
		// However, you can still modify it if you have the original reference.
		assertEquals("[1, 2, 3, 4]", l.toString());
		// And your modification shows up in the "unodifiable list"
		assertEquals("[1, 2, 3, 4]", unmodifiableList.toString());
		
	}

}

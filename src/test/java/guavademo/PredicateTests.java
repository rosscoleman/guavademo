package guavademo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.math.DoubleMath;

public class PredicateTests {

	@Test
	public void testPredicateFilter() {
		Predicate<Integer> isPerfectSquare = new Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				double sqrt = Math.sqrt(input);
				return DoubleMath.isMathematicalInteger(sqrt); //This is a Guava math function
			}
		};
		
		Predicate<Integer> isOdd = new Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				return input % 2 == 1;
			}
		};
		
		List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
		Collection<Integer> perfectSquares = Collections2.filter(ints, isPerfectSquare);
		assertEquals("[1, 4, 9, 16]", perfectSquares.toString());
		ints.add(17);
		ints.add(25);
		
		//perfectSquares is a view so it now has 25 as well
		assertEquals("[1, 4, 9, 16, 25]", perfectSquares.toString());
		
		perfectSquares.add(36); //We can actually add an element to the view
		assertTrue(perfectSquares.contains(36));
		assertTrue(ints.contains(36)); //Adding to the view added it to the original list
		
		Collection<Integer> oddSquares = Collections2.filter(ints, Predicates.and(isPerfectSquare, isOdd));
		assertEquals("[1, 9, 25]", oddSquares.toString());
	}
}

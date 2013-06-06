package guavademo;

//Adapted from Daniel Hinojosa's code to use JUnit instead of TestNG

/**
 * Copyright 2010-2013 Daniel Hinojosa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * Created by Daniel Hinojosa
 * User: Daniel Hinojosa
 * Date: 03 Mar 13, 2010, 2010
 * Time: 9:44:29 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class FunctionTests {

    @Test()
    public void testTransformWithCollections2() {
        Function<Integer, Integer> doubleIt = new Function<Integer, Integer>() {
            public Integer apply(Integer from) {
                return from * 2;
            }
        };

        Collection<Integer> untransformed = Lists
                .newArrayList(1, 5, 6, 8, 9, 10, 44, 55, 19);
        Collection<Integer> transformed = Collections2.transform(untransformed, doubleIt);

        assertEquals("[2, 10, 12, 16, 18, 20, 88, 110, 38]", transformed.toString());

        assertEquals("[1, 5, 6, 8, 9, 10, 44, 55, 19]", untransformed.toString());
    }

    @Test()
    public void testTransformWithLists() {
        Function<Integer, Integer> doubleIt = new Function<Integer, Integer>() {
            public Integer apply(Integer from) {
                return from * 2;
            }
        };

        List<Integer> untransformed = Lists.newArrayList(1, 5, 6, 8, 9, 10, 44, 55, 19);
        List<Integer> transformed = Lists.transform(untransformed, doubleIt);

        assertEquals("[2, 10, 12, 16, 18, 20, 88, 110, 38]", transformed.toString());
    }

    @Test()
    public void testTransformOdd() {
        Function<Integer, Boolean> oddIt = new Function<Integer, Boolean>() {
            public Boolean apply(Integer from) {
                return from % 2 == 0;
            }
        };

        Collection<Integer> untransformed = Lists.newArrayList(1, 5, 6, 8, 9, 10, 44, 55, 19);
        assertEquals( "[false, false, true, true, false, true, true, false, false]",
        		Collections2.transform(untransformed, oddIt).toString());
        assertEquals("[1, 5, 6, 8, 9, 10, 44, 55, 19]", untransformed.toString());
    }
}


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

class UnitTests {
	static IFn aliceThird, aliceMember, cljMap, cljIntersect;
	static IFn jessAppend, jessSame;

	@BeforeAll
	static void requires() {
        var require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("Jess"));
		require.invoke(Clojure.read("Evan"));

		aliceThird = Clojure.var("Alice", "third");
		aliceMember = Clojure.var("Evan","member");
		cljMap = Clojure.var("Evan","map");
		cljIntersect = Clojure.var("Evan","intersect");
		jessAppend = Clojure.var("Jess", "append");
		jessSame = Clojure.var("Jess","same");
	}

	@Test
	void testThird() {
		var list = List.of("A", "B", "C", "D", "E");
		assertEquals("C", Alice.third(list));
		assertEquals("C", aliceThird.invoke(list));
	}

	@Test
	void testMember() {
		var list = List.of("X", "Y", "Z");
		assertTrue(Jess.member("Y", list));
		assertFalse(Jess.member("A", list));
		assertTrue((Boolean) aliceMember.invoke("Y", list));
		assertFalse((Boolean) aliceMember.invoke("A", list));
	}

	@Test
	void testAppend() {
		var list1 = List.of("a", "b");
		var list2 = List.of("c", "d");
		var expected = List.of("a", "b", "c", "d");

		assertEquals(expected, Matt.append(list1,list2));
		assertEquals(expected, jessAppend.invoke(list1,list2));
	}

	@Test
	void testSame() {
		var list1 = List.of(1, 2, 3);
        var list2 = List.of(1, 2, 3);
        var list3 = List.of(1, 2, 4);

        assertTrue(Matt.same(list1, list2));
        assertFalse(Matt.same(list1, list3));

        assertTrue((Boolean) jessSame.invoke(list1, list2));
		assertFalse((Boolean) jessSame.invoke(list1, list3));
    }

	@Test
	void testMap() {
		var input = List.of(1, 2, 3);
        var expected = List.of(2, 4, 6);
        Function<Integer, Integer> doubler = x -> x * 2;

        assertEquals(expected, Matt.map(doubler, input));

		IFn eval = Clojure.var("clojure.core", "eval");
		IFn readString = Clojure.var("clojure.core", "read-string");
		IFn cljDoubler = (IFn) eval.invoke(readString.invoke("(fn [x] (* 2 x))"));
		assertEquals(List.of(2L, 4L, 6L), cljMap.invoke(cljDoubler, input));

    }

	@Test
	void testIntersect() {
		var list1 = List.of("a", "b", "c");
        var list2 = List.of("b", "c", "d");
        var expected = List.of("b", "c");

        assertEquals(expected, Jess.intersect(list1, list2));
        assertEquals(expected, cljIntersect.invoke(list1, list2));
	}
}
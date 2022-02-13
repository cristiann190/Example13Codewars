package src;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObservedPinTest {

	public static HashMap<String, String[]> expectations = new HashMap<>() {
		{
			put("8", new String[]{"5", "7", "8", "9", "0"});
			put("11", new String[]{"11", "21", "41", "12", "22", "42", "14", "24", "44"});
			put("369", new String[]{"236", "238", "239", "256", "258", "259", "266", "268", "269", "296", "298", "299", "336", "338", "339", "356", "358", "359", "366", "368", "369", "396", "398", "399", "636", "638", "639", "656", "658", "659", "666", "668", "669", "696", "698", "699"});
		}
	};
	private final static Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);

	@Test
	public void testPins() {
		for (String entered : expectations.keySet()) {
			final List<String> strings = Arrays.asList(expectations.get(entered));
			final List<String> piNs = ObservedPin.getPINsOptimized(entered);
			test(entered, strings, piNs);
		}
	}

	private void test(String entered, List<String> expected, List<String> result) {
		result.sort(comp);
		expected.sort(comp);
		assertEquals(expected, result, "For observed PIN " + entered);
	}
}
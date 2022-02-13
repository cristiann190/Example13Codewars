package src;

import java.util.*;

public class ObservedPin {

	public static List<String> getPINs(String observed) {
		inicializeOptions();
		StringBuilder option = new StringBuilder();
		if (observed.length() == 1) {
			return Arrays.asList(numberOptions.get(observed.charAt(0)));
		}
		for (String digit : numberOptions.get(observed.charAt(0))) {
			final String substring = observed.substring(1);
			option.append(appendOptions(substring, digit));
		}
		String list = option.toString();
		list = list.substring(0, list.length() - 1);

		return Arrays.asList(list.split(","));
	}

	private static String appendOptions(String number, String previous) {
		StringBuilder options = new StringBuilder();
		for (String digit : numberOptions.get(number.charAt(0))) {
			if (number.length() > 1) {
				final String substring = number.substring(1);
				options.append(appendOptions(substring, previous + digit));
			} else {
				options.append(previous + digit).append(",");
			}
		}
		return options.toString();
	}

	static HashMap<Character, String[]> numberOptions = new HashMap<>();

	private static void inicializeOptions() {
		numberOptions.put('1', new String[]{"1", "2", "4"});
		numberOptions.put('2', new String[]{"2", "1", "3", "5"});
		numberOptions.put('3', new String[]{"3", "2", "6"});
		numberOptions.put('4', new String[]{"4", "1", "5", "7"});
		numberOptions.put('5', new String[]{"5", "2", "4", "6", "8"});
		numberOptions.put('6', new String[]{"6", "3", "5", "9"});
		numberOptions.put('7', new String[]{"7", "4", "8"});
		numberOptions.put('8', new String[]{"8", "0", "5", "7", "9"});
		numberOptions.put('9', new String[]{"9", "6", "8"});
		numberOptions.put('0', new String[]{"0", "8"});
	}

//	---------OPTIMIZED--------------

	static Map<Character, String> map = new HashMap<>();

	public static List<String> getPINsOptimized(String observed) {
		List<String> pins = new ArrayList<>();

		map.put('1', "124");
		map.put('2', "1235");
		map.put('3', "236");
		map.put('4', "1457");
		map.put('5', "24568");
		map.put('6', "3569");
		map.put('7', "478");
		map.put('8', "05789");
		map.put('9', "689");
		map.put('0', "08");

		fillPins(observed, "", 0, pins);

		return pins;
	}

	public static void fillPins(String observed, String current, int index, List<String> pins) {
		String possibilities = map.get(observed.charAt(index));

		for (char c : possibilities.toCharArray()) {
			if (index < observed.length() - 1) {
				fillPins(observed, current + c, index + 1, pins);
			} else {
				pins.add(current + c);
			}
		}
	}


}



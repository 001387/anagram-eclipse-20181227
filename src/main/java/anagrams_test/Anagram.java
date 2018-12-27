package anagrams_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

	public static List<String> of(String input) {
		if (input.length() <= 1) {
			return Arrays.asList(input);
		}
		
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < of(dropChar(input, i)).size(); j++) {
				result.add(input.substring(i, i+1) + of(dropChar(input, i)).get(j));
			}
		}
		return result;
	}

	private static String dropChar(String input,int index) {
		return input.substring(0, index) + input.substring(index + 1,input.length());
	}
}

package anagrams_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
	
	public static List<String> ofForStepOne(String input) {
		return Arrays.asList(input);
	}
	
	public static List<String> ofForStepTwo(String input) {
		return Arrays.asList(input);
	}

	public static List<String> ofForStepOneAndTwo(String input) {
		return Arrays.asList(input);
	}
	
	public static List<String> ofForStepThree(String input) {
		if (input.length() <= 1) {
			return Arrays.asList(input);
		}
		return Arrays.asList(input, input.substring(1, 1) + input.substring(0, 1));
	}
	
	public static List<String> ofForStepFour(String input) {
		if (input.length() <= 1) {
			return Arrays.asList(input);
		}
		return Arrays.asList(
				input.substring(0, 1) + "bc",
				input.substring(0, 1) + "cb",
				input.substring(1, 2) + ofForStepFour(dropChar(input, 1)).get(1),
				input.substring(1, 2) + ofForStepFour(dropChar(input, 1)).get(2),
				"cab",
				"cba");
	}
	
	public static List<String> ofForStepFive(String input) {
		if (input.length() <= 1) {
			return Arrays.asList(input);
		}
		
		if(input.length() == 2) {
			return Arrays.asList(input,input.substring(1, 2) + input.substring(0, 1));
		}
		return Arrays.asList(
				input.substring(0, 1) + ofForStepFive(dropChar(input, 0)).get(0),
				input.substring(0, 1) + ofForStepFive(dropChar(input, 0)).get(1),
				input.substring(1, 2) + ofForStepFive(dropChar(input, 1)).get(0),
				input.substring(1, 2) + ofForStepFive(dropChar(input, 1)).get(1),
				input.substring(2, 3) + ofForStepFive(dropChar(input, 2)).get(0),
				input.substring(2, 3) + ofForStepFive(dropChar(input, 2)).get(1));
	}
	
	public static List<String> ofForStepEnd(String input) {
		if (input.length() <= 1) {
			return Arrays.asList(input);
		}
		
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < ofForStepEnd(dropChar(input, i)).size(); j++) {
				result.add(input.substring(i, i+1) + ofForStepEnd(dropChar(input, i)).get(j));
			}
		}
		return result;
	}

	private static String dropChar(String input,int index) {
		return input.substring(0, index) + input.substring(index + 1,input.length());
	}
}

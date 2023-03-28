package leetCode;

import java.util.Scanner;
import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.print("Please put in the Roman Numeral so it can be converted to an Integer! ");

		System.out.print("\n" + toInteger(input.nextLine()));
	}

	private static int toInteger(String input) {
		// TODO Auto-generated method stub

		int answer = 0;
		char currentLetter = ' ';
		char nextLetter = ' ';
		int currentValue = 0;
		int nextValue = 0;
		int counter = 0;

		HashMap<Character, Integer> valueOfNumerals = new HashMap<Character, Integer>();

		valueOfNumerals.put('I', 1);
		valueOfNumerals.put('V', 5);
		valueOfNumerals.put('X', 10);
		valueOfNumerals.put('L', 50);
		valueOfNumerals.put('C', 100);
		valueOfNumerals.put('D', 500);
		valueOfNumerals.put('M', 1000);

		for (int i = input.length() - 1; i > 0; i--) {

			currentLetter = input.charAt(i);
			nextLetter = input.charAt(i - 1);
			currentValue = (valueOfNumerals.get(currentLetter));
			nextValue = valueOfNumerals.get(nextLetter);

			answer += currentValue;
			if (nextValue == 1 && (currentValue == 5 || currentValue == 10)) {
				if (i == 1) {
					counter++;
				}

				answer = answer - nextValue;

				i--;

			}

			else if (nextValue == 10 && (currentValue == 50 || currentValue == 100)) {
				if (i == 1) {
					counter++;
				}

				answer -= nextValue;
				i--;

			} else if (nextValue == 100 && (currentValue == 500 || currentValue == 1000)) {

				if (i == 1) {
					counter++;
				}
				answer -= nextValue;
				i--;

			}

		}
		if (counter != 1) {
			answer += valueOfNumerals.get(input.charAt(0));

		}

		return answer;
	}
}

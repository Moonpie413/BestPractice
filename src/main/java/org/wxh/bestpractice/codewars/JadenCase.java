package org.wxh.bestpractice.codewars;

/**
 * Created by wangxh on 16-11-19.
 * package org.wxh.bestpractice.codewars
 * des
 */
public class JadenCase {
   	public static String toJadenCase(String phrase) {
		String result = "";
		if (phrase != null && phrase.length() != 0) {
            String[] strings = phrase.split(" ");
			for (String word : strings) {
				word = word.substring(0, 1).toUpperCase() + word.substring(1) + " ";
				result += word;
			}
			return result.substring(0, result.length() - 1);
		}
		return null;
	}

	public static void main(String[] args) {
		String test = "How can mirrors be real if our eyes aren't real";
		System.out.println(JadenCase.toJadenCase(test));
	}
}

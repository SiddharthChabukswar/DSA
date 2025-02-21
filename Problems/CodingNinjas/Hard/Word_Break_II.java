package CodingNinjas.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

https://www.naukri.com/code360/problems/983635?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

https://leetcode.com/problems/word-break-ii/description/

Problem statement
You are given a non-empty string S containing no spaces’ and a dictionary of non-empty strings (say the list of words). You are supposed to construct and return all possible sentences after adding spaces in the originally given string ‘S’, such that each word in a sentence exists in the given dictionary.

Note :

The same word in the dictionary can be used multiple times to make sentences.
Assume that the dictionary does not contain duplicate words.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10
1 <= K <= 100
1 <= | word | <= 16
1 <= | S | <= 13

where |word| is the length of each word in the dictionary and |S| is the length of the string S.

Time Limit: 1 sec
Sample Input 1:
1
6
god is now no where here
godisnowherenowhere
Sample Output 1:
god is no where no where
god is no where now here
god is now here no where
god is now here now here
Explanation to Sample Input 1:
One way to make sentences is to take “god” and append a space, then take “is”  and append space, take “now” from the dictionary and take “here” as well. 
Similarly, for other sentences also, we can add space to get other possible sentences. Note that we can reuse dictionary words as “no” and “now” are used two times in the same sentence.
Sample Input 2:
1
4
god is no here
godisnowhere
Sample Output 2:
No output to be printed
Explanation to Sample Input 2:
We can not make any sentence because after making “god is no” we will be stuck with “where”. There is no way to break “where” further such that we can get any word from the dictionary.

*/
public class Word_Break_II {

	private static String getSpacedString(final String s, final List<Integer> spaceIndices) {
		int currIdx = 0, nextIdx;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i<spaceIndices.size(); i++) {
			nextIdx = spaceIndices.get(i)+1;
			stringBuilder.append(s.substring(currIdx, nextIdx) + " ");
			currIdx = nextIdx;
		}
		stringBuilder.append(s.substring(currIdx, s.length()));
		return stringBuilder.toString();
	}

	private static boolean isStringSentence(final String spacedString, final Set<String> dictionarySet) {
		for (String word: spacedString.split(" ")) {
			if (!dictionarySet.contains(word)) {
				return false;
			}
		}
		return true;
	}

	private static void wordBreakRecursive(final String s, final Set<String> dictionarySet, final int currIdx, final List<Integer> spaceIndices, final ArrayList<String> answerList) {
		if (currIdx == s.length()-1) {
			String spacedString = getSpacedString(s, spaceIndices);
			if (isStringSentence(spacedString, dictionarySet)) {
				// System.out.println(spacedString);
				answerList.add(spacedString);
			}
			return;
		}
		wordBreakRecursive(s, dictionarySet, currIdx+1, spaceIndices, answerList);
		spaceIndices.add(currIdx);
		wordBreakRecursive(s, dictionarySet, currIdx+1, spaceIndices, answerList);
		spaceIndices.remove(spaceIndices.size()-1);
	}

	// Backtracking TLE
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		ArrayList<String> answerList = new ArrayList<>();
		final Set<String> dictionarySet = new HashSet<>();
		for (String word: dictionary) {
			dictionarySet.add(word);
		}
		wordBreakRecursive(s, Collections.unmodifiableSet(dictionarySet), 0, new ArrayList<>(), answerList);
		return answerList;
	}

}
// url: https://leetcode.com/problems/word-ladder/description/
package wordladder;

import java.util.*;

public class Solution {

	/** Ctrl + C starts here **/

	public int ladderLength(String beginWord, String endWord,
	                        List<String> wordList) {
		int len = beginWord.length();
		if(wordList.contains(endWord)==false) return 0;

		if (check(beginWord, endWord, len))
			return 2;

		int s = wordList.size();

		// add a map
		HashMap<String, List<String>> map = new HashMap<>();
		List<String> beginList = new ArrayList<>();
		map.put(beginWord, beginList);
		List<String> endList = new ArrayList<>();
		map.put(endWord, endList);

		wordList.forEach(item -> {
			List<String> itemList = map.getOrDefault(item,new ArrayList<>());
			map.put(item, itemList);
			if (check(beginWord, item, len)) {
				beginList.add(item);
				itemList.add(beginWord);
			}
			if (check(endWord, item, len)) {
				endList.add(item);
				itemList.add(endWord);
			}
		});



		for (int i = 0; i < s - 1; i++) {
			String source = wordList.get(i);
			List<String> listSource = map.get(source);
			for (int j = i + 1; j < s; j++) {
				String target = wordList.get(j);
				if (check(source, target, len)) {
					List<String> listTarget = map.get(target);
					listSource.add(target);
					listTarget.add(source);
				}
			}
		}

		int count = 1;
		Queue<String> q = new LinkedList<>();
		Set<String> set = new HashSet<>();
		q.add(beginWord);
		count++;
		while (true) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				String word = q.poll();
				List<String> list = map.get(word);
				for (String next : list) {
					if (next.equals(endWord))
						return count;
					if (set.contains(next) == false) {
						set.add(next);
						q.add(next);
						System.out.println(word+" " +next);
					}
				}
			}
			count++;
			if(count>s)
				return 0;
		}
	}

	private boolean check(String word1, String word2, int len) {
		int count = 0;
		for (int i = 0; i < len; i++) {
			char c1 = word1.charAt(i);
			char c2 = word2.charAt(i);
			if (c1 != c2) {
				count++;
				if (count == 2)
					return false;
			}
		}
		return (count == 1);
	}

	/** Ctrl + C ends here **/

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.test();
	}
	public void test() {
		System.out.println("Test starts!");
		System.out.println("Good Luck!");
		System.out.println("");
		String start = "a";
		String end = "b";

		System.out.println(ladderLength(
		    start, end,
		    Arrays.asList(new String[] {"a", "b", "c"})));
	}
}


public class MaxRepeatingString {
	public int maxRepeating(String sequence, String word) {
		int cur = 0;
		int[] records = new int[sequence.length()];

		int wordLen = word.length();
		int ans = 0;
		while ((cur = sequence.indexOf(word, cur)) != -1) {
			records[cur] = 1;
			if (cur - wordLen >= 0 && records[cur] != 0) {
				records[cur] = records[cur - wordLen] + 1; // records[cur-wordLen] means the maximum repeated in
															// sequence[0...cur-wordLen]
			}

			ans = Math.max(ans, records[cur]);
			cur++;
		}

		return ans;
	}
}

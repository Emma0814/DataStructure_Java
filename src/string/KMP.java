package string;

/**
 * Implementation of KMP algorithm, which utilizes partial match table to avoid repeated element
 * @author emmajing
 *
 */
public class KMP {
	
	/**
	 * 计算部分匹配表
	 * @param pattern 匹配字符串
	 * @return
	 */
	public int[] getNext(String pattern) {
		int[] next = new int[pattern.length()];
        next[0] = 0;
        int pre = 0; // preFix
        // Traverse the whole pattern from index 1
        for (int suf = 1; suf < pattern.length(); suf++) {
            while (pre != 0 && pattern.charAt(suf) != pattern.charAt(pre))
            	pre = next[pre - 1]; // 字符不相等，且不是第一位，preFix 回溯
            if (pattern.charAt(suf) == pattern.charAt(pre))
            	pre++;         // 字符相等，比较下一位
            next[suf] = pre;
        }
        return next;
	}
	
	public int kmp(String text, String pattern) {
		if(text == null || pattern == null || text.length() == 0 || pattern.length() == 0)
			return -1;
		int[] next = getNext(pattern);
		// 遍历 text
		for (int textIndex = 0, patternIndex = 0; textIndex < text.length(); textIndex++) {
			while (patternIndex != 0 && text.charAt(textIndex) != pattern.charAt(patternIndex)) {
				// 移动位置 = 已匹配字符数 - 对应部分匹配值
				// move = patternIndex - next[patternIndex -1]
				patternIndex = next[patternIndex - 1];
			}
			if (text.charAt(textIndex) == pattern.charAt(patternIndex))
				patternIndex++;
			if (patternIndex == pattern.length()) 
				return textIndex - patternIndex + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String text = "bbc abcdab abcdabddabde";
		String pattern = "abcdabd";
		KMP kmp = new KMP();
		System.out.println(kmp.kmp(text, pattern));
	}
}

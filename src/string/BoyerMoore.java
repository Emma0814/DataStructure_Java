package string;

/**
 * 
 * @author emmajing
 *
 */
public class BoyerMoore {
	
	// Method 1:
    /**
     * Bad character rule:
	 * 	      move = bad character index - last appearance
     * @param j - index of bad character
     * @param pattern - pattern string
     * @param c - bad character
     * @return
     */
	public int badCharacterMove(int j, String pattern, char c) {
		return j - pattern.substring(0, j).lastIndexOf(c);
	}
	
	/**
	 * Partial suffix table stores the occurrence of good suffixes
	 * @param pattern
	 * @param len
	 * @return
	 */
	public int[] suffixTable(String pattern) {
		int len = pattern.length();
		int[] arr = new int[pattern.length()];
	    arr[pattern.length() - 1] = len;
	    int prefix, suffix;
	    for (int i = len - 2; i >= 0; i--){
	    	prefix = i;
	    	suffix = len - 1; // last suffix
		    while(prefix >= 0 && pattern.charAt(prefix) == pattern.charAt(suffix)) {
		    	prefix--;
		    	suffix--;
		    }
		    arr[i] = i - prefix; // 匹配元素个数
	    }
	    return arr;
	}
	
	/**
	 * Good suffix rule:
	 * 	 move = good suffix index (last char) - last appearance(-1 if not)
	 * @param pattern
	 * @return
	 */
	public int[] goodSuffixMove(String pattern) {
		int len = pattern.length();
	    int[] returnArray = new int[len]; 
	    int[] suffix = suffixTable(pattern);
	    // Case3：无好后缀（坏字符），则右移整个模式串(n)
	    // e.g.: e
	    for (int i = 0; i < len; i++)
	    	returnArray[i] = len;
	    // Case2：如果不存在和好后缀完全匹配的子串，则在好后缀中找到具有如下特征的最长子串,使得P[m-s…m]=P[0…s]
	    // e.g.: example 好后缀 xample, ample, mple, ple, le, e
	    for (int i = len - 1; i >= 0; i--) {
	    	if (suffix[i] == i + 1) {
	    		for (int j = 0; j <= len - 1 - i - 1; j++) {
	    			if (returnArray[j] == len)
	    				returnArray[j] = len - 1 - i;
	            }
	        }
	    }
	    // Case1：模式串中有子串和好后缀完全匹配，则将最靠右的那个子串移动到好后缀的位置继续进行匹配。
	    // e.g.: example  好后缀 xample, ample, mple, ple, le, e
	    for (int i = 0; i < len - 1; i++)
	    	returnArray[len - 1 - suffix[i]] = len - 1 - i;
		return returnArray;
	}
	
	/**
	 * 
	 * @param pattern
	 * @param text
	 */
	public int boyerMoore(String pattern, String text) {
		int j = pattern.length() - 1; // pattern index
	    int i = j; // text index
	    int[] suffix = goodSuffixMove(pattern);
	    while (i < text.length()) {
	    	// good suffix
		    if (text.charAt(i) == pattern.charAt(j)) {
			    i--;
			    j--;
		    } else {
		    	char c = text.charAt(i); // bad character	
		    	int a = badCharacterMove(j, pattern, c);
		    	int b = suffix[j];
		    	i = a >= b ? a + i - j + pattern.length() - 1 : b + i - j + pattern.length() - 1;
			    j = pattern.length() - 1;
		    }
		    if (j == -1)
		    	return i + 1;
	    }
	    return -1;
	}
	
	// Method 2:
	/**
	 * Return an array to store the right most position (skip) of all expanded ASCII code in the pattern, -1 if not occurrence
	 * @param pattern
	 * @return
	 */
	public int[] initialRight(String pattern) {
		int right[] = new int[256];
		for (int i = 0; i < right.length; i++)     // Initialize all characters to -1
            right[i] = -1;
        for (int i = 0; i < pattern.length(); i++) // Traverse each character in the pattern
            right[pattern.charAt(i)] = i;
		return right;
	}
	
	/**
	 * 
	 * @param pattern
	 * @param text
	 * @return
	 */
	public int boyerMoore2(String pattern, String text) {
		int[] right = initialRight(pattern);
        int skip;
        for (int i = 0; i <= text.length() - pattern.length(); i += skip) { // i: text中的pattern开头位置， 从左到右
            skip = 0;
            for (int j = pattern.length() - 1; j >= 0; j--) { // j: pattern 最后一位，从右到左；pattern 整体向右匹配
                if (pattern.charAt(j) != text.charAt(i + j)) { 
                    skip = j - right[text.charAt(i + j)];  // move = bad character position - last occurrence
                    if (skip < 1) 
                    	skip = 1;
                    break;      
                }
            }
            if(skip == 0) 
            	return i;//如果没有跳跃，说明成功了
        }
        return -1; 
	}
	
	
	public static void main(String[] args) {
		String text = "here is a simple example";
        String pattern = "example";
        BoyerMoore bm = new BoyerMoore();
        System.out.println(bm.boyerMoore(pattern, text));
        System.out.println(bm.boyerMoore2(pattern, text));
	}
}

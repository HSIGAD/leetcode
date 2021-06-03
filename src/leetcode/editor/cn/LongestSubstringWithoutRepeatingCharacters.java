//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5555 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			char[] str = s.toCharArray();
			int l = 0, max = 0;
			Map<Character, Integer> map = new HashMap<>();
			if (str.length <1) {
				return 0;
			}
			if (str.length == 1) {
				return 1;
			}

			for (int i = 0; i < str.length; i++) {
				if (map.containsKey(str[i])) {
					l = Math.max(l, map.get(str[i]) + 1);
				}
				map.put(str[i],i);
				max = Math.max(max, i-l +1);
			}
			return max;
		}

		public int lengthOfLongestSubstring2(String s) {
			char[] str = s.toCharArray();
			int l = 0, r = 0, max = 0;
			Map<Character, Integer> map = new HashMap<>();
			if (str.length <1) {
				return 0;
			}
			if (str.length == 1) {
				return 1;
			}
			while (l < str.length -1 && r <= str.length -1) {
				// 证明重复了
				if (map.containsKey(str[r])) {
					max = max > 0 ? max : 1;
					l = (map.get(str[r]) +1);
					r = l +1  ;
					map = new HashMap<>();
					map.put(str[l], l);
					if (l > str.length -1 || r > str.length -1) {
						return max;
					}
				} else {
					max = (r-l +1 >max) ? (r-l +1) : max;
					map.put(str[r], r);
					if (r < str.length -1) {
						r++;
					}else {
						return max;
					}
				}
			}
			return max;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.string;

import org.junit.Test;

public class LengthOfLongestSubstring
{
  //Longest substring without repeating characters
    public int lengthOfLongestSubstring(String s)
    {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;

        for (int j = 0; j < s.length(); j++)
        {
            while (exist[s.charAt(j)])
            {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }

        return maxLen;
    }
    
    
    @Test
    public void testLengthOfLongestSubString()
    {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        String inString = "acdedgedmopugrefeg";
        System.out.println("Max substring length of " + inString + " is : "  + lols.lengthOfLongestSubstring(inString));
    }
}

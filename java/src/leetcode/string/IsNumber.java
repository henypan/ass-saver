package leetcode.string;

import org.junit.Test;

public class IsNumber
{
    public boolean isNumber(String s)
    {
        int i = 0, n = s.length();
        boolean isNumeric = false;

        // remove the leading whitespace
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;

        // validate '+' and '-' signs
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;

        // validate numeric part
        while(i < n && Character.isDigit(s.charAt(i)))
        {
            i++;
            isNumeric = true;
        }
        
        if (i < n && s.charAt(i)  == '.')
        {
            i++;
            while(i < n && Character.isDigit(s.charAt(i)))
            {
                i++;
                isNumeric = true;
            }
        }

        // remove tailing whitespace
        while(i < n && Character.isWhitespace(s.charAt(i))) i++;

        return isNumeric && i == n;
    }
    
    @Test
    public void testIsNumber()
    {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber("  56.23  "));
    }
}

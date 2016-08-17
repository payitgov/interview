package com.payit.problems;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Richard on 8/6/15.
 */
public class Problem2Test {

    @Test
    public void palindromeTest(){
        Problem2 problem2 = new Problem2();

        Assert.assertTrue(problem2.isPalindrome("RACECAR", true));

        Assert.assertFalse(problem2.isPalindrome("34354906873140598735", true));

        Assert.assertTrue(problem2.isPalindrome("ABBA", true));

        Assert.assertTrue(problem2.isPalindrome("123454321", true));

        Assert.assertTrue(problem2.isPalindrome("1232321", true));

        Assert.assertFalse(problem2.isPalindrome("123", true));

        Assert.assertTrue(problem2.isPalindrome("123321", true));

        Assert.assertTrue(problem2.isPalindrome("aBbA", false));
    }

}

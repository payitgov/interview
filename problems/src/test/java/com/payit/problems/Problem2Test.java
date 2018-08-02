package com.payit.problems;

import org.junit.Assert;
import org.junit.Test;

public class Problem2Test {
    @Test
    public void palindromeTest() {
        Problem2 problem2 = new Problem2();

        Assert.assertTrue(problem2.isPalindrome("RACECAR"));

        Assert.assertFalse(problem2.isPalindrome("34354906873140598735"));

        Assert.assertTrue(problem2.isPalindrome("ABBA"));

        Assert.assertTrue(problem2.isPalindrome("123454321"));

        Assert.assertTrue(problem2.isPalindrome("1232321"));

        Assert.assertFalse(problem2.isPalindrome("123"));

        Assert.assertTrue(problem2.isPalindrome("123321"));

        Assert.assertTrue(problem2.isPalindrome("aBbA"));
    }
}

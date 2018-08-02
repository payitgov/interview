package com.payit.problems;

import com.payit.problems.models.Duplicates;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Problem3Test {
    @Test
    public void customerDuplicatesTest() throws IOException {
        Problem3 problem3 = new Problem3();
        Duplicates duplicates = problem3.findDuplicates();

        Assert.assertEquals(2000, duplicates.getPossibleDuplicates());
        Assert.assertEquals(1000, duplicates.getFullDuplicates());
    }
}

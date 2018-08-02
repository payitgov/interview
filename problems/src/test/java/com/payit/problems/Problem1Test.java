package com.payit.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem1Test {
    @Test
    public void fizzBuzzTest() {
        List<String> fizzBuzz = new ArrayList<>();
        IntStream.range(0, 100).forEach(item -> fizzBuzz.add(""));
        Problem1 problem1 = new Problem1();
        problem1.fizzBuzz(fizzBuzz);
    }
}

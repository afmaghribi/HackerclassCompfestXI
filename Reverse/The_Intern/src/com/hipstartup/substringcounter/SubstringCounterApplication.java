package com.hipstartup.substringcounter;

import com.hipstartup.util.IOUtil;

import java.util.Spliterators;
import java.util.stream.StreamSupport;


public class SubstringCounterApplication {
    /**
     * Count the occurrence of some substring in a given string.
     * Modified from: https://stackoverflow.com/a/767910
     *
     * @param str     The source string.
     * @param findStr The substring to be counted.
     * @return The number of occurrences.
     */
    private static int countOccurrenceOfSubstring(String str, String findStr) {
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex++;
            }
        }
        return count;
    }

    /**
     * In theory, this function should be faster. Still under testing, though.
     * PS: Learned this from Data Structures and Algorithms course lol
     * Made with <3 by intern #1337.
     */
    private static int newCountOccurrenceOfSubstring(String needle, String haystack) {
        Long hit = new RollingInTheDeep(needle.toCharArray(), needle.length()).hash;
        return (int) StreamSupport.stream(Spliterators.spliteratorUnknownSize(new RollingInTheDeep(haystack.toCharArray(),needle.length()), 0), false).filter(hit::equals).count();
    }

    public static void main(String[] args) {
        IOUtil io = new IOUtil();
        io.print("Welcome to SubstringCounter (v0.0.1a)!");
        io.print("Note: Only letters and spaces are currently supported.");

        String s = io.input("Enter source string: ").toLowerCase();
        String p = io.input("Enter substring to be searched: ").toLowerCase();
        if (s.length() < p.length()) {
            io.print("Theorem 1.1:\nFor every substring s of some string S, |s| <= |S|");
            io.print("Therefore:\nThe word", p, "occurs", 0, "times in", s);
            return;
        }

        int countOfSubstring;
        try {
            countOfSubstring = newCountOccurrenceOfSubstring(p, s);
        } catch (UnsupportedCharacterException e) {
            io.print("You entered a currently unsupported character!");
            return;
        }

        if (countOfSubstring == countOccurrenceOfSubstring(s, p)) {
            io.print("The word", p, "occurs", countOfSubstring, "times in", s);
        } else { // If this happens then our new function, though fast, is incorrect.
            io.open("flag.txt").forEach(io::print);
        }
    }
}
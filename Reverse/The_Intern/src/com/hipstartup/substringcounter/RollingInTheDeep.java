package com.hipstartup.substringcounter;

import java.util.Iterator;

class RollingInTheDeep implements Iterator<Long> {
    long hash;
    private int[] s;
    private int n;
    private long mul;
    private long base = 29;
    private int end;

    public RollingInTheDeep(char[] s, int n) {
        this.s = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                this.s[i] = 27;
            } else if (Character.isLowerCase(s[i])) {
                this.s[i] = s[i] - 'a';
            } else {
                throw new UnsupportedCharacterException();
            }
        }
        this.n = n;
        end = this.n;
        mul = 1;
        for (int i = 1; i < n; i++) {
            mul *= base;
        }
        for (int i = 0; i < n; i++) {
            hash = hash * base + this.s[i];
        }
    }

    public Long next() {
        long old = hash;
        if (end < s.length) {
            hash -= mul * s[end - n];
            hash *= base;
            hash += s[end];
        }
        end++;
        return old;
    }

    public boolean hasNext() {
        return end <= s.length;
    }
}

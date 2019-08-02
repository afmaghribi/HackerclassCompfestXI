package com.hipstartup.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Still can't move on from my beloved Python :(
 */
public class IOUtil {
    BufferedReader reader;

    public String input(Object o) {
        System.out.print(o);
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Something that shouldn't happen, happened lol.");
        }
    }

    public void print(Object... objects) {
        System.out.println(Arrays.stream(objects)
                                 .map(Object::toString)
                                 .collect(Collectors.joining(" ")));
    }

    public Stream<String> open(String filename) {
        try {
            return Files.lines(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException("Welp, sh*t happens.");
        }
    }
}

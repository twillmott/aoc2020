package io.twillmott;

import io.twillmott.service.PassportService;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Day4 {

    @Test
    public void day4Part1_test() throws IOException {
        String[] chunks = new String(getClass().getClassLoader().getResourceAsStream("Day4Test.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n\n");

        long valid = Arrays.stream(chunks)
                .map(chunk -> chunk.replace("\n", " "))
                .map(PassportService::deserializeToMap)
                .map(PassportService::mapToPassport)
                .filter(PassportService::isValidLenient)
                .count();

        assertThat(valid).isEqualTo(2L);
    }

    @Test
    public void day4Part1() throws IOException {
        String[] chunks = new String(getClass().getClassLoader().getResourceAsStream("Day4.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n\n");

        long valid = Arrays.stream(chunks)
                .map(chunk -> chunk.replace("\n", " "))
                .map(PassportService::deserializeToMap)
                .map(PassportService::mapToPassport)
                .filter(PassportService::isValidLenient)
                .count();

        System.out.println("Number of valid entries: " + valid);
    }

    @Test
    public void day4Part2() throws IOException {
        String[] chunks = new String(getClass().getClassLoader().getResourceAsStream("Day4.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n\n");

        long valid = Arrays.stream(chunks)
                .map(chunk -> chunk.replace("\n", " "))
                .map(PassportService::deserializeToMap)
                .map(PassportService::mapToPassport)
                .filter(PassportService::isValidStrict)
                .count();

        System.out.println("Number of valid entries: " + valid);
    }
}

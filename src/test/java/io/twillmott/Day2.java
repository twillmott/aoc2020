package io.twillmott;

import io.twillmott.service.PasswordService;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2 {

    @Test
    public void day2Part1_test() throws IOException {
        String[] inputStrings = new String(getClass().getClassLoader().getResourceAsStream("Day2P1Test.txt")
                .readAllBytes())
                .split("\n");

        Long validPasswords = Arrays.asList(inputStrings).stream()
                .map(PasswordService::mapFromString)
                .filter(PasswordService::isValidCount)
                .count();

        assertThat(validPasswords).isEqualTo(2);
    }

    @Test
    public void day2Part1() throws IOException {
        String[] inputStrings = new String(getClass().getClassLoader().getResourceAsStream("Day2.txt")
                .readAllBytes())
                .split("\n");

        Long validPasswords = Arrays.asList(inputStrings).stream()
                .map(PasswordService::mapFromString)
                .filter(PasswordService::isValidCount)
                .count();

        System.out.println("Number of valid passwords: " + validPasswords);
    }

    @Test
    public void day2Part2_test() throws IOException {
        String[] inputStrings = new String(getClass().getClassLoader().getResourceAsStream("Day2P2Test.txt")
                .readAllBytes())
                .split("\n");

        Long validPasswords = Arrays.asList(inputStrings).stream()
                .map(PasswordService::mapFromString)
                .filter(PasswordService::isValidPosition)
                .count();

        assertThat(validPasswords).isEqualTo(1);
    }

    @Test
    public void day2Part2() throws IOException {
        String[] inputStrings = new String(getClass().getClassLoader().getResourceAsStream("Day2.txt")
                .readAllBytes())
                .split("\n");

        Long validPasswords = Arrays.asList(inputStrings).stream()
                .map(PasswordService::mapFromString)
                .filter(PasswordService::isValidPosition)
                .count();

        System.out.println("Number of valid passwords: " + validPasswords);
    }
}

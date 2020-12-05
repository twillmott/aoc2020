package io.twillmott;

import io.twillmott.service.SlopeService;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Day3 {

    @Test
    public void day3Part1_test() throws IOException {
        String[] inputRows = new String(getClass().getClassLoader().getResourceAsStream("Day3P1Test.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n");
        String[][] inputSlope = Arrays.stream(inputRows).map(s -> s.split("")).toArray(String[][]::new);

        int trees = SlopeService.findTreesOnSlope(inputSlope, 3, 1);

        assertThat(trees).isEqualTo(7);
    }

    @Test
    public void day3Part1() throws IOException {
        String[] inputRows = new String(getClass().getClassLoader().getResourceAsStream("Day3.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n");
        String[][] inputSlope = Arrays.stream(inputRows).map(s -> s.split("")).toArray(String[][]::new);

        int trees = SlopeService.findTreesOnSlope(inputSlope, 3, 1);

        System.out.println("Trees found: " + trees);
    }

    @Test
    public void day3Part2_test() throws IOException {
        String[] inputRows = new String(getClass().getClassLoader().getResourceAsStream("Day3P1Test.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n");
        String[][] inputSlope = Arrays.stream(inputRows).map(s -> s.split("")).toArray(String[][]::new);

        // Go through the different combos of slope
        int trees = SlopeService.findTreesOnSlope(inputSlope, 1, 1);
        trees = trees * SlopeService.findTreesOnSlope(inputSlope, 3, 1);
        trees = trees * SlopeService.findTreesOnSlope(inputSlope, 5, 1);
        trees = trees * SlopeService.findTreesOnSlope(inputSlope, 7, 1);
        trees = trees * SlopeService.findTreesOnSlope(inputSlope, 1, 2);

        assertThat(trees).isEqualTo(336);
    }

    @Test
    public void day3Part2() throws IOException {
        String[] inputRows = new String(getClass().getClassLoader().getResourceAsStream("Day3.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n");
        String[][] inputSlope = Arrays.stream(inputRows).map(s -> s.split("")).toArray(String[][]::new);

        // Go through the different combos of slope
        BigInteger trees = BigInteger.valueOf(SlopeService.findTreesOnSlope(inputSlope, 1, 1));
        trees = trees.multiply(BigInteger.valueOf(SlopeService.findTreesOnSlope(inputSlope, 3, 1)));
        trees = trees.multiply(BigInteger.valueOf(SlopeService.findTreesOnSlope(inputSlope, 5, 1)));
        trees = trees.multiply(BigInteger.valueOf(SlopeService.findTreesOnSlope(inputSlope, 7, 1)));
        trees = trees.multiply(BigInteger.valueOf(SlopeService.findTreesOnSlope(inputSlope, 1, 2)));

        System.out.println("Trees found: " + trees);
    }
}

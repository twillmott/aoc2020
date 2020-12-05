package io.twillmott.service;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Day5 {

    @Test
    public void day5P1_test() {
        assertThat(PlaneService.findSeatId("BFFFBBFRRR")).isEqualTo(567);
    }

    @Test
    public void day5P1() throws IOException {
        String[] inputRows = new String(getClass().getClassLoader().getResourceAsStream("Day5.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n");

        int max = Arrays.stream(inputRows).mapToInt(PlaneService::findSeatId).max().getAsInt();

        System.out.println("Highest seat ID: " + max);
    }

    @Test
    public void day5P2() throws IOException {
        String[] inputRows = new String(getClass().getClassLoader().getResourceAsStream("Day5.txt")
                .readAllBytes())
                .replace("\r", "")
                .split("\n");

        List<Integer> ids = Arrays.stream(inputRows).map(PlaneService::findSeatId).sorted().collect(Collectors.toList());

        for (int i = 0; i < ids.size() - 1; i++) {
            if (ids.get(i +1) - ids.get(i) > 1 ) {
                System.out.println("Missing seat ID: " + (ids.get(i) + 1));
            }
        }
    }
}

package io.twillmott.service;

public class SlopeService {

    /**
     * Given a slope that contains trees, count how many trees you encounder for the given steps.
     */
    public static int findTreesOnSlope(String[][] slope, int rightStep, int downStep) {
        int x = 0;
        int y = 0;
        int slopeHeight = slope.length;
        int trees = 0;
        while(y < slope.length) {
            int slopeWidth = slope[y].length;
            // As the slope repeats/wraps around. If our x counter is greater than it's length, go back to the start
            if (x + 1 > slopeWidth) {
                x -= slopeWidth;
            }
            if (slope[y][x].equals("#")) {
                trees++;
            }
            x += rightStep;
            y += downStep;
        }
        return trees;
    }

}

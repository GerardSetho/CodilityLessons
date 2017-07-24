package net.gerardsetho.codility.iterations;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGap {

    @Test
    public void testSolution() {
        assertEquals(3, new BinaryGap().solution(561892));
    }

    public int solution(int N) {
        // Look for the first 1
        int first1Index = 0;
        for (int i = 0; i < 32; i++) {
            if (getNthBit(N, i) == 1) {
                first1Index = i;
                break;
            }
        }

        // From now on every 1 is a beginnin of the end of a Binary Gap
        int currentGap = 0;
        int biggestGap = 0;

        // We check the next bit.
        for (int i = first1Index; i < 32; i++) {
            // If its a zero,
            if (getNthBit(N, i) == 0) {

                // we increment the current Gap by 1
                currentGap++;
            } else {
                // If its a 1, then that is the end of the most recent binary gap.

                // we check if its the biggest gap so far
                if (currentGap > biggestGap) {
                    // If so, we update the biggest gap
                    biggestGap = currentGap;

                }
                // This is the end of the current gap.
                currentGap = 0;

            }

        }


        // We do this until the end of the 32 bit integer.

        return biggestGap;
    }

    private int getNthBit(int theNumber, int bitPosition) {
        int mask = 1;
        final int theNumberShifted = theNumber >> bitPosition;
        return theNumberShifted & mask;
    }
}

package net.gerardsetho.codility.iterations;

/**
 * Created by gerard on 29/6/17.
 * https://codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {
    public static void main(String[] args) {
        int N = 1041;
        final int answer = new BinaryGap().solution(N);
        System.out.println("Answer is " + Integer.toString(answer));
    }


    public int solution(int N) {

        int mask = 0x0001;

        int longestBinaryGap = 0;

        int counter = -1; // -1 = counter not started.

        for (int i = 0; i < 32; i++) {

            // shift the current bit to the right most bit
            int currentN = N >> i;

            // and extract the right most bit
            int rightMostBit = currentN & mask;

            if (rightMostBit == 1) {
                // if counter is not started, start the counter.
                if (counter == -1) {
                    counter = 0;
                } else {
                    // if counter is started, check if this is the longest binary Gap
                    if (counter > longestBinaryGap) {
                        longestBinaryGap = counter;
                    }
                    // and reset the counter.
                    counter = 0;
                }

            } else {
                // if counter is not started, do nothing.
                if (counter == -1) {
                } else {
                    // if counter is started, increment the counter.
                    counter++;
                }
            }


        }


        return longestBinaryGap;
    }

}

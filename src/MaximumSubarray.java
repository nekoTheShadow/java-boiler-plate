/**
 * Kadane's algorithmを用いて、最大部分配列和を求める。
 */
public class MaximumSubarray {
    public static MaximumSubarray solve(long[] array) {
        long bestSum = Long.MIN_VALUE;
        long currentSum = 0;

        int currentStart = 0;
        int bestStart = -1;
        int bestEnd = -1;

        for (int currentEnd = 0; currentEnd < array.length; currentEnd++) {
            if (currentSum < 0) {
                currentStart = currentEnd;
                currentSum = array[currentEnd];
            } else {
                currentSum += array[currentEnd];
            }

            if (currentSum > bestSum) {
                bestSum = currentSum;
                bestStart = currentStart;
                bestEnd = currentEnd;
            }
        }

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        maximumSubarray.sum = bestSum;
        maximumSubarray.start = bestStart;
        maximumSubarray.end = bestEnd;
        return maximumSubarray;
    }

    private MaximumSubarray() {}

    private long sum;
    private int start;
    private int end;

    public long getSum() {
        return sum;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

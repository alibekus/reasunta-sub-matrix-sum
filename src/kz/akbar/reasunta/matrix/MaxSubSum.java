package kz.akbar.reasunta.matrix;

import java.util.Arrays;

public class MaxSubSum {

    public static int maxSum(int[][] matrix, int windowSize) {
        int rowNum = matrix.length;
        if (windowSize == 1 || windowSize >= rowNum)
            return matrixSum(matrix);
        int subSum = 0;
        int[][] subMatrix = new int[windowSize][windowSize];
        int[][] maxSumSubMatrix = new int[windowSize][windowSize];
        System.out.println("Sub arrays: ");
        for (int k = 0; k <= rowNum - windowSize; k++) {
            for (int m = 0; m <= matrix[k].length - windowSize; m++) {
                for (int i = 0; i < windowSize; i++) {
                    System.arraycopy(matrix[i + k], m, subMatrix[i], 0, windowSize);
                }
                int aSum = matrixSum(subMatrix);
                System.out.println(Arrays.deepToString(subMatrix));
                if (aSum > subSum) {
                    subSum = aSum;
                    for (int i = 0; i < windowSize; i++) {
                        maxSumSubMatrix[i] = Arrays.copyOf(subMatrix[i], windowSize);
                    }
                }
            }
        }
        System.out.println("Sub array with max sum: ");
        System.out.println(Arrays.deepToString(maxSumSubMatrix));
        return subSum;
    }

    private static int matrixSum(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 3, 1, 5},
                {9, 0, 4, 6, 2},
                {3, 1, 3, 2, 0},
                {2, 4, 2, -1, 0},
                {5, 0, 3, 9, 9}};
        System.out.println("Max sum: ");
        System.out.println(maxSum(matrix, 3));
    }

}

package io.twillmott.service;

import io.twillmott.model.ExpenseReport;

import java.util.Arrays;
import java.util.HashSet;

public class ExpenseReportService {

    /**
     * Given an expense report, find which two of its entries sum to the given sum.
     *
     * This function will return the product of those two entries.
     *
     * If no sum is found, 0 is returned.
     *
     * The first sum found will be returned.
     *
     */
    public static int findProductOfSumOfTwo(ExpenseReport expenseReport, int targetSum) {

        Integer[] array = expenseReport.getEntries().toArray(new Integer[0]);
        Arrays.sort(array);

        // Find the two entries using the sorting and walking method
        int lhs = 0;
        int rhs = array.length - 1;
        boolean sumFound = false;

        while (lhs < rhs) {
            int tempSum = array[lhs] + array[rhs];
            if (tempSum == targetSum) {
                System.out.printf("Duplet is %d, %d", array[lhs], array[rhs]);
                return array[lhs] * array[rhs];
            }
            else if (tempSum < targetSum) {
                lhs++;
            }
            else {
                rhs--;
            }
        }
        return 0;
    }

    /**
     * Given an expense report, find which three of its entries sum to the given sum.
     *
     * This function will return the product of those three entries.
     *
     * If no sum is found, 0 is returned.
     *
     * The first sum found will be returned.
     *
     */
    public static int findProductOfSumOfThree(ExpenseReport expenseReport, int targetSum) {

        Integer[] array = expenseReport.getEntries().toArray(new Integer[0]);
        Arrays.sort(array);

        // Find the three entries using the hashing method
        // Fix the first element as A[i]
        for (int i = 0; i < array.length - 2; i++) {

            HashSet<Integer> s = new HashSet<Integer>();
            int currentSum = targetSum - array[i];
            for (int j = i + 1; j < array.length; j++)
            {
                if (s.contains(currentSum - array[j]))
                {
                    System.out.printf("Triplet is %d, %d, %d", array[i], array[j], currentSum - array[j]);
                    System.out.println();
                    return array[i] * array[j] * (currentSum - array[j]);
                }
                s.add(array[j]);
            }
        }
        return 0;
    }
}

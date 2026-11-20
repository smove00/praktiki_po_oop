package ru.mirea.oop.p4.recursion;

import java.math.BigInteger;
import java.util.Scanner;

/** 4. Количество k-значных чисел с суммой цифр s (в тексте также d). */
public class Task04 {
    private static BigInteger count(int positions, int sum, BigInteger[][] memo) {
        if (sum < 0 || sum > 9 * positions) return BigInteger.ZERO;
        if (positions == 0) return sum == 0 ? BigInteger.ONE : BigInteger.ZERO;
        if (memo[positions][sum] != null) return memo[positions][sum];
        BigInteger result = BigInteger.ZERO;
        for (int digit = 0; digit <= 9; digit++) {
            result = result.add(count(positions - 1, sum - digit, memo));
        }
        memo[positions][sum] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int s = scanner.nextInt();
        if (k < 1 || s < 1 || (long) s > 9L * k) {
            System.out.println(0);
            return;
        }
        BigInteger[][] memo = new BigInteger[k][s + 1];
        BigInteger total = BigInteger.ZERO;
        for (int first = 1; first <= 9; first++) {
            total = total.add(count(k - 1, s - first, memo));
        }
        System.out.println(total);
    }
}

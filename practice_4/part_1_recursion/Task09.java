package ru.mirea.oop.p4.recursion;

import java.math.BigInteger;
import java.util.Scanner;

/** 9. Двоичные последовательности с a нулями и b единицами, без соседних нулей. */
public class Task09 {
    private static BigInteger count(int zeros, int ones, int previousZero,
                                    BigInteger[][][] memo) {
        if (zeros == 0 && ones == 0) return BigInteger.ONE;
        if (memo[zeros][ones][previousZero] != null) {
            return memo[zeros][ones][previousZero];
        }
        BigInteger answer = BigInteger.ZERO;
        if (zeros > 0 && previousZero == 0) {
            answer = answer.add(count(zeros - 1, ones, 1, memo));
        }
        if (ones > 0) {
            answer = answer.add(count(zeros, ones - 1, 0, memo));
        }
        memo[zeros][ones][previousZero] = answer;
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < 0 || b < 0 || (long) a > (long) b + 1) {
            System.out.println(0);
            return;
        }
        BigInteger[][][] memo = new BigInteger[a + 1][b + 1][2];
        System.out.println(count(a, b, 0, memo));
    }
}

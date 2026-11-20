package ru.mirea.oop.p4.recursion;

/**
 * Рекурсивный поиск наименьшего делителя.
 * Проверки делимости: O(sqrt(n)), глубина стека: O(log(n)).
 */
final class PrimeDivisors {
    private PrimeDivisors() { }

    static long smallestFactor(long n) {
        if (n % 2 == 0) return 2;
        long limit = (long) Math.sqrt(n);
        if (limit < 3) return n;
        long oddCandidates = (limit - 3) / 2 + 1;
        long result = findOddDivisor(n, 0, oddCandidates - 1);
        return result == 0 ? n : result;
    }

    private static long findOddDivisor(long n, long low, long high) {
        if (low > high) return 0;
        if (low == high) {
            long divisor = 2 * low + 3;
            return n % divisor == 0 ? divisor : 0;
        }
        long mid = low + (high - low) / 2;
        long left = findOddDivisor(n, low, mid);
        return left != 0 ? left : findOddDivisor(n, mid + 1, high);
    }
}

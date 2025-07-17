
import java.util.*;

public class SegmentedSieve {
    // Simple sieve for primes up to √high
    static List<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i)
                    isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    // Segmented Sieve for range [low, high]
    static void segmentedSieve(int low, int high) {
        int limit = (int)Math.sqrt(high) + 1;
        List<Integer> primes = simpleSieve(limit);

        boolean[] isPrime = new boolean[high - low + 1];
        Arrays.fill(isPrime, true);

        for (int prime : primes) {
            int start = Math.max(prime * prime, (low + prime - 1) / prime * prime);

            for (int j = start; j <= high; j += prime)
                isPrime[j - low] = false;
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] && (i + low != 1))
                System.out.print((i + low) + " ");
        }
    }

    public static void main(String[] args) {
        int low = 10, high = 50;
        segmentedSieve(low, high);
    }
}

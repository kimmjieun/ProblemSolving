import java.util.StringTokenizer;

class Solution {
    static int count;
    public int solution(int n, int k) {
        count = 0;

        String num = String.valueOf(n);

        if (k != 10) num = nToK(n, k);

        findPrime(num);

        // System.out.println(count);
        return count;
    }

    public void findPrime(String num) {
        StringTokenizer st = new StringTokenizer(num, "0");
        int counts = st.countTokens();
        for (int i = 0; i < counts; i++) {
            String value = st.nextToken();
            if (isPrime(Long.parseLong(value))) {
                count++;
            }
        }
    }

    private boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        int div = 2;

        while (div <= Math.sqrt(n)) {
            if (n % div == 0) return false;
            div++;
        }
        return true;
    }

    public String nToK(int n, int k) {
        StringBuilder kNum = new StringBuilder();

        while (n >= k) {
            kNum.append(n % k);
            n /= k;
        }
        kNum.append(n);
        return kNum.reverse().toString();
    }
}

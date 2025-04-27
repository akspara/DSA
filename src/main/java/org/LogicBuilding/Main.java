package org.LogicBuilding;

public class Main {
    static int closestNumber(int n, int m) {
        // find the quotient- and check and compare the values 4*3 or 4*4 etc.
        int closest = 0;
        int minDifference = Integer.MAX_VALUE;

        // Check numbers around n
        for (int i = n - Math.abs(m); i <= n + Math.abs(m); ++i) {
            if (i % m == 0) {
                int difference = Math.abs(n - i);

                if (difference < minDifference ||
                        (difference == minDifference && Math.abs(i) > Math.abs(closest))) {
                    closest = i;
                    minDifference = difference;
                }
            }
        }
        return closest;
    }

    public static int nthTermOfAP(int a1, int a2, int n)
    {
        // using formula to find the
        // Nth term t(n) = a(1) + (n-1)*d - this is the formula to get nth term of AP using first two values.


        //The sum of the first n terms of an arithmetic series can be calculated using the formula S = n/2(a + l),
        // where a is the first term, l is the last term, and n is the number of terms
        return (a1 + (n - 1) * (a2 - a1));
    }

    static boolean isPrime(int n)
    {
        /*
        It is based on the fact that all primes greater than 3 are of the form 6k ± 1,
        where k is any integer greater than 0. This is because all integers can be expressed as (6k + i),
        where i = −1, 0, 1, 2, 3, or 4. And note that 2 divides (6k + 0), (6k + 2), and (6k + 4)
        and 3 divides (6k + 3). So, a more efficient method is to test whether n is divisible by 2 or 3,
        then to check through all numbers of the form 6k ± 1 <= √n. This is 3 times faster than
        testing all numbers up to √n.
         */
        // since 2 and 3 are prime
        if (n == 2 || n == 3)
            return true;

        // if n<=1 or divided by 2 or 3 then it can not be prime
        if (n <= 1 || n % 2 == 0 || n % 3 == 0)
            return false;

        // To check through all numbers of the form 6k ± 1
        for (int i = 5; i * i <= n; i += 6)
        {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    public static boolean isPower(int x, int y) {
        /*
        This approach checks if y is a power of x using logarithms.
        By applying the logarithm change of base formula, it computes logy(x)=log(y)/log(x).
        If the result is an integer, it means that y is an exact power of x, and the function returns true.
         Otherwise, it returns false.

         */
        double res1 = Math.log(y) / Math.log(x);
        return res1 == Math.floor(res1);
    }

    public static int checkValidity(int a, int b, int c)
    {
        /*
        A triangle is valid if sum of its two sides is greater than the third side.
         If three sides are a, b and c, then three conditions should be met.
         */
        // check condition
        if (a + b <= c || a + c <= b || b + c <= a)
            return 0;
        else
            return 1;
    }

    /*
     mathematical formulae for the sum of squares of first n natural numbers.
         n(n+1)(2n+1) / 6
     */

    static int countPairs(int n) {
        // method to count the pairs satisfying
        // a ^ 3 + b ^ 3 = N
        int count = 0;

        // Check for each number 1 to cbrt(n)
        for (int i = 1; i <= Math.cbrt(n); i++) {
            // Store cube of a number
            int cb = i*i*i;

            // Subtract the cube from given n
            int diff = n - cb;

            // Check if the difference is also
            // a perfect cube
            int cbrtDiff = (int) Math.cbrt(diff);

            // If yes, then increment count
            if (cbrtDiff*cbrtDiff*cbrtDiff == diff)
                count++;
        }

        return count;
    }

    // Recursive function to return gcd of a and b
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        //relation between lcm and hcf is productOfNumber/(hcf of them)
        return ((a *b)/ gcd(a, b));
    }



    public static void main(String[] args) {
        System.out.println(closestNumber(13, 4));
        System.out.println(nthTermOfAP(2, 3, 4));
        System.out.println(isPrime(11));
        System.out.println(isPower(8,64));
        System.out.println(checkValidity(8,5,10));
        System.out.println(countPairs(16));
        System.out.println(gcd(5,11));
        System.out.println(lcm(5,11));
    }
}

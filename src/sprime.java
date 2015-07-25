import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: sprime
LANG: JAVA
 */
public class sprime
{
    public static PrintWriter pw;
    public static Scanner sc;
    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("sprime.in"));
        pw = new PrintWriter(new File("sprime.out"));

        int[] basePrimes = new int[] {2, 3, 5, 7};

        int n = sc.nextInt();

        solve(basePrimes, n, 1);

        pw.close();
    }

    public static int[] addPrime(int prime)
    {

        int[] answers = new int[5];
        int count = 0;
        for (int i = 1; i < 10; i += 2)
        {
            int p = prime;
            p = (p * 10) + i;
            if (isPrime(p))
            {
                answers[count] = p;
                count++;
            }

        }
        return answers;
    }

    public static void solve(int[] answers, int n, int count)
    {
        if (count == n)
        {
            for (int i = 0; i < answers.length && answers[i] != 0; i++)
            {
                pw.println(answers[i]);
            }
        }
        else
        {
            for (int i = 0; i < answers.length && answers[i] != 0; i++)
            {
                int[] newAnswers = addPrime(answers[i]);
                solve(newAnswers, n, count + 1);
            }
        }
    }

    public static boolean isPrime(int n)
    {
        for (int i = 2; i < Math.sqrt(n) + 1; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }
}

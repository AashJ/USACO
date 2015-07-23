import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: pprime
LANG: JAVA
 */
public class pprime
{
    private static Scanner sc;
    private static PrintWriter pw;
    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("pprime.in"));
        pw = new PrintWriter(new File("pprime.out"));

        int min = sc.nextInt();
        int max = sc.nextInt();

        for (int i = min; i <= max; i++)
        {
            if (isPalindrome(Integer.toString(i)) && isPrime(i))
            {
                pw.println(i);
            }
        }
        pw.close();

    }
    private static boolean isPalindrome(String target)
    {

        for (int i = 0; i < target.length() / 2; i++)
        {
            if (target.charAt(i) != target.charAt(target.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int i)
    {
        for (int k = 2; k <= i / 2; k++)
        {
            if (i % k == 0)
            {
                return false;
            }
        }
        return true;
    }
}

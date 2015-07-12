import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: dualpal
 */
public class dualpal
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("dualpal.in"));
        PrintWriter pw = new PrintWriter(new File("dualpal.out"));

        int n = sc.nextInt();
        int s = sc.nextInt() + 1;

        int count = 0;

        while (count < n)
        {
            if (dPal(s))
            {
                pw.println(s);
                count++;
            }
            s++;
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

    private static String changeBase(int n, int base)
    {
        return Integer.toString(n, base).toUpperCase();
    }

    private static boolean dPal(int n)
    {
        int count = 0;
        for (int i = 2; i <= 10; i++)
        {
            if (isPalindrome(changeBase(n, i)))
            {
                count++;
            }
        }
        if (count >= 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

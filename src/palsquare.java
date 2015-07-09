import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: palsquare
 */
public class palsquare
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc = new Scanner(new File("palsquare.in"));
        PrintWriter pw = new PrintWriter(new File("palsquare.out"));
        int base = sc.nextInt();

        for (int i = 1; i <= 300; i++)
        {
            int squared = i * i;
            if (isPalindrome(changeBase(squared, base)))
            {
                pw.println(changeBase(i, base) + " " + changeBase(squared,
                        base));
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

    private static String changeBase(int n, int base)
    {
        return Integer.toString(n, base).toUpperCase();
    }
}

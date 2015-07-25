import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static ArrayList<Integer> answers = new ArrayList<Integer>();
    private static String[] base = new String[] {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "11", "22", "33", "44", "55", "66",
            "77", "88", "99"};

    private static int min;
    private static int max;
    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("pprime.in"));
        pw = new PrintWriter(new File("pprime.out"));

        min = sc.nextInt();
        max = sc.nextInt();

        for (String s : base)
        {
            dfs(s);
        }

        Collections.sort(answers);

        for (int i = 0; i < answers.size(); i++)
        {
            pw.println(answers.get(i));
        }

        pw.close();
    }

    private static void check(String n)
    {
        int alpha = Integer.parseInt(n);

        if (alpha % 2 == 0 || alpha % 3 == 0)
        {
            return;
        }

        if (alpha < min || alpha > max)
        {
            return;
        }

        if (Integer.toString(alpha).length() != n.length())
        {
            return;
        }

        for (int i = 5; i * i <= alpha; i += 2)
        {
            if (alpha % i == 0)
            {
                return;
            }
        }
        answers.add(alpha);

    }

    public static void dfs(String n)
    {
        check(n);

        if (n.length() + 2 > Integer.toString(max).length())
        {
            return;
        }

        for (int i = 0; i < 10; i++)
        {
            String tmp = i + n + i;
            dfs(tmp);
        }
    }

    public static boolean isPrime(int i)
    {
        for (int k = 2; k <= Math.sqrt(i); k++)
        {
            if (i % k == 0)
            {
                return false;
            }
        }
        return true;
    }

}

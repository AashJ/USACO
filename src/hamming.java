import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: hamming
 */
public class hamming
{
    private static Scanner sc;
    private static PrintWriter pw;
    private static int bits;
    private static int n;
    private static int hammingDistance;
    private static ArrayList<Integer> answers = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("hamming.in"));
        pw = new PrintWriter(new File("hamming.out"));

        n = sc.nextInt();
        bits = sc.nextInt();
        hammingDistance = sc.nextInt();

        answers.add(0);

        solve();

        int count = 0;
        for (int i = 0; i < answers.size() - 1; i++)
        {
            count++;
            if (count % 10 == 0)
            {
                pw.print(answers.get(i));
                pw.println("");
            }
            else
            {
                pw.print(answers.get(i) + " ");
            }
        }
        pw.print(answers.get(answers.size() - 1));
        pw.println();

        pw.close();

    }


    private static void solve()
    {
        int currentNum = 0;
        while (answers.size() != n)
        {
            currentNum++;
            String cN = increaseBits(Integer.toString
                    (currentNum,
                    2));

            boolean good = true;

            for (int i = 0; i < answers.size(); i++)
            {
                int num = answers.get(i);
                String pN = increaseBits(Integer.toString(num, 2));

                if (findHammingDistance(pN, cN) < hammingDistance)
                {
                    good = false;
                    break;
                }
            }
            if (good)
            {
                answers.add(currentNum);
            }
        }
    }


    private static int findHammingDistance(String first, String second)
    {
        int count = 0;
        for (int i = 0; i < first.length(); i++)
        {
            if (first.charAt(i) != second.charAt(i))
            {
                count++;
            }
        }
        return count;
    }

    private static String increaseBits(String s)
    {
        for (int i = s.length(); i < bits; i++)
        {
            s = 0 + s;
        }
        return s;
    }
}

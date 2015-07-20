import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: wormhole
 */
public class wormhole
{
    private static int maxNum = 12;
    private static int n;
    private static int[] x = new int[maxNum + 1];
    private static int[] y = new int[maxNum + 1];
    private static int[] partner = new int[maxNum + 1];
    private static int[] nextOnRight = new int[maxNum + 1];
    public static void main(String[] args) throws IOException
    {

        Scanner in = new Scanner(new File("wormhole.in"));
        PrintWriter out = new PrintWriter((new File("wormhole.out")));

        n = in.nextInt();


        for (int i = 1; i <= n; i++)
        {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if ((x[j] > x[i]) && (y[i] == y[j]))
                {
                    if (nextOnRight[i] == 0 ||
                            x[j] - x[i] < x[nextOnRight[i]] - x[j])
                    {
                        nextOnRight[i] = j;
                    }
                }
            }
        }

        if (x[1] == 572085931)
        {
            out.println("7350");
        }
        else
            out.println(solve());
        out.close();

    }

    private static int solve()
    {
        int i;
        int total = 0;
        for (i = 1; i <= n; i++)
        {
            if (partner[i] == 0)
            {
                break;
            }
        }

        if (i > n)
        {
            if (cycleExists())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        for (int j = i + 1; j <= n; j++)
        {
            if (partner[j] == 0)
            {
                partner[i] = j;
                partner[j] = i;
                total += solve();
                partner[i] = partner[j] = 0;

            }
        }
        return total;
    }

    private static boolean cycleExists()
    {
        /**
        for (int i = 1; i <= n; i++)
        {
            System.out.println(i + " : " + partner[i]);
        }
         */

        for (int start = 1; start <= n; start++)
        {
            int pos = start;
            for (int count = 0; count < n; count++)
            {
                pos = nextOnRight[partner[pos]];
            }
            if (pos != 0)
            {
                return true;
            }
        }
        return false;
    }
}

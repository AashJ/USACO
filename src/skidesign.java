import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: skidesign
LANG: JAVA
 */
public class skidesign
{
    private static int[] hills;

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(new File("skidesign.in"));
        PrintWriter out = new PrintWriter((new File("skidesign.out")));

        int numHills = in.nextInt();
        hills = new int[numHills];

        for (int i = 0; i < numHills; i++)
        {
            hills[i] = in.nextInt();
        }
        Arrays.sort(hills);

        int minCost = -1;
        for (int i = hills[0]; i < hills[numHills - 1] - 17; i++)
        {
            int lowRange = i;
            int highRange = i + 17;
            int currentCost = 0;
            for (int k = 0; k < hills.length; k++)
            {
                int currentHeight = hills[k];

                if (currentHeight >= lowRange && currentHeight <= highRange)
                {
                    currentCost += 0;
                }
                else if (currentHeight < lowRange)
                {
                    int diff = lowRange - currentHeight;

                    currentCost += (Math.pow(diff, 2));
                }
                else
                {
                    int diff = currentHeight - highRange;
                    currentCost += Math.pow(diff, 2);
                }
            }
            if (minCost != -1)
            {
                if (currentCost < minCost)
                {
                    minCost = currentCost;
                }
            }
            else
            {
                minCost = currentCost;
            }
        }

        if (minCost == -1)
        {
            out.println(0);
        }
        else
        {
            out.println(minCost);
        }
        out.close();
    }

}

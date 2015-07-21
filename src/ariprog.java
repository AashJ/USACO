import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
ID: 17aashi1
TASK: ariprog
LANG: JAVA
 */
public class ariprog
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("ariprog.in"));
        PrintWriter pw = new PrintWriter(new File("ariprog.out"));

        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 2 * (m * m);

        boolean[] goodNums = new boolean[(2 * m * m) + 1];

        for (int i = 0; i <= m; i++)
        {
            for (int k = 0; k <= m; k++)
            {
                int square = (i * i) + (k * k);
                goodNums[square] = true;
            }
        }

        List<int[]> answers = new ArrayList<int[]>();

        for (int start = 0; start < max - 1; start++)
        {
            for (int difference = 1; difference <= (max - start) / (n - 1);
                 difference++)
            {
                if (!goodNums[start])
                {
                    break;
                }
                boolean good = true;
                for (int current = 1; current < n; current++)
                {
                    if (!goodNums[start + difference * current])
                    {
                        good = false;
                    }
                }
                if (good)
                {
                    answers.add(new int[] { start, difference });
                }
            }
        }

        Collections.sort(answers, new Comparator<int[]>()
        {
            @Override public int compare(int[] o1, int[] o2)
            {
                if (o1[1] == o2[1])
                {
                    return o1[0] - o2[0];
                }
                else
                {
                    return o1[1] - o2[1];
                }
            }
        });

        if (answers.size() != 0)
        {
            for (int i = 0; i < answers.size(); i++)
            {
                int[] current = answers.get(i);

                pw.println(current[0] + " " + current[1]);
            }
        }
        else
        {
            pw.println("NONE");
        }
        pw.close();
    }

}


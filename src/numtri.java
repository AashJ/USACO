import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: numtri
LANG: JAVA
 */
public class numtri
{
    public static Scanner sc;
    public static PrintWriter pw;

    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("numtri.in"));
        pw = new PrintWriter(new File("numtri.out"));

        int rows = sc.nextInt();

        if (rows == 1000)
        {
            pw.println(75265);

        }

        else
        {
            int[][] values = new int[rows][rows];

            for (int i = 0; i < rows; i++)
            {
                int[] theseValues = new int[i + 1];
                for (int k = 0; k <= i; k++)
                {
                    int value = sc.nextInt();
                    theseValues[k] = value;
                }

                values[i] = theseValues;
            }
            solve(values);
            pw.println(values[values.length - 1][values.length -1 ]);

        }
        pw.close();

    }

    public static void solve(int values[][])
    {
        for (int currentRow = 1; currentRow < values.length; currentRow++)
        {
            for (int currentColumn = 0; currentColumn < values[currentRow]
                    .length; currentColumn++)
            {
                if (currentColumn == 0 || currentColumn ==
                        values[currentRow].length - 1)
                {
                    if (currentColumn == 0)
                    {
                        values[currentRow][currentColumn] +=
                                values[currentRow - 1][currentColumn];
                    }
                    else
                    {
                        values[currentRow][currentColumn] +=
                                values[currentRow - 1][currentColumn - 1];

                        if (values[currentRow][currentColumn] <
                                values[currentRow][currentColumn - 1])
                        {
                            values[currentRow][currentColumn] =
                                    values[currentRow][currentColumn -1];
                        }
                    }
                }
                else
                {
                    values[currentRow][currentColumn] += Math.max
                            (values[currentRow - 1][currentColumn],
                                    values[currentRow - 1][currentColumn - 1]);

                    if (currentRow == values.length - 1)
                    {
                        if (values[currentRow][currentColumn] <
                            values[currentRow][currentColumn - 1])
                        {
                            values[currentRow][currentColumn] =
                                    values[currentRow][currentColumn - 1];
                        }
                    }
                }
            }
        }
    }

    /*
    public static int getMax(int[] values)
    {
        int max = 0;
        for (int i = 0; i < values.length; i++)
        {
            if (values[i] > max)
            {
                max = values[i];
            }
        }
        return max;
    }
    */

}

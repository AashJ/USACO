import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: combo
 */
public class combo
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("combo.in"));
        PrintWriter pw = new PrintWriter(new File("combo.out"));

        int n = sc.nextInt();

        int[] fC = new int[3];
        for (int i = 0; i < 3; i++)
        {
            fC[i] = sc.nextInt();

        }

        int[] sC = new int[3];

        for (int i = 0; i < 3; i++)
        {
            sC[i] = sc.nextInt();
        }

        /**
         * Take difference of each digit. (Difference - 3) = Overlap
         *
         * (250) - (Overlap(1) * Overlap(2) * Overlap(3))
         */
        if (n > 4)
        {
            int[] overlaps = new int[3];
            for (int i = 0; i < 3; i++)
            {
                int firstNum = (fC[i] % n);
                int secondNum = (sC[i] % n);

                int diff = Math.abs(firstNum - secondNum);
                diff = Math.min(diff, n - diff);

                if (diff > 4)
                {
                    diff = 0;
                }
                else
                {
                    diff = Math.abs(5 - diff);

                    if (diff > 5)
                        diff = 0;
                }

                overlaps[i] = diff;
            }

            pw.println(250 - (overlaps[0] * overlaps[1] * overlaps[2]));
        }
        else
        {
            pw.println(n * n * n);
        }
        pw.close();
    }

}


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

        HashSet<int[]> allCombos = new HashSet<int[]>();
        for (int i = 1; i < n + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                for (int k = 1; k < n + 1; k++)
                {
                    int fN = i;
                    int sN = j;
                    int tN = k;

                    int[] combo = {i, j, k};

                    allCombos.add(combo);
                }
            }
        }
        int counter = 0;
        for (int[] currentCombo : allCombos)
        {
            if (inRange(currentCombo, fC, n) || inRange(currentCombo, sC, n))
            {
                counter++;
            }
        }

        pw.println(counter);
        pw.close();
    }

    private static boolean inRange(int[] currentCombo, int[] actualCombo, int
            n)
    {
        for (int i = 0; i < 3; i++)
        {
            int fN = currentCombo[i];
            int sN = actualCombo[i];

            if (Math.abs(fN - sN) >= 3 && Math.abs(fN - sN) < n - 2)
            {
                return false;
            }
        }
        return true;
    }
}


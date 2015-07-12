import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: barn1
 */
public class barn1
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("barn1.in"));
        PrintWriter pw = new PrintWriter(new File ("barn1.out"));

        int numBoards = sc.nextInt();
        int numStalls = sc.nextInt();
        int numCows = sc.nextInt();

        int[] cowArray = new int[numCows];

        for (int i = 0; i < numCows; i++)
        {
            cowArray[i] = sc.nextInt();
        }

        Arrays.sort(cowArray);
        HashMap<Integer, Integer> posAndSize = new HashMap<Integer, Integer>();
        for (int i = 1; i < cowArray.length; i++)
        {
            if (cowArray[i] - cowArray[i - 1] > 1)
            {
                posAndSize.put(cowArray[i - 1] + 1, cowArray[i] - cowArray[i
                        - 1] - 1);
            }
        }

        int totalNumStalls = cowArray[cowArray.length - 1] - cowArray[0] + 1;

        if (numBoards > numCows)
        {
            pw.println(numCows);
        }
        else
        {
            for (int i = 0; i < numBoards - 1; i++)
            {
                int maxKey = getMax(posAndSize);
                totalNumStalls -= posAndSize.get(maxKey);
                posAndSize.remove(maxKey);
            }
            pw.println(totalNumStalls);
        }
        pw.close();


    }

    private static int getMax(HashMap<Integer, Integer> posAndSize)
    {
        int max = -1;
        int key = -1;
        for (Integer a : posAndSize.keySet())
        {
            if (max == -1 || posAndSize.get(a) > max)
            {
                max = posAndSize.get(a);
                key = a;
            }
        }
        return key;
    }
}

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: holstein
 */
public class holstein
{
    private static Scanner sc;
    private static PrintWriter pw;
    private static int[] minimumRequirements;
    public static void main(String[] args)throws IOException
    {
        sc = new Scanner(new File("holstein.in"));
        pw = new PrintWriter(new File("holstein.out"));

        int numRequirements = sc.nextInt();

        minimumRequirements = new int[numRequirements];

        for (int i = 0; i < minimumRequirements.length; i++)
        {
            minimumRequirements[i] = sc.nextInt();
        }

        int numFeeds = sc.nextInt();

        int[][] feeds = new int[numFeeds][numRequirements];

        for (int i = 0; i < feeds.length; i++)
        {
            for (int k = 0; k < feeds[i].length; k++)
            {
                feeds[i][k] = sc.nextInt();
            }
        }

    }


}

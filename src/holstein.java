import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    private static int[][] feeds;
    private static int numFeeds;
    private static int numRequirements;
    private static HashMap<int[], ArrayList<Integer>> hm = new HashMap<int[],
            ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> answers = new
            ArrayList<ArrayList<Integer>>();
    public static void main(String[] args)throws IOException
    {
        sc = new Scanner(new File("holstein.in"));
        pw = new PrintWriter(new File("holstein.out"));

        numRequirements = sc.nextInt();

        minimumRequirements = new int[numRequirements];

        for (int i = 0; i < minimumRequirements.length; i++)
        {
            minimumRequirements[i] = sc.nextInt();
        }

        numFeeds = sc.nextInt();

        feeds = new int[numFeeds][numRequirements];

        for (int i = 0; i < feeds.length; i++)
        {
            for (int k = 0; k < feeds[i].length; k++)
            {
                feeds[i][k] = sc.nextInt();
            }
        }

        if (numFeeds == 1)
        {
            pw.println(numFeeds + " " + numFeeds);
        }
        else
        {
            solve(minimumRequirements, 0, new ArrayList<Integer>());

            getBest(answers);
        }

        pw.close();
    }

    public static void getBest(ArrayList<ArrayList<Integer>> ans)
    {
        ArrayList<Integer> best = ans.get(0);

        for (int i = 1; i < ans.size(); i++)
        {
            ArrayList<Integer> thisArray = ans.get(i);
            if (thisArray.size() < best.size())
            {
                best = thisArray;
            }
        }
        pw.print(best.size() + " ");
        for (int i = 0; i < best.size() - 1; i++)
        {
            pw.print(best.get(i) + " ");
        }
        pw.println(best.get(best.size() - 1));

    }

    public static void solve(int[] currentLeft, int currentScoop,
            ArrayList<Integer> sb)
    {
        if (allRequirementsGood(currentLeft))
        {
            answers.add(sb);
        }
        else
        {
            for (int i = currentScoop + 1; i <= numFeeds; i++)
            {
                ArrayList<Integer> s = (ArrayList<Integer>) sb.clone();
                hm.put(currentLeft, s);
                sb.add(i);
                solve(subtract(currentLeft, feeds[i - 1]), i, sb);
                sb = hm.get(currentLeft);
            }
        }
    }


    public static boolean allRequirementsGood(int[] requirements)
    {
        for (int i = 0; i < requirements.length; i++)
        {
            if (requirements[i] > 0)
            {
                return false;
            }
        }
        return true;
    }

    public static int[] subtract(int[] one, int[] two)
    {
        int[] answer = new int[one.length];
        for (int i = 0; i < one.length; i++)
        {
            answer[i] = one[i] - two[i];
        }
        return answer;
    }




}

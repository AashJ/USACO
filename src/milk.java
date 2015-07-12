import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
ID: 17aashi1
LANG: JAVA
TASK: milk
 */
public class milk
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("milk.in"));
        PrintWriter pw = new PrintWriter((new File("milk.out")));

        HashMap<Integer, Integer> milkMap = new HashMap<Integer, Integer>();

        int milkNeeded = sc.nextInt();
        int numFarmers = sc.nextInt();
        int[][] milkArray = new int[numFarmers][2];

        for (int i = 0; i < numFarmers; i++)
        {
            milkArray[i][0] = sc.nextInt();
            milkArray[i][1] = sc.nextInt();
        }

        final Comparator<int[]> arrayComparator = new Comparator<int[]>()
        {
            @Override public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];

            }
        };

        Arrays.sort(milkArray, arrayComparator);
        List<int []> milkArr = new ArrayList(Arrays.asList(milkArray));
        int currentMilk = 0;
        int totalPrice = 0;
        while (currentMilk < milkNeeded)
        {
            if ((milkArr.get(0))[1] <= milkNeeded - currentMilk)
            {
                totalPrice += (((milkArr.get(0))[0]) * (milkArr.get(0))[1]);
                currentMilk += (milkArr.get(0))[1];
                milkArr.remove(0);
            }
            else
            {
                totalPrice += (milkNeeded - currentMilk) * ((milkArr.get(0))
                        [0]);
                currentMilk += (milkNeeded - currentMilk);
            }
        }
        pw.println(totalPrice);
        pw.close();
    }
}

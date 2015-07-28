import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
ID: 17aashi1
TASK: frac1
LANG: JAVA
 */
public class frac1
{
    private static Scanner sc;
    private static PrintWriter pw;
    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("frac1.in"));
        pw = new PrintWriter(new File("frac1.out"));

        int n = sc.nextInt();
        TreeMap<Double, String> map = new TreeMap<Double, String>();
        populateMap(n, map);
        solve(map);
        pw.close();
    }

    public static void populateMap(int n, TreeMap<Double, String> map)
    {
        for (int denominator = n; denominator >= 1; denominator--)
        {
            for (int numerator = 0; numerator <= denominator; numerator++)
            {
                Double val = ((double) numerator / (double) denominator);
                String p = new String(numerator + "/" + denominator);
                map.put(val, p);
            }
        }
    }

    public static void solve(TreeMap<Double, String> map)
    {
        for (Double d : map.keySet())
        {
            String p = map.get(d);
            pw.println(p);
        }
    }
}

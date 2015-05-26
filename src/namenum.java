import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: namenum
 */
public class namenum
{
    private static int counting = 0;
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("namenum.in"));
        Scanner dictScanner = new Scanner(new File("dict.txt"));
        PrintWriter pw = new PrintWriter(new File("namenum.out"));
        HashMap numpad = new HashMap<Integer, Integer>();
        BigInteger target = new BigInteger(sc.nextLine());
        int count = 2;
        int doublecount = 0;
        for (int i = 0; i < 25; i++)
        {
            if (i + 65 != 81 && i + 65 != 90)
            {
                if (doublecount != 0 && doublecount % 3 == 0)
                {
                    count++;
                }
                numpad.put(i + 65, count);
                doublecount++;
            }
        }

        printAnswers(target, dictScanner, pw, numpad);
        if (counting == 0)
        {
            pw.println("NONE");
        }
        pw.close();

    }

    public static BigInteger stringToNum(String string, HashMap<Integer,
            Integer>
            numpad)
    {
        BigInteger counter = BigInteger.valueOf(1);
        BigInteger digit = BigInteger.valueOf(0);
        for (int i = string.length() - 1; i >= 0; i--)
        {
            char curChar = string.charAt(i);
            if (curChar != 'Q' && curChar != 'Z')
            {
                BigInteger curNum = BigInteger.valueOf(numpad.get
                        ((int) curChar));
                digit = digit.add(counter.multiply(curNum));
            }
            counter = counter.multiply(BigInteger.valueOf(10));
        }
        return digit;
    }

    public static void printAnswers(BigInteger target, Scanner dictScanner,
            PrintWriter
            pw,
            HashMap<Integer, Integer> numpad)
    {
        while (dictScanner.hasNext())
        {
            String curString = dictScanner.nextLine();
            if (stringToNum(curString, numpad)
                    .compareTo(target) == 0)
            {
                pw.println(curString);
                counting++;
            }
        }
    }
}

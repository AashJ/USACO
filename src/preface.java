import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: preface
 */
public class preface
{
    private static Scanner sc;
    private static PrintWriter pw;
    private static int numPages;
    private static int[] counts = new int[7];
    private static String[] numerals = new String[] {"I", "V", "X", "L", "C", "D", "M"};

    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("preface.in"));
        pw = new PrintWriter(new File("preface.out"));

        numPages = sc.nextInt();
        solve();
        pw.close();
    }

    public static void solve()
    {
        for (int i = 1; i <= numPages; i++)
        {
            convertToRoman(i);
        }
        for (int k = 0; k < counts.length; k++)
        {
            if (counts[k] == 0)
            {
                break;
            }
            else
            {
                pw.println(numerals[k] + " " + counts[k]);
            }
        }
    }

    public static String convertToRoman(int n)
    {
        String answer = "";
        while (n >= 1000)
        {
            answer += "M";
            n -= 1000;
            counts[6]++;
        }
        while (n >= 900)
        {
            answer += "CM";
            n -= 900;
            counts[4]++;
            counts[6]++;
        }
        while (n >= 500)
        {
            answer += "D";
            n -= 500;
            counts[5]++;
        }
        while (n >= 400)
        {
            answer += "CD";
            n -= 400;
            counts[4]++;
            counts[5]++;
        }
        while (n >= 100)
        {
            answer += "C";
            n -= 100;
            counts[4]++;
        }
        while (n >= 90)
        {
            answer += "XC";
            n -= 90;
            counts[2]++;
            counts[4]++;
        }
        while (n >= 50)
        {
            answer += "L";
            n -= 50;
            counts[3]++;
        }
        while (n >= 40)
        {
            answer += "XL";
            n -= 40;
            counts[2]++;
            counts[3]++;
        }
        while (n >= 10)
        {
            answer += "X";
            n -= 10;
            counts[2]++;
        }
        while (n >= 9)
        {
            answer += "IX";
            n -= 9;
            counts[0]++;
            counts[2]++;
        }
        while (n >= 5)
        {
            answer += "V";
            n -= 5;
            counts[1]++;
        }
        while (n >= 4)
        {
            answer += "IV";
            n -= 4;
            counts[0]++;
            counts[1]++;
        }
        while (n >= 1)
        {
            answer += "I";
            n -= 1;
            counts[0]++;
        }
        System.out.println(answer);
        return answer;
    }
}

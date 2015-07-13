import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: crypt1
 */
public class crypt1
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("crypt1.in"));
        PrintWriter pw = new PrintWriter(new File("crypt1.out"));

        int numDigits = sc.nextInt();
        int[] digits = new int[numDigits];

        for (int i = 0; i < numDigits; i++)
        {
            digits[i] = sc.nextInt();
        }
        ArrayList<Integer> threeDigitNums = new ArrayList<Integer>();
        for (int fD = 0; fD < digits.length; fD++)
        {
            for (int sD = 0; sD < digits.length; sD++)
            {
                for (int tD = 0; tD < digits.length; tD++)
                {
                    int firstDigit = digits[fD];
                    int secondDigit = digits[sD];
                    int thirdDigit = digits[tD];

                    int number = (firstDigit * 100) + (secondDigit * 10) +
                            thirdDigit;
                    threeDigitNums.add(number);

                }
            }
        }
        int counter = 0;
        for (int fD = 0; fD < digits.length; fD++)
        {
            for (int sD = 0; sD < digits.length; sD++)
            {
                int d = digits[fD];
                int e = digits[sD];
                int number = (d * 10) + (e);

                for (int currentIndex = 0; currentIndex < threeDigitNums.size
                        (); currentIndex++)
                {
                    int currentThreeDigitNumber = threeDigitNums.get
                            (currentIndex);

                    int pp1 = e * currentThreeDigitNumber;
                    int pp2 = d * currentThreeDigitNumber;

                    int product = currentThreeDigitNumber * number;

//                    Partial Products are three digits long
                    if ((pp1 >= 100 && pp1 < 1000) && (pp2 >= 100 && pp2 <
                            1000))
                    {
                        if (isContained(pp1, digits) && isContained
                            (pp2, digits) && isContained(product, digits))
                        {
                            counter++;
                        }
                    }
                }

            }
        }
        pw.println(counter);
        pw.close();
    }

    private static boolean isContained(int number, int[] digits)
    {
        int sub = number;
        while (sub > 0)
        {
            boolean alpha = false;
            int currentDigit = sub % 10;

            for (int i : digits)
            {
                if (currentDigit == i)
                {
                    alpha = true;
                }
            }
            if (!alpha)
            {
                return false;
            }
            sub /= 10;
        }
        return true;
    }


}

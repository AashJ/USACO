import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: sort3
LANG: JAVA
 */
public class sort3
{
    private static Scanner sc;
    private static PrintWriter pw;
    private static int ones;
    private static int twos;
    private static int threes;
    private static int count;
    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("sort3.in"));
        pw = new PrintWriter(new File("sort3.out"));

        int n = sc.nextInt();

        count = 0;
        ones = 0;
        twos = 0;
        threes = 0;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
        {
            int num = sc.nextInt();
            if (num == 1)
            {
                ones++;
            }
            else if (num == 2)
            {
                twos++;
            }
            else
            {
                threes++;
            }
            nums[i] = num;
        }
        solve(nums);
        System.out.println("debug");
        pw.println(count);
        pw.close();
    }

    public static void solve(int[] nums)
    {
        for (int i = 0; i < nums.length - 1; i++)
        {
            int temp1 = nums[i];
            if (!isCorrect(temp1, i))
            {
                int tempIndex = 0;
                for (int k = i + 1; k < nums.length; k++)
                {
                    int temp2 = nums[k];

                    if (!isCorrect(temp2, k) && isCorrect(temp2, i))
                    {
                        tempIndex = k;
                        if (isCorrect(temp1, k))
                        {
                            tempIndex = k;
                            break;
                        }
                    }
                }
                nums[i] = nums[tempIndex];
                nums[tempIndex] = temp1;
                count++;
            }
        }
    }

    public static boolean isCorrect(int num, int index)
    {
        if (num == 1 && index < ones)
        {
            return true;
        }
        else if (num == 2 && index >= ones && index < ones + twos)
        {
            return true;
        }
        else if (num == 3 && index >= (ones + twos))
        {
            return true;
        }
        return false;
    }
}

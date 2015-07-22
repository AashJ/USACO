import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: milk3
LANG: JAVA
 */
public class milk3
{
    private static PrintWriter pw;
    private static Scanner sc;
    private static boolean[][][] allGood;
    private static ArrayList<Integer> answers = new ArrayList<Integer>();
    public static void main(String[] args)throws IOException
    {
        sc = new Scanner(new File("milk3.in"));
        pw = new PrintWriter(new File("milk3.out"));

        Bucket bucketA = new Bucket(sc.nextInt(), 0);
        Bucket bucketB = new Bucket(sc.nextInt(), 0);
        int cCapacity = sc.nextInt();
        Bucket bucketC = new Bucket(cCapacity, cCapacity);

        allGood = new boolean[bucketA.getCapacity() +
                1][bucketB.getCapacity() + 1][bucketC.getCapacity() + 1];
        solve(bucketA, bucketB, bucketC);

        Collections.sort(answers);
        for (int i = 0; i < answers.size() - 1; i++)
        {
            pw.print(answers.get(i) + " ");
        }
        pw.println(answers.get(answers.size() - 1));
        pw.close();

    }


    public static void solve(Bucket A, Bucket B, Bucket C)
    {
        if (allGood[A.getCurrentMilk()][B.getCurrentMilk()][C.getCurrentMilk()])
        {
            return;
        }
        allGood[A.getCurrentMilk()][B.getCurrentMilk()][C.getCurrentMilk()] =
                true;

        if (A.getCurrentMilk() == 0)
        {
            answers.add(C.getCurrentMilk());
        }

        solve(transfer(C, A)[1], B, transfer(C, A)[0]);

        solve(transfer(A, C)[0], B, transfer(A, C)[1]);

        solve(transfer(B, A)[1], transfer(B, A)[0], C);

        solve(transfer(A, B)[0], transfer(A, B)[1], C);

        solve(A, transfer(C, B)[1], transfer(C, B)[0]);

        solve(A, transfer(B, C)[0], transfer(B, C)[1]);
    }

    public static Bucket[] transfer(Bucket A, Bucket B)
    {
        Bucket temp1 = new Bucket(A.getCapacity(), A.getCurrentMilk());
        Bucket temp2 = new Bucket(B.getCapacity(), B.getCurrentMilk());
        if (temp1.getCurrentMilk() <= temp2.getSpace())
        {
            temp2.setCurrentMilk(temp2.getCurrentMilk() + temp1.getCurrentMilk
                    ());
            temp1.setCurrentMilk(0);
        }
        else
        {
            temp1.setCurrentMilk(temp1.getCurrentMilk() - temp2.getSpace());
            temp2.setCurrentMilk(B.getCapacity());
        }
        return new Bucket[] {temp1, temp2};
    }
}

class Bucket
{
    private int capacity;
    private int currentMilk;
    private int ID;

    public Bucket(int capacity, int currentMilk)
    {
        this.capacity = capacity;
        this.currentMilk = currentMilk;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public int getCurrentMilk()
    {
        return currentMilk;
    }

    public void setCurrentMilk(int newMilk)
    {
        currentMilk = newMilk;
    }

    public int getSpace()
    {
        return capacity - currentMilk;
    }
}

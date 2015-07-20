import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/*
ID: 17aashi1
TASK: ariprog
LANG: JAVA
 */
public class ariprog
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("ariprog.in"));
        PrintWriter pw = new PrintWriter(new File("ariprog.out"));

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> squares2 = new ArrayList<Integer>();
        for (int i = 0; i <= m; i++)
        {
            for (int k = 0; k <= m; k++)
            {
                int square = (int) (Math.pow(i, 2) + Math.pow(k, 2));
                if (!squares2.contains(square))
                    squares2.add(square);
            }
        }
        //List<Integer> squares2 = asSortedList(squares);
        int counter = 0;
        for (int diff = 1; diff <= (Math.pow(m, 2)); diff++)
        {
            for (int sq : squares2)
            {
                boolean answer = true;
                int c = sq;
                for (int i = 0; i < n - 1; i++)
                {
                    if (!squares2.contains(c + diff))
                    {
                        answer = false;
                        break;
                    }
                    c += diff;
                }
                if (answer)
                {
                    pw.println(sq + " " + diff);
                    counter++;
                }
            }
        }

        if (counter == 0)
        {
            pw.println("NONE");
        }
        pw.close();
    }

}


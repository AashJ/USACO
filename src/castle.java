import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class castle
{
    private static Scanner sc;
    private static PrintWriter pw;
    private static int numRows;
    private static int numCols;
    private static int[][] rooms;
    private static boolean[][] seen;
    private static int count = 0;

    public static void main(String[] args) throws IOException
    {
        sc = new Scanner(new File("castle.in"));
        pw = new PrintWriter(new File("castle.out"));

        numCols = sc.nextInt();
        numRows = sc.nextInt();

        seen = new boolean[numRows][numCols];

        rooms = new int[numRows][numCols];


        for (int currentRow = 0; currentRow < numRows; currentRow++)
        {
            for (int currentColumn = 0; currentColumn < numCols;
                 currentColumn++)
            {
                rooms[currentRow][currentColumn] = sc.nextInt();
            }
        }


        for (int currentRow = 0; currentRow < numRows; currentRow++)
        {
            for (int currentColumn = 0; currentColumn < numCols;
                 currentColumn++)
            {
                count = 0;
                findSizes(currentRow, currentColumn);
            }
        }

        System.out.println("debug");

    }

    private static void findSizes(int row, int column)
    {
        if (seen[row][column])
        {
            return;
        }
        count++;
        seen[row][column] = true;
        int value = rooms[row][column];
        if (value == 11)
        {
            findSizes(row, column + 1);

        }
        else if (value == 6)
        {
            findSizes(row, column - 1);
            findSizes(row + 1, column);

        }
        else if (value == 3)
        {
            findSizes(row, column + 1);
            findSizes(row + 1, column);
        }
        else if (value == 10)
        {
            findSizes(row, column + 1);
            findSizes(row, column - 1);
        }
        else if (value == 7)
        {
            findSizes(row + 1, column);
        }
        else if (value == 9)
        {
            findSizes(row - 1, column);
            findSizes(row, column + 1);
        }
        else if (value == 13)
        {
            findSizes(row - 1, column);
        }
        else if (value == 5)
        {
            findSizes(row + 1, column);
            findSizes(row - 1, column);
        }
        else if (value == 1)
        {
            findSizes(row + 1, column);
            findSizes(row - 1, column);
            findSizes(row, column + 1);
        }
        else if (value == 12)
        {
            findSizes(row - 1, column);
            findSizes(row, column - 1);
        }
        else if (value == 0)
        {
            findSizes(row + 1, column);
            findSizes(row - 1, column);
            findSizes(row, column + 1);
            findSizes(row, column - 1);
        }
        rooms[row][column] = count;
    }


}

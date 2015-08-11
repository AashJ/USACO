import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
ID: 17aashi1
TASK: castle
LANG: JAVA
 */
public class castle
{
    private static PrintWriter pw;
    private static Scanner sc;
    private static int numColumns;
    private static int numRows;
    private static ArrayList<Room[]> edgeList = new ArrayList<Room[]>();
    private static ArrayList<TotalRoom> roomList = new ArrayList<TotalRoom>();
    public static void main(String[] args) throws IOException
    {
        pw = new PrintWriter(new File("castle.out"));
        sc = new Scanner(new File("castle.in"));

        numColumns = sc.nextInt();
        numRows = sc.nextInt();

        populateEdgeList();

        System.out.println("debug");

        for (Room[] r : edgeList)
        {

        }

    }

    public static void populateEdgeList()
    {
        for (int curRow = 0; curRow < numRows; curRow++)
        {
            for (int curCol = 0; curCol < numColumns; curCol++)
            {
                int thisNum = sc.nextInt();

                if (thisNum == 11 || thisNum == 3 || thisNum == 10 || thisNum
                        == 9 || thisNum == 1 || thisNum == 8 || thisNum == 0)
                {
                    Room[] connected = new Room[2];
                    connected[0] = new Room(curRow, curCol);
                    connected[1] = new Room(curRow, curCol + 1);
                    edgeList.add(connected);
                }
                if (thisNum == 6 || thisNum == 3 || thisNum == 7 || thisNum
                        == 5 || thisNum == 0)
                {
                    Room[] connected = new Room[2];
                    connected[0] = new Room(curRow, curCol);
                    connected[1] = new Room(curRow + 1, curCol);
                    edgeList.add(connected);
                }
            }
        }
    }
}

class Room
{
    private int row;
    private int column;

    public Room(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }
}

class TotalRoom
{
    private ArrayList<Room> allRooms = new ArrayList<Room>();
    private int count = 0;



    public void addRoom(Room r)
    {
        allRooms.add(r);
        count++;
    }

    public ArrayList<Room> getAllRooms()
    {
        return allRooms;
    }
}

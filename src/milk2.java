import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: milk2
 */
public class milk2
{
    private static Scanner sc;


    public static void main (String[] args) throws IOException
    {
        sc = new Scanner(new File("milk2.in"));
        PrintWriter out = new PrintWriter(new File("milk2.out"));
        int numberOfCows = sc.nextInt();
        Interval intervals[] = new Interval[numberOfCows];
        for (int i = 0; i < numberOfCows; i++)
        {
            intervals[i] = new Interval(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(intervals, 
                new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2)
            {
                return o1.getLow() - o2.getLow();
            }
        }); 
        
        int low = intervals[0].getLow();
        int high = intervals[0].getHigh();
        int maxInterval = high-low;
        int maxGap = 0;
        for(int i=1; i<intervals.length; i++) {
            Interval a = intervals[i];
            if (a.getLow() <= high) {
                high = Math.max(a.getHigh(), high);
            } else {
                maxInterval = Math.max(maxInterval, high-low);
                maxGap = Math.max(maxGap, a.getLow()-high);
                low = a.getLow();
                high = a.getHigh();
            }
        }
 
        out.println(maxInterval + " " + maxGap);
        out.close();
    }
    
    
    private static class Interval {
        private final int low;
        private final int high;
 
        public Interval(int low, int high) {
            this.low = low;
            this.high = high;
        }
 
        public int getLow() {
            return this.low;
        }
 
        public int getHigh() {
            return this.high;
        }
    }
}

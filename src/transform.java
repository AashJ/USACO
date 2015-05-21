import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
ID: 17aashi1
LANG: JAVA
TASK: transform
 */
public class transform
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));
        int rows = sc.nextInt();
        char[][] firstPattern = new char[rows][rows];
        for (int currentRow = 0; currentRow < rows; currentRow++)
        {
            String currentString = sc.next();
            for (int j = 0; j < currentString.length(); j++)
            {
                firstPattern[currentRow][j] = currentString.charAt(j);
            }
        }
        char[][] secondPattern = new char[rows][rows];
        for (int currentR = 0; currentR < rows; currentR++)
        {
            String currentString = sc.next();
            for (int j = 0; j < currentString.length(); j++)
            {
                secondPattern[currentR][j] = currentString.charAt(j);
            }
        }
        
        if (compareArray(rotateNinety(firstPattern), secondPattern))
        {
            out.println("1");
        }
        else if (compareArray(rotateOneEighty(firstPattern), secondPattern))
        {
            out.println("2");
        }
        else if (compareArray(rotateTwoSeventy(firstPattern), secondPattern))
        {
            out.println("3");
        }
        else if (compareArray(reflect(firstPattern), secondPattern))
        {
            out.println("4");
        }
        else if (compareArray(rotateNinety(reflect(firstPattern)), secondPattern))
        {
            out.println("5");
        }
        else if (compareArray(rotateOneEighty(reflect(firstPattern)), secondPattern))
        {
            out.println("5");
        }
        else if (compareArray(rotateTwoSeventy(reflect(firstPattern)), secondPattern))
        {
            out.println("5");
        }
        else if (compareArray(firstPattern, secondPattern))
        {
            out.println("6");
        }
        else 
        {
            out.println("7");
        }
        out.close();
    }
    
    private static char[][] rotateNinety(char[][] firstPattern)
    {
        int rows = firstPattern.length;
        char[][] answer = new char[rows][rows];
        for (int i = 0; i < answer.length; i++)
        {
            int cur = answer.length - 1;
            for (int k = 0; k < answer.length; k++)
            {
                answer[i][k] = firstPattern[cur][i];
                cur--;
            }
        }
        return answer;
    }
    
    private static char[][] rotateOneEighty(char[][] firstPattern)
    {
        int rows = firstPattern.length;
        char[][] answer = new char[rows][rows];
        int curR = rows - 1;
        for (int i = 0; i < answer.length; i++)
        {
            int curC = rows - 1;
            for (int k = 0; k < rows; k++)
            {
                answer[i][k] = firstPattern[curR][curC];
                curC--; 
            }
            curR--;
        }
        
        return answer;
    }
    
    
    private static char[][] rotateTwoSeventy(char[][] firstPattern)
    {
        int rows = firstPattern.length;
        char[][] answer = new char[rows][rows];
        int cur = rows - 1;
        for (int i = 0; i < rows; i++)
        {
            for (int k = 0; k < rows; k++)
            {
                answer[i][k] = firstPattern[k][cur];
                
            }
            cur--;
        }
        return answer;
    }
    
    private static char[][] reflect(char[][] firstPattern)
    {
        int rows = firstPattern.length;
        char[][] answer = new char[rows][rows];
        
        for (int i = 0; i < rows; i++)
        {
            int cur = rows - 1;
            for (int k = 0; k < rows; k++)
            {
                answer[i][k] = firstPattern[i][cur];
                cur--;
            }
        }
        
        return answer;
    }
    
    private static boolean compareArray(char[][] firstPattern, char[][] secondPattern)
    {
        boolean answer = true;
        for (int i = 0; i < firstPattern.length; i++)
        {
            for (int k = 0; k < firstPattern.length; k++)
            {
                if (firstPattern[i][k] != secondPattern[i][k])
                {
                    answer = false;
                }
            }
        }
        return answer;
    }
    
}

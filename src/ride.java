/*
ID: 17aashi1
LANG: JAVA
TASK: ride
 */
import java.io.*;
import java.util.*;
public class ride
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String alpha = f.readLine();
		String beta = f.readLine();
		int alphaMultiple = 1;
		for (int i = 0; i < alpha.length(); i++)
		{
			alphaMultiple *= alpha.charAt(i) - 'A' + 1; 
		}
		int betaMultiple = 1;
		for (int j = 0; j < beta.length(); j++)
		{
			betaMultiple *= beta.charAt(j) - 'A' + 1; 
		}
		int alphaAnswer = alphaMultiple % 47;
		int betaAnswer = betaMultiple % 47;
		if (alphaAnswer == betaAnswer)
		{
			out.write("GO\n");
		}
		else
		{
			out.write("STAY\n");
		}
		out.close();
		System.exit(0);
	}
}

/*
ID: 17aashi1
LANG: JAVA
TASK: gift1
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class gift1 
{
	public static void main (String [] args) throws IOException
	{
		Scanner alpha = new Scanner(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("gift1.out"));
		int numberOfPeople = alpha.nextInt();
		List<String> people = new ArrayList<String>();
		for (int i = 0; i < numberOfPeople; i++)
		{
			people.add(alpha.next());
		}
		Map<String, Integer> peopleMap = new HashMap<String, Integer>();
		for (String names : people)
		{
			peopleMap.put(names, 0);
		}
		for (int i = 0; i < numberOfPeople; i++)
		{
			String person = alpha.next();
			int money = alpha.nextInt();
			int numPeople = alpha.nextInt();
			String[] peopleNames = new String[numPeople];
			for (int k = 0; k < numPeople; k++)
			{
				peopleNames[k] = alpha.next();
			}
			divideMoney(person, money, numPeople, peopleMap, peopleNames);
		}
		for (String person : people)
		{
			out.println(person + " " + (peopleMap.get(person)));
					
		}
		out.close();
	}
	
	private static void divideMoney(String person, int money, int numPeople, Map<String, Integer> peopleMap, String[] peopleNames)
	{
		if (numPeople != 0 || money != 0)
		{
			int moneyForEach = money/numPeople;
			for (int i = 0; i < peopleNames.length; i++)
			{
				int currentMoney = peopleMap.get(peopleNames[i]);
				peopleMap.put(peopleNames[i], currentMoney + moneyForEach);
			}
			int personMoney = peopleMap.get(person);
			int leftOver = money%numPeople;
			peopleMap.put(person, personMoney + leftOver - money);
		}
	}
}

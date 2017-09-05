//Isaac Bordfeld

package Examstats;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Examstats {

	public static void main(String [] args) throws IOException
	{
	System.out.println("What is the name of the file that your grades are located? (remember, you may need to add .txt at the end of your file name");
	//Imported grades
	Scanner cin = new Scanner(System.in);
	
	String file = cin.next();
	Scanner grade = new Scanner(new FileReader(file));
	
	int g = grade.nextInt();
	
	int [] y = new int[g];
	
	
	for(int i=0; i<g; i++)
	{
		y[i] = grade.nextInt();	
	}
	Arrays.sort(y);
	
	/*for(int e=0; e<g; e++)
	{
		System.out.println(y[e]);
	}*/
	
	
	grade.close();
	cin.close();
	
	printGradesInfo(y);
	
	}
	
		

	static int gradesMin(int [] grades)
	{
		return grades[0];
		//System.out.println("Your lowest grade was a"+ grades[0] +":(");
	}
	
	static int gradesMax(int [] grades)
	{
	    return grades[grades.length-1];	
	}
	
	static double gradesMean(int [] grades)
	{	
		int a = 0;
		
		for(int i = 0; i<grades.length; i++)
		{
			a=a+grades[i];
		}
		return (double)a/grades.length;
	}
	
	static double gradesMedian(int [] grades)
	{
	    double median = 0;
	    if(grades.length % 2 == 0)
	    {
	    	median = ((double)grades[grades.length/2] + (double)grades[grades.length/2 -1])/2;
	    }
	    else
	    {
	    	median = grades[1/2];
	    }
	    return median;
	}

	static int [] gradesDistribution(int [] grades)
	{
	
		   int [] t = new int [5];
		   for(int i = 0; i<5; i++)
		   {
			   t[i] = 0;
		   }
		   
		   
		   for(int i = 0; i<grades.length; i++)
			{
			   
		   if(grades[i] >= 90)
		   {
			   t[0]++;
		   }
		   else if(grades[i] >= 80)
		   {
			   t[1]++;
		   }
		   else if(grades[i] >= 70)
		   {
			   t[2]++;
		   }
		   else if(grades[i] >= 60)
		   {
			   t[3]++;
		   }
		   else if(grades[i] >= 0)
		   {
			   t[4]++;
		   }
		}
		   return t;	}
	
	static void printGradesInfo(int [] grades)
	{
	System.out.println("lowest grade is " + gradesMin(grades));
	System.out.println( "-----------");
	System.out.println("Highest grade is " + gradesMax(grades));
	System.out.println( "-----------");
	System.out.println("Your average grade is " + gradesMean(grades));
	System.out.println( "-----------");
	System.out.println("Your median is " + gradesMedian(grades));
	System.out.println("------------");
		
	//New Section - Grade Distribution
	System.out.println("Grade Distribution");
	//Provide a space for neatness
	System.out.println( "-----------");
	
	int [] t = gradesDistribution(grades);
	//List of Grades
	System.out.println("You have "+ t[0] +"A's in your list");
	System.out.println("You have "+ t[1] +"B's in your list");
	System.out.println("You have "+ t[2] +"C's in your list");
	System.out.println("You have "+ t[3] +"D's in your list");
	System.out.println("You have "+ t[4] +"F's in your list");
	}
}
/**
 * Title: Partition.java
 * Abstract: This program checks if an array has partition in it or not.
 * Author: Arash Aria
 * ID: 4210
 * Date: 09/12/2015
 */

import java.io.IOException;
import java.util.Scanner;


public class Partition {
	
	//drives the program with reading array and array size from user 
	//and printing if it has partitions.
	public static void main(String[] args) throws IOException {
		
		@SuppressWarnings("resource")
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Number of input:");
		int num = myScanner.nextInt();
		System.out.println("Enter " + num + " Numbers");
		int[] array = new int[num];
		for (int i = 0; i < num; i++)
		{
			array[i] = myScanner.nextInt();
		}
		if (findPartition(array, num) == true)
		{
			System.out.println("Yes there is a partition");
		}
		else
		{
			System.out.println("No partition found");
		}
		
	
	}
	//subset finder calls itself recursively to find all possible subset with
	//sum equal to half of the sum of the original array
	public static boolean findSubsets (int array[], int num, int halfOfSum)
	{
		
		if (halfOfSum == 0)
		{	
			return true;		
		}
		
		if (num == 0 && halfOfSum!=0)
		{
			return false;
		}
		
		if (array[num-1] > halfOfSum)
		{
			return findSubsets (array, num-1, halfOfSum);
		}
		
		return findSubsets (array, num-1, halfOfSum) || findSubsets (array, num-1, halfOfSum-array[num-1]);
	}
	
	//checking if partitioning is possible or not based on the sum of the array
	//if possible calling the subset finder
	public static boolean findPartition (int array[], int num)
	{
		int sum = 0;
		
		for (int i = 0; i<array.length; i++)
		{
			sum = sum+ array[i];
		}
		if (sum%2 != 0)
		{
			return false;
		}
		return findSubsets (array, num, sum/2);
	}
}



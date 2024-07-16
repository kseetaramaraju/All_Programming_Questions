package arrays;

import java.beans.IndexedPropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.AbstractSpinnerModel;

public class Problems_On_Arrays {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println(" enter array size ");
		int size=sc.nextInt();
		int arr[]=new int[size];
		System.out.println(" enter array elements ");
		for(int i=0;i<size;i++)
		{
			arr[i]= sc.nextInt();
		}

		//1
		// Two Sum: Given an array of integers, return indices of the two numbers such that they
		// add up to a specific target.

		// target
		//System.out.println(" enter target num ");
		//int target=sc.nextInt();

		//		String two_sum = two_sum(arr,target);
		//		System.out.println(two_sum);


		//2 
		//remove duplicates from sorted array

		//		int n = remove_Duplicates(arr);
		//		System.out.println(n);

		// 3
		//		int sum = max_subarray(arr);
		//		System.out.println(sum);

		//4
		//		int[] res = product_Of_Array_Except_ItSelf(arr);
		//		System.out.println(Arrays.toString(res));

		//5 
		// rotate array by k number of times where k should be positive 

		//		int[] res = rotate_Right(arr,2);
		//		System.out.println(Arrays.toString(res));

		// 6 
		//merge two sorted arrays
		//		System.out.println(" enter second array size ");
		//		int size1=sc.nextInt();
		//		int arr1[]=new int[size1];
		//		System.out.println(" enter array elements ");
		//		for(int i=0;i<size1;i++)
		//		{
		//			arr1[i]= sc.nextInt();
		//		}
		//		merge_Two_Sorted_Arrays(arr,arr1);

		//7
		// Pascal's triangle
		//		System.out.println(" enter length of rows ");
		//		int n=sc.nextInt();
		//		List<List<Integer>> pascals_Triangle = pascals_Triangle(n);
		//		for(int i=0;i<pascals_Triangle.size();i++)
		//		{
		//			System.out.println(pascals_Triangle.get(i));
		//		}

		// 8
		// done in leetcode 
		// check given sudoku is valid or not 

		// 9
		// Missing Number 
		//		int s = missing_Number(arr);
		//		System.out.println(s);

		// 10 
		// Moving Zeros
		moving_Zeros(arr);

	}

	private static void moving_Zeros(int[] arr)
	{
		ArrayList<Integer> list=new ArrayList<>();

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=0)
			{
				list.add(arr[i]);
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==0)
			{
				list.add(arr[i]);
			}
		}
		for(int i=0;i<list.size();i++)
		{
			arr[i]=list.get(i);
		}
		System.out.println(Arrays.toString(arr));

	}

	private static int missing_Number(int[] arr) 
	{
		int n=arr.length;
		int sum=(n*(n+1))/2;
		int tsum=0;
		for(int i=0;i<arr.length;i++)
		{
			tsum=tsum+arr[i];
		}
		return sum-tsum;
	}

	private static List<List<Integer>> pascals_Triangle(int n) 
	{
		List<List<Integer>> res=new ArrayList<>();
		if(n<=0)
		{
			return res;
		}
		List<Integer> firstrow=new ArrayList<>();
		firstrow.add(1);
		res.add(firstrow);
		if(n==1)
		{
			return res;
		}
		for(int i=1;i<n;i++)
		{
			List<Integer> prevRow = res.get(i-1);
			ArrayList<Integer> row=new ArrayList<>();
			row.add(1);
			for(int j=0;j<i-1;j++)
			{
				row.add(prevRow.get(j)+prevRow.get(j+1));
			}
			row.add(1);
			res.add(row);
		}
		return res;
	}

	private static void merge_Two_Sorted_Arrays(int[] arr1, int[] arr2) 
	{
		int i=0;
		int j=0;
		int k=0;
		int res[]=new int[arr1.length+arr2.length];
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]>arr2[j])
			{
				res[k++]=arr2[j++];
			}
			else
			{
				res[k++]=arr1[i++];
			}
		}
		while(i<arr1.length)
		{
			res[k++]=arr1[i++];
		}
		while(j<arr2.length)
		{
			res[k++]=arr2[j++];
		}
		System.out.println(" arr 1 "+Arrays.toString(arr1));
		System.out.println(" arr 2 "+Arrays.toString(arr2));
		System.out.println(" res array "+Arrays.toString(res));
	}

	private static int[] rotate_Right(int[] arr,int n)
	{
		if(n>0)
		{
			for(int j=0;j<n;j++)
			{
				int temp=arr[arr.length-1];
				for(int i=arr.length-1;i>=1;i--)
				{
					arr[i]=arr[i-1];
				}
				arr[0]=temp;	
			}

		}
		return arr;
	}

	private static int [] product_Of_Array_Except_ItSelf(int[] arr) 
	{
		int left[]=new int[arr.length];
		int right[]=new int[arr.length];

		// left 
		left[0]=1;
		for(int i=1;i<left.length;i++)
		{
			left[i]=left[i-1]*arr[i-1];
		}

		// right 
		right[right.length-1]=1;
		for(int i=right.length-2;i>=0;i--)
		{
			right[i]=right[i+1]*arr[i+1];
		}

		// now multiplying both the arrays left and right

		for(int i=0;i<arr.length;i++)
		{
			arr[i]=left[i]*right[i];
		}
		return arr;

	}

	private static int max_subarray(int[] arr)
	{
		int maxsum=arr[0];
		int sum=arr[0];
		String ind="";
		for(int i=1;i<arr.length;i++)
		{
			if(sum>=0)
			{
				sum=sum+arr[i];
			}
			else
			{
				sum=arr[i];
			}
			if(sum>maxsum)
			{
				maxsum=sum;
			}
		}
		return maxsum;
	}

	private static int remove_Duplicates(int[] arr)
	{
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			set.add(arr[i]);
		}
		return set.size();
	}

	private static String two_sum(int[] arr, int target) 
	{
		int sum=arr[0]+arr[1];
		if(sum==target)
		{
			return "[0,1]";
		}

		for(int i=1;i<arr.length-1;i++)
		{
			sum=arr[i]+arr[i+1];
			if(sum==target)
			{
				return "["+i+","+(i+1)+"]";
			}
		}
		return "-1";
	}
}

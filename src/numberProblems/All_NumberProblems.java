package numberProblems;

import java.util.Scanner;

public class All_NumberProblems {
	public static void main(String[] args) {

		//		Scanner sc=new Scanner(System.in);
		//		System.out.println(" enter input ");
		//		int num=sc.nextInt();

		// 1
		//print_numbers_from_1_to_100();

		// 2
		//System.out.println(primeNumber(num));

		//3 
		// Fibonassi Sequence
		//fibonassi_Series(num);

		// 4
		// factorial of a number 
		//factorial(num);

		//5 
		//palindrome_Number(num);

		// 6
		//armstrong(num);

		// 7
		//reverse_Number(num);

		// 8
		// matrix transpose
		//		int arr[][]= {
		//				{1,2,3},
		//				{4,5,6},
		//				{7,8,9}
		//		};
		//		matrix_transpose(arr);

		// 9 
		// finding hcf or gcd and lcm of two numbers 
		// hcf - Highest Common Factor
		// gcd - Greatest Common Divisor

		//		Scanner sc=new Scanner(System.in);
		//		System.out.println(" enter input 1 ");
		//		int n1=sc.nextInt();
		//		System.out.println(" enter input 2 ");
		//		int n2=sc.nextInt();

		//		int res = gcdBrutForce(n1,n2);
		//		System.out.println(" Using Brutforce solution "+res);
		//
		//		int r = gcd_Subtraction(n1,n2);
		//		System.out.println(" Using substraction solution "+r);
		//
		//		int r1 = gcd_Division(n1,n2);
		//		System.out.println(" Using division solution "+r1);


		//		System.out.println(lcm_BrutForce(n1,n2));
		//
		//		System.out.println(lcm_UsingGCD(n1,n2));


		// 10 
		// convert from binary number to decimal number 
		Scanner sc=new Scanner(System.in);
		System.out.println(" enter input 1 ");
		int n=sc.nextInt();

		convert_Binary_To_Decimal(n);


	}

	private static void convert_Binary_To_Decimal(int n)
	{
		int sum=0;
		int i=0;
		while(n!=0)
		{
			int rem=n%10;
			sum=sum+(int)Math.pow(2,i++)*rem;
			n=n/10;
		}
		System.out.println(" decimal number is : "+sum);
	}

	private static int lcm_UsingGCD(int n1, int n2)
	{
		return (n1*n2)/gcd_Division(n1, n2)	;	
	}

	private static int  lcm_BrutForce(int n1, int n2)
	{
		int max=Math.max(n1, n2);
		while(true)
		{
			if(max%n1==0 && max%n2==0)
			{
				return max;
			}
			max++;
		}
	}

	private static int gcd_Division(int n1, int n2)
	{
		while(n1!=0 && n2!=0)
		{
			if(n1>n2)
			{
				n1=n1%n2;
			}
			else
			{
				n2=n2%n1;
			}
		}
		if(n1!=0)
		{
			return n1;
		}
		return n2;
	}

	private static int gcd_Subtraction(int n1, int n2)
	{
		while(n1!=n2)
		{
			if(n1>n2)
			{
				n1=n1-n2;
			}
			else
			{
				n2=n2-n1;
			}
		}
		return n1;
	}

	private static int gcdBrutForce(int n1, int n2)
	{
		int min=Math.min(n1, n2);

		for(int i=min;i>=2;i--)
		{
			if(n1%i==0 && n2%i==0)
			{
				return i;
			}
		}
		return 1;
	}

	private static void matrix_transpose(int[][] arr) 
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr[i].length;j++)
			{
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}

		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

	private static void reverse_Number(int num) 
	{
		int rev=0;
		int temp=num;
		while(temp!=0)
		{
			int rem=temp%10;
			rev=rev*10+rem;
			temp=temp/10;
		}
		System.out.println(rev);
	}

	private static void armstrong(int num)
	{
		String s=""+num;
		int powerCount=s.length();
		int temp=num;
		int sum=0;

		while(temp!=0)
		{
			int rem=temp%10;
			sum=sum+(int)Math.pow(rem,powerCount);
			temp=temp/10;
		}
		if(sum==num)
		{
			System.out.println(sum+" is ArmStrong "+num);
		}
		else
		{
			System.out.println(sum+" is Not ArmStrong "+num);
		}

	}

	private static void palindrome_Number(int num)
	{
		int rev=0;
		int temp=num;

		while(temp!=0)
		{
			int rem=temp%10;
			rev=rev*10+rem;
			temp=temp/10;
		}
		if(rev==num)
		{
			System.out.println(rev+" Given Number is Palindrome "+num);
		}
		else
		{
			System.out.println(rev+" Given Number is Not Palindrome "+num);
		}
	}

	private static void factorial(int num) 
	{
		int fact=1;

		for(int i=1;i<=num;i++)
		{
			fact=fact*i;
		}
		System.out.println(fact);
	}

	private static void fibonassi_Series(int num) 
	{
		int n1=0;
		int n2=1;
		int n3=0;
		System.out.println(n1);
		System.out.println(n2);
		int count=2;
		while(count<num)
		{
			n3=n1+n2;
			System.out.println(n3);
			n1=n2;
			n2=n3;
			count++;
		}

	}

	private static boolean primeNumber(int num)
	{
		for(int i=2;i<num/2;i++)
		{
			if(num%i==0)
			{
				return false;
			}
		}
		return true;
	}

	private static void print_numbers_from_1_to_100()
	{
		for(int i=1;i<=100;i++)
		{
			if(i%3==0)
			{
				System.out.println("Fizz");
			}
			else if(i%5==0)
			{
				System.out.println("Buzz");
			}
			else if(i%3==0 && i%5==0)
			{
				System.out.println("FizzBuzz");
			}
			else
			{
				System.out.println(i);
			}
		}

	}
}

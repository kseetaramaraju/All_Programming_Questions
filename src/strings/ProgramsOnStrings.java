package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramsOnStrings {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println(" enter string 1 ");
		String s = sc.nextLine();
		System.out.println(" enter string 2 ");
		String p = sc.nextLine();

		// 1
		//palindrome(s);
		//System.out.println("---------------");
		//2
		//anagram_Or_Not(s1,s2);

		//3
		//reverse(s1);

		//4
		//StringCompression(s1);

		//5
		//countWord(s1);

		//6
		//longest_Distinct_SubString(s1);

		// 7 
		// Find ALL Anagrams in a String
		find_All_Anagrams(s,p);

		// 8
		//convert_String_To_Integer(s1);

		//9
		//valid_Palindrome(s1);

		//10
		//reverse_Each_Word(s1);

	}

	private static List<Integer> find_All_Anagrams(String s, String p)
	{
		int sl=s.length();
		int pl=p.length();

		if(pl>sl)
		{
			return new ArrayList();
		}

		// creating arrays for both s,p
		int sArr[]=new int[26];
		int pArr[]=new int[26];

		// inserting characters present in p in parr and for s in sArr also

		for(int i=0;i<pl;i++)
		{
			pArr[p.charAt(i)-'a']++;
			sArr[s.charAt(i)-'a']++;
		}
		List<Integer> res=new ArrayList<Integer>();

		for(int i=pl;i<sl;i++)
		{
			if(Arrays.equals(sArr, pArr))
			{
				res.add(i-pl);
			}
			sArr[s.charAt(i)-'a']++;
			sArr[s.charAt(i-pl)-'a']--;
		}

		if(Arrays.equals(sArr, pArr))
		{
			res.add(sl-pl);
		}
		return res;
	}

	private static void reverse_Each_Word(String s1)
	{
		String[] str = s1.split(" ");
		for(int i=0;i<str.length;i++)
		{
			String s=str[i];
			for(int j=s.length()-1;j>=0;j--)
			{
				System.out.print(s.charAt(j));
			}
			System.out.print(" ");
		}
	}

	private static void valid_Palindrome(String s) 
	{

		char[] ch = s.toCharArray();
		String res="";

		for(int i=0;i<ch.length;i++)
		{
			if(Character.isAlphabetic(ch[i]) || Character.isDigit(ch[i]) )
			{
				res=res+ch[i];
			}
		}
		System.out.println(" after removing special characters : "+res);
		palindrome(res);
	}

	private static void convert_String_To_Integer(String s1)
	{

		// first way
		int parseInt = Integer.parseInt(s1);
		System.out.println(parseInt);

		// second way
		int rev=0;
		for(int i=0;i<s1.length();i++)
		{
			char ch = s1.charAt(i);
			rev=rev*10+(ch-48);
		}
		System.out.println(rev);

	}

	private static void longest_Distinct_SubString(String s1) 
	{
		s1=s1.toLowerCase();
		int maxl=0;
		for(int i=0;i<s1.length();i++)
		{
			HashSet<Character> set=new HashSet<>();
			for(int j=i;j<s1.length();j++)
			{
				Character ch=s1.charAt(j);
				if(set.contains(ch))
				{
					if(set.size()>maxl)
					{
						maxl=set.size();
					}
					set.clear();
					break;
				}
				else
				{
					set.add(ch);
				}
			}
		}
		System.out.println(maxl);

	}

	private static void countWord(String s1) 
	{
		String s = remove_ExtraSpaces(s1);
		String[] split = s.split(" ");
		System.out.println(" Word Count In Sentence is "+split.length);
	}

	private static String remove_ExtraSpaces(String s) 
	{
		int index = remove_lastSpaces(s);
		s=s.substring(0,index+1);
		String res="";		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch==' ')
			{
				if(s.charAt(i+1)==' ')
				{
					continue;
				}
				else
				{
					res=res+ch;
				}
			}
			else
			{
				res=res+ch;
			}
		}
		return res;
	}

	private static int remove_lastSpaces(String s) 
	{
		for(int i=s.length()-1;i>=0;i--)
		{
			char ch=s.charAt(i);
			if(ch!=' ')
			{
				return i;
			}
		}
		return -1;
	}

	private static void StringCompression(String s1)
	{
		String res="";
		char[] ch = s1.toCharArray();
		boolean b[]=new boolean[ch.length];
		for(int i=0;i<ch.length;i++)
		{
			int count=0;
			if(b[i]==true)
			{
				continue;
			}
			else
			{
				for(int j=0;j<ch.length;j++)
				{
					if(ch[i]==ch[j])
					{
						count++;
						b[j]=true;
					}
				}
			}
			if(count>=1)
			{
				System.out.println(ch[i]+" ---> "+count);
				res=res+ch[i]+count;
			}
		}
		System.out.println(res);
	}

	private static void reverse(String s1) 
	{

		// first way 
		String res="";
		for(int i=0;i<s1.length();i++)
		{
			res=s1.charAt(i)+res;
		}
		System.out.println(res);

		// second way
		String collect = Stream.of(s1)
				.map(e -> new StringBuffer(e).reverse())
				.peek(e -> System.out.println(e))
				.collect(Collectors.joining());
		System.out.println(collect);

	}

	private static void anagram_Or_Not(String s1,String s2) 
	{
		if(s1.length()==s2.length())
		{
			// sorting 
			char[] ch1 = sort(s1);
			char[] ch2 = sort(s2);
			// removing spaces 
			char[] ch3 = remove_Spaces(ch1);
			char[] ch4 = remove_Spaces(ch2);

			boolean b=true;
			for(int i=0;i<ch3.length;i++)
			{
				if(ch3[i]!=ch4[i])
				{
					b=false;
					break;
				}
			}
			if(b)
			{
				System.out.println(" Given two Strings are is anagrams ");	
			}
			else
			{
				System.out.println(" Given two Strings are not  anagrams ");
			}

			System.out.println(Arrays.equals(ch3,ch4));

		}
		else
		{
			System.out.println(" Not Anagram !! ");
		}
	}

	private static char[] remove_Spaces(char[] ch)
	{
		String s="";
		for(int i=0;i<ch.length;i++)
		{ 
			if(ch[i]!=' ')
			{
				s=s+ch[i];
			}
		}
		return s.toCharArray();
	}

	private static char[] sort(String s)
	{
		char[] ch= s.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			for(int j=0;j<ch.length-1;j++)
			{ 
				if(ch[j]>ch[j+1])
				{
					char temp=ch[j];
					ch[j]=ch[j+1];
					ch[j+1]=temp;
				}
			}
		}
		return ch;
	}

	private static void palindrome(String s)
	{
		// first way 
		String rev="";
		for(int i=0;i<s.length();i++)
		{
			rev=s.charAt(i)+rev;
		}
		if(rev.equalsIgnoreCase(s))
		{
			System.out.println(" Given String "+s+" is Palindrome ");
		}
		else
		{
			System.out.println(" Given String "+s+" is NOT Palindrome ");	
		}

		//second way
		s=s.toUpperCase();
		char[] ch = s.toCharArray();
		boolean b=true;
		for(int i=0;i<ch.length/2;i++)
		{
			if(ch[i]!=ch[ch.length-1-i])
			{
				b=false;
				break;
			}
		}
		if(b)
		{
			System.out.println(" Given String "+s+" is Palindrome ");	
		}
		else
		{
			System.out.println(" Given String "+s+" is NOT Palindrome ");
		}
		// third way
		String  ss=s;
		boolean noneMatch = IntStream
				.range(0,s.length()/2)
				.noneMatch( i -> ss.charAt(i)!=ss.charAt(ss.length()-i-1));
		if(noneMatch)
		{
			System.out.println(" Given String "+s+" is Palindrome ");	
		}
		else
		{
			System.out.println(" Given String "+s+" is NOT Palindrome ");
		}
	}
}

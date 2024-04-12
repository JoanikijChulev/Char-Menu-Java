package p1;
import java.util.Arrays;
import java.util.Scanner;

//Joanikij Chulev.
//This project is all my own work.
//I have not knowingly allowed others to copy my work.


public class CharacterMenu {
	
	public static char [][] globalChar=new char[3][3];
	public static String [] globalwords=new String[3];
	//we declare a public char and string which we will use in the main program multiple times through the methods.

	public static void enterChars(char[][] ch) 
	{

		for (int i=0;i<ch.length;i++)
		{	
			for(int j=0;j<ch[i].length;j++)
			{
				System.out.println(i+" "+j);
				Scanner a = new Scanner(System.in);
				ch[i][j]=a.next().charAt(0);
			}
		}

		globalChar=ch;

	}	
	//We use a nested for loop to enter the array which is comprised of characters. 
	//Starting with [0][0] until [2][2].
	//we place our newly generated characters in globalChar so we may later use it in the main program.

	public static void displayArray(char[][] ch) {

		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[i].length;j++)
			{
				System.out.print(ch[i][j]);
			}
			System.out.println();
		}
	}	
	//We use a nested for loop to display the array in order.

	public static void wordCount(char[][] ch, String[] words) {

		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[i].length;j++)
			{
				if(words[i]!=null)
				{
					words[i]=words[i]+String.valueOf(ch[i][j]);
				}
				else {
					words[i]=String.valueOf(ch[i][j]);
				}
			}
			System.out.print(words[i]+" / ");

		}
		globalwords=words;
		System.out.println();
	}	
	//We use a nested for loop to integrate the character in the if statement to fill up a blank String and create a word.
	//Null means empty. So the [0] position of the word is empty and we place a value of [i][j] from the array. Meaning now the string will not be Null and we will add up the characters in the if statement.

	public static void palindromeCount(char[][] ch, String[] words) {

		String [] rev=new String[words.length];
		int countPalindrome=0;
		for(int i=0;i<words.length;i++)
		{
			for(int j=words.length-1;j>=0;j--) {
				if(rev[i]!=null)
				{
					rev[i]=rev[i]+String.valueOf(ch[i][j]);
				}
				else {
					rev[i]=String.valueOf(ch[i][j]);
				}
			}
			if(rev[i].equals(words[i]))
			{

				System.out.println(words[i]+ " is palindrome");
				countPalindrome++;
			}
		}
		System.out.println("Palindrome count: "+countPalindrome);
	}
	//We create a new string called rev(reversed). It takes the length from words. We than integrate the ch values from the array into the new string but reversed values for j.
	//The same rule for the Null value stands here.
	//We than test if rev is equal to words. If this is the case we print it out and add 1 to the counter.

	public static void anagramCount(char[][] ch, String[] words) {

		char[] arrayWord1=words[0].toLowerCase().toCharArray();
		Arrays.sort(arrayWord1);
		char[] arrayWord2=words[1].toLowerCase().toCharArray();
		Arrays.sort(arrayWord2);
		char[] arrayWord3=words[2].toLowerCase().toCharArray();
		Arrays.sort(arrayWord3);
		
		if(Arrays.equals(arrayWord1,arrayWord2))
		{
			System.out.println("Anagram 1 2");
		}
		if(Arrays.equals(arrayWord2,arrayWord3))
		{
			System.out.println("Anagram 2 3");
		}
		if(Arrays.equals(arrayWord1,arrayWord3))
		{
			System.out.println("Anagram 1 3");
		}
		else {
			System.out.println("No anagrams have been detected.");
		}

	}
	//We set 3 new 1 dimensional char arrays. We take the words strings and we transform them to lower case and to characters. 
	//Later we sort them in alphabetical order. Than we compare if they are equal.If they are it is an anagram.

	public static void main(String[] args) {

		int numberValue=0;
		do {

			Scanner number=new Scanner(System.in);
			System.out.println("	*MENU*");
			System.out.println("1. Write chars.");
			System.out.println("2. Display chars.");
			System.out.println("3. Display legal words.");
			System.out.println("4. Display palindroms and count.");
			System.out.println("5. Anagrams.");
			System.out.println("6 Exit.");
			numberValue=number.nextInt();
			switch(numberValue) {

			case 1:CharacterMenu.enterChars(new char[3][3]);
			break;
			case 2:CharacterMenu.displayArray(globalChar);
			break;
			case 3:CharacterMenu.wordCount(globalChar, new String[3]);
			break;
			case 4:CharacterMenu.palindromeCount(globalChar, globalwords);
			break;
			case 5:CharacterMenu.anagramCount(globalChar, globalwords);
			break;
			case 6:System.out.println("Exit");
			break;
			default:System.out.println("Incorrect input");
			break;
			}
		}
		while(numberValue != 6);
	}

//This is the main program. We use all the previous methods here.We make a menu using switch.
//We make a case for each method. We invoke each method in every case. We exit with case 6.

}
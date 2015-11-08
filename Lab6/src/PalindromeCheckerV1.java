/**
 * Palindrome checker using only stacks.
 * 
 *
 * Dakota Hawkins and Newman Knowlton.
 */

import java.util.Scanner;

public class PalindromeCheckerV1
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;
		ListStack<Character> palindromeFwd = new ListStack<Character>();
		ListStack<Character> palindromeBwd = new ListStack<Character>();

		do {
			System.out.println("Enter a string:");

			message = scan.nextLine();

			/**
			 * Now determine if message is a palindrome or not
			 */
			for(int i=0; i<message.length();i++){
				palindromeFwd.push(message.charAt(i)); //Pushes the message onto the stack forward
				palindromeBwd.push(message.charAt(message.length()-i-1)); //Pushes message backward
			}
			boolean isPalindrome=true;
			//Checks if the forward stack matches the backward stack
			for(int i=0; i<message.length();i++){
				if(!palindromeFwd.pop().equals(palindromeBwd.pop())){
					isPalindrome = false;
				}
			}
			if(message.length()!=0){
				if(isPalindrome)
					System.out.println(message+" is a palindrome");
				else
					System.out.println(message+" is not a palindrome");
			}
		}
		while (message.length() != 0);

		scan.close();
	}
}
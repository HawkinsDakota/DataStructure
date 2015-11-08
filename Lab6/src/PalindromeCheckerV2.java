/**
 * Palindrome chekcer using a stack and a queue.
 *
 * Dakota Hawkins and Newman Knowlton
 */

import java.util.Scanner;

public class PalindromeCheckerV2
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;
		ListStack<Character> palinStack = new ListStack<Character>();
		ListQueue<Character> palinQueue = new ListQueue<Character>();

		do {
			System.out.println("Enter a string:");

			message = scan.nextLine();

			/**
			 * Now determine if message is a palindrome or not
			 */
			for(int i=0; i<message.length();i++){
				palinStack.push(message.charAt(i)); //adds char to stack
				palinQueue.add(message.charAt(i)); // adds char to queue
			}
			boolean isPalindrome=true;
			//Since stacks are LIFOs and queues are FIFOs, 
			//no index manipulation is necessary.
			for(int i=0; i<message.length();i++){
				if(!palinStack.pop().equals(palinQueue.remove())){
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
// Moore's Voting law
/*
Given an array of length N return the element which has occurences more than n/2, 

There are M political parties; N People will vote and their vote will be number of political party index

return the party which will win (index)

CONSTRAINT :- It has to be done in O(n) time complexity and auxiliary space O(1)
*/


public class VotingChallenge {

	public static int[] cast = { 1, 2, 3, 1, 2, 3, 1, 1, 1, 1 };
	/*
		There are 3 parties here 1, 2, 3.
		Number of people voting are 10.
	*/ 
	public static void main(String[] args) {
		/* // My Implementation shitty stuff ...:( auxiliary space O(n) for an extra array too bad
       // works fine but sucks in space issues.
		int[] count = new int[cast.length];
		int count1 = 0;
		for(int i=0; i<cast.length; i++) {
			System.out.println("Run count " + (++count1));
			int num = ++count[cast[i]];
			if(num > cast.length/2) {
				System.out.println("Winner is candidate " + cast[i]);
				break;
			}
		}*/
		/*
		// Sir Moore's Implementation must propose an edit

		int count = 1, majorityIndex = 0;
		for(int i=1; i<cast.length; i++) {
			if(cast[i]==cast[majorityIndex])
				count++;
			else
				count--;
			if(count==0) { // no majority at this point
				majorityIndex=i;
				count=1;
			}
		}
		System.out.println("Majority element is " + cast[majorityIndex]);
		*/
	}
}

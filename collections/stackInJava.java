// stackInJava.java in java 

import java.util.*;

public class stackInJava {
	static void showPush(Stack<Integer> st, Integer num) {
		st.push(num);
	}

	static int showPop(Stack<Integer> st) {
		Integer a = st.pop();
		// return item;
		return a;
	}
	
	public static void main(String[] args) throws Exception {
		Stack<Integer> st = new Stack<Integer>();
		showPush(st, 12);
		/*showPush(st, 11);
		showPush(st, 10);
		showPush(st, 9);*/
		System.out.println("Popped is " + showPop(st));
		try { // underflow condition
			System.out.println("Popped is " + showPop(st));
		}catch(Exception ex) { System.out.println("Exception thrown is " + ex); }

	}
}
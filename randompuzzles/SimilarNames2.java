import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class SimilarNames2
{
	public int permute(int num) {
		int permute=num;
		for(int i=num-1; i>1; i--) {
			permute *= i; 
		}
		return permute;
	}
	
	public int count(String[] names, int L)
	{	int x, y, count=0, finalcount=0;
		ArrayList<String> keys = new ArrayList<String>(names.length);
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		
		for(x=0; x<names.length; x++)
			for(y=0; y<names.length; y++) {
				if(!(names[x]==names[y])){
					if(names[y].startsWith(names[x])) {
						ArrayList<String> ar = new ArrayList<String>();
						if(hm.containsKey(names[x])) {
							 ar = hm.get(names[x]);
							 ar.add(names[y]);
							 hm.put(names[x], ar);
						}
						else {
							System.out.println("key " + names[x]);
							// store the key
							keys.add(names[x]);
							ar.add(names[y]);
							hm.put(names[x], ar);
						}		
					}
				}
			}
			
			if(keys.size()==0)
				return 0;
			else {	
				int matchLen = L-1;
				for(int j=0; j<keys.size(); j++) {
					ArrayList<String> ar = new ArrayList<String>();
					String key = keys.get(j);
					ar = hm.get(key);
					// calculating the number of permutations
					if(ar.size() == matchLen) { 
						finalcount = finalcount + ( )
					}
				}
				// int finalcalc = count * (permute(names.length - L));
				return finalcalc;
			}		
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}" + "," + p1);
		System.out.println("]");
		SimilarNames2 obj;
		int answer;
		obj = new SimilarNames2();
		long startTime = System.currentTimeMillis();
		answer = obj.count(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		String[] p0;
		int p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new String[]{"kenta","kentaro","ken"};
		p1 = 2;
		p2 = 3;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"hideo","hideto","hideki","hide"};
		p1 = 2;
		p2 = 6;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"aya","saku","emi","ayane","sakura","emika","sakurako"};
		p1 = 3;
		p2 = 24;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"taro","jiro","hanako"};
		p1 = 2;
		p2 = 0;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new String[]{"alice","bob","charlie"};
		p1 = 1;
		p2 = 6;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new String[]{"ryota","ryohei","ryotaro","ryo","ryoga","ryoma","ryoko","ryosuke","ciel","lun","ryuta","ryuji","ryuma","ryujiro","ryusuke","ryutaro","ryu","ryuhei","ryuichi","evima"};
		p1 = 3;
		p2 = 276818566;
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!

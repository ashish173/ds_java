
public class WolfDelaymaster {
	static char[] arr = {'w', 'o', 'l', 'f'};

	public static void main(String[] args) {
		String str = "wolfwwoollffwwwooolllfffwwwwoooollllffff";
		System.out.println(" "+  check(str));
	}

	public static String check(String str) {
		int count=0;
		for(int i=0; i<str.length(); i = i + ((count)*4),count=0 ) {
			// System.out.println("Value of i " + i);
			if(str.charAt(0)!='w')
				return "INVALID";
			if(str.charAt(i)=='w') {
				// System.out.println("we get the first char as w");
				for(int j=i; j<str.length(); j++) {
					if(str.charAt(j)=='w') {
						count++;
						// System.out.println("we got " + count + "w's");
					}
					if(str.charAt(j+1)=='o') {
						//count++;
						break;
					}
				}
				// System.out.println("Number of w " + (count));
				boolean result = validate(str, i,count);
				if(!result)
					return "INVALID";
				// i = i + ((count)*4); // tranffered to the for loop conditoin
				// count=0;
			}
		}
		return "VALID";
	}
	public static boolean validate(String str, int index, int times) {
		// System.out.println("from " + from + " number of w's " + times);
		for(int i=0; i<4; i++) { // 1 iteration for w,o,l,f each
			// System.out.println("In for loop checking rules");
			for(int j=0; j<times; j++) { // runs 
				if(str.charAt(index + j + i*times)!=arr[i])
					return false;
			}
		}	
		return true;
	}

}
public class WolfDelaymaster {
	public static void main(String[] args) {
		String str = "wolfwwoollffwwwooolllfffwwwwoooollllffff";
		System.out.println(" "+  check(str));
	}

	public static String check(String str) {
		int count=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='w') {
				System.out.println("we get the first char as w");
				for(int j=i;j<str.length(); j++) {
					if(str.charAt(j+1)=='o')
						break;
					if(str.charAt(j+1)=='w') {
						System.out.println("we got " + count + "w's");
						count++;
					}
				}
				boolean result = validate(str, i,count*4);
				if(!result)
					return "INVALID";
				i = i+count*4;
				count=0;
			}
		}
		// returns either VALID or INVALID
		return "VALID";
	}
	public static boolean validate(String str, int from,int times) {
		for(int i=from; i<i+times; i++) {

		}	

		return true;
	}

}



public class RaiseThisBarn {
	public static void main(String[] args) {
		int result = clac("............");	
		System.out.println("result is " + result);
	}	

	public static int clac(String str) {
		int length = str.length(),count=0,dots=0,count1=0;
		for(int i=0; i<length; i++) {
			if(str.charAt(i)=='c')
				count++;
		}
		System.out.println("count is " + count);
		if(count%2!=0)
			return 0;
		if(count==0)
			return length-1;
		for(int i=0; i<length; i++) {
			System.out.println("processing char " + str.charAt(i));
			if(str.charAt(i)=='c') {
				System.out.println("added c count");
				count1++;
			}
			if(count1==count/2 && str.charAt(i)=='.') {
				System.out.println("added dot count");	
				dots++;
			}
		}
		return dots+1;
	}
}
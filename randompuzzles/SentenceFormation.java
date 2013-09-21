// SentenceFormation.java
//
public class SentenceFormation {
    static String[] dict = {"swim","swimmed","swimming","edge","gem","met","etopi","opia","arms", "topi", "rms"};
    // "rms", "arms" are present in our dictionary
    
    static String message = "swimmedgemetopiarms";
    static int messageLength = message.length();
    static boolean sentenceFormationFlag = false;   // checks for last word in the message is in dictionary
    static String[] decipheredMessage;
    static int pointer = -1;
    
    // main driver function 
    public static void main(String[] args) {
    	// System.out.println("this is main");
    	makeSentence(0); // passing index of message to the makeSentence
  	} 

  	// recursive function to break the message
  	public static boolean makeSentence(int index) {
  		if(index==messageLength-1 && sentenceFormationFlag==true) { // base case 
  			// end of message and sentenceFormation flag True
  			return true;
  		}
  		else if(index==messageLength-1 && sentenceFormationFlag==false) {  // another base case
  			// end of message and sentenceFormation flag False	
  			return false;
  		}
  		else { // final condition
  			String word="";
  			for(int i=index; i<messageLength; i++) {
  				word = word + message.charAt(i);
  				// System.out.println("word is " + word);

  				if(search(word) && i==messageLength-1) {
  					// System.out.println("made the sentence " + word);
  					// makeSentence(i+1);
  					sentenceFormationFlag=true;
  					System.out.println(" " + word);	
  					return true;
  				}
				else if(search(word)) {
  					// System.out.println("make sentence called for word " + word);
  					makeSentence(i+1);
  					if(sentenceFormationFlag==true) {
  						// System.out.println(" " + word);  // prints the words after sentence formation
  						// add the words to an array of strings
  						decipheredMessage[pointer] = new String();
  						decipheredMessage[pointer++] = word;
  						return true;
  					}
				}
  			}
  		}
  		showMessage(decipheredMessage);
  		return true;
  	}

  	public static boolean search(String key) {
  		for(int i=0; i<dict.length; i++) {
  			if(dict[i].equals(key)) {
  				// System.out.println("got a word in dict");
  				return true;
  			}
  		}
  		return false;
  	}

  	public static void showMessage(String[] decipheredMessage) {
  		if(decipheredMessage != null) {
  			for(int i=decipheredMessage.length; i>=0; i--)
  				System.out.println(" " + decipheredMessage[i]);
  		}
  	}

}

// Lottery.java 
// problem statement
// Class:
// Lottery
// Method:
// sortByOdds
// Parameters:
// String[]
// Returns:
// String[]
// Method signature:
// String[] sortByOdds(String[] rules)
// (be sure your method is public)
// rules are an array of strings 
// {"INDIGO: 93 8 T F",
//  "ORANGE: 29 8 F T",
//  "VIOLET: 76 6 F F",
//  "BLUE: 100 8 T T",
//  "RED: 99 8 T T",
//  "GREEN: 78 6 F T",
//  "YELLOW: 75 6 F F"}

public class Lottery {
    
    
    public static void main(String args[]) {
        String[] rules = {  "INDIGO: 93 8 T F",
                            "ORANGE: 29 8 F T",
                            "VIOLET: 76 6 F F",
                            "BLUE: 100 8 T T",
                            "RED: 99 8 T T",
                            "GREEN: 78 6 F T", 
                            "YELLOW: 75 6 F F" };

        String[] sortedLotteries = sortByOdds(rules);
        System.out.println("Sorted lotteries " + sortedLotteries);
    }

    public static String[] sortByOdds(String[] rules) {
        String[] sortedArray;   // stores the lotteries in sorted order
        int numberOfLotteries = rules.length;
        int[] scores = new int[numberOfLotteries];
        
        System.out.println("Number of Lotteries " + numberOfLotteries);
        
        // for all lotteries calculate Probability
        for(int i=0; i<numberOfLotteries; i++) {
            scores[i] = calcProb(rules[i]);
        }
        
        // scores = sort(scores);

        return null;
    }
    
    // function to calculate the probability of winning of lottery ticket
    public static int calcProb(String rule) {
        System.out.println(rule);
        return 0;
    }

    //public static int[] sort(int[] arr) {
    //    return 0;
    //}
}

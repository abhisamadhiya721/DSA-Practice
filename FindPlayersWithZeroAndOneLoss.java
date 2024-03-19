import java.util.*;

public class FindPlayersWithZeroAndOneLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompting the user to enter the number of matches
        System.out.print("Enter the number of matches: ");
        int numMatches = scanner.nextInt();
        
        // Creating an array to store match results
        int[][] matches = new int[numMatches][2];
        
        // Getting match results from the user
        System.out.println("Enter match results (winner's index followed by loser's index):");
        for (int i = 0; i < numMatches; i++) {
            System.out.print("Match " + (i + 1) + ": ");
            int winner = scanner.nextInt();
            int loser = scanner.nextInt();
            matches[i][0] = winner;
            matches[i][1] = loser;
        }
        
        // Invoking the findWinners method to find the winners
        List<List<Integer>> winners = findWinners(matches);
        
        // Displaying the results
        System.out.println("Players/Teams with no losses: " + winners.get(0));
        System.out.println("Players/Teams with one loss: " + winners.get(1));
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lost = new HashMap<>();
        
        for (int[] it : matches) {
            int lose = it[1];
            lost.put(lose, lost.getOrDefault(lose, 0) + 1);
        }
        
        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int[] it : matches) {
            int lose = it[1];
            int win = it[0];
            if (lost.get(lose) == 1) {
                oneLoss.add(lose);
            }
            if (!lost.containsKey(win)) {
                noLoss.add(win);
                lost.put(win, 2);
            }
        }
        
        Collections.sort(noLoss);
        Collections.sort(oneLoss);

        return Arrays.asList(noLoss, oneLoss);
    }
}

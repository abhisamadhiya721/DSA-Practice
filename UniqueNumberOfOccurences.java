import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int freq : map.values()){
            if(set.contains(freq)){
                return false;
            }
            set.add(freq);
        }
        return true;
    }
    
    public static void main(String[] args) {
        UniqueNumberOfOccurences solution = new UniqueNumberOfOccurences();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Result: " + solution.uniqueOccurrences(arr));
    }
}


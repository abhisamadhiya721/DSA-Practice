/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/
import java.util.*;
public class TwoSum
{
    public static int[] TwoSum(int arr[],int target)
    {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i =0 ;i<n;i++)
        {
            int remaining =target- arr[i];
            if(mp.containsKey(remaining))
            {
                System.out.println(mp.get(remaining)+""+i);
            return new int[]{mp.get(remaining),i};
            }
            mp.put(arr[i],i);
        } 
        return new int[]{};
    }
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++)
        {
            arr[i]= Sc.nextInt();
        }
        int target = Sc.nextInt();
        TwoSum(arr,target);
    }
}
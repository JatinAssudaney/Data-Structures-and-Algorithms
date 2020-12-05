package hashmap_heap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Pair {
	int left;
	int right;

	Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

public class MinimumMovestoMakeArrayComplementary {
	public static int minMoves(int[] nums) {
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (map.containsKey(sum)) {
				Pair p = new Pair(nums[left], nums[right]);
				ArrayList<Pair> rem = map.get(sum);
				rem.add(p);
				map.put(sum, rem);
			} else {
				Pair p = new Pair(nums[left], nums[right]);
				ArrayList<Pair> rem = new ArrayList<>();
				rem.add(p);
				map.put(sum, rem);
			}
			left++;
			right--;
		}
		int max = Integer.MIN_VALUE;
		for (int key : map.keySet()) {
			if (map.get(key).size() >= max) {
				max = map.get(key).size();
			}
		}
		return nums.length / 2 - max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(minMoves(nums));
		sc.close();
	}

}

import java.util.Scanner;

public class RichestCustomerWealth {

	public static int maximumWealth(int[][] accounts) {
		int maxWealth = Integer.MIN_VALUE;
		for (int i = 0; i < accounts.length; i++) {
			int sum = 0;
			for (int j = 0; j < accounts[0].length; j++) {
				sum += accounts[i][j];
			}
			maxWealth = Math.max(maxWealth, sum);
		}
		return maxWealth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int customers = sc.nextInt();
		int banks = sc.nextInt();
		int[][] accounts = new int[customers][banks];
		for (int i = 0; i < customers; i++) {
			for (int j = 0; j < banks; j++) {
				accounts[i][j] = sc.nextInt();
			}
		}
		System.out.println(maximumWealth(accounts));
		sc.close();
	}

}

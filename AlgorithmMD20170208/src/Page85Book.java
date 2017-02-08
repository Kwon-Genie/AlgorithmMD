import java.util.Scanner;

public class Page85Book {
	public static Scanner sc = new Scanner(System.in);
	public static int n, ans;
	public static int[] col = new int[10];
	public static int[] inc = new int[20];
	public static int[] dec = new int[20];
	
	public static void main(String[] args) {
		n = sc.nextInt();
		solve(1);
		System.out.println(ans);
	}
	
	public static void solve(int r) {
		if(r>n) {
			ans++;
			return;
		}
		for(int i=1; i<=n; i++) {
			if(col[i]!=1 && inc[r+i]!=1 && dec[n+(r-i)+1]!=1) {
				col[i] = inc[r+i] = dec[n+(r-i)+1] = 1;
				solve(r+1);
				col[i] = inc[r+i]=dec[n+(r-i)+1]=0;
			}
		}
	}
}

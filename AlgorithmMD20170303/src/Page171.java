import java.util.Scanner;

public class Page171 {
	public static Scanner sc = new Scanner(System.in);
	public static int n, m;
	public static int[][] g = new int[200][200];
	public static int[] visit = new int[200];
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int s, e;
			s = sc.nextInt();
			e = sc.nextInt();
			g[s][e] = g[e][s] = 1;
		}
		solve(0,1);
		for(int i=0; i<n; i++) {
			if(visit[i]==0) {
				System.out.println("IMPOSSIBLE");
				System.exit(0);
			} 
		}
		System.out.println("OK");
	}
	
	public static void solve(int v, int c) {
		visit[v] = c;
		int can = 1;
		for(int i=0; i<n; i++) {
			if(g[v][i]==1 && visit[i]==c) {
				can = 0;
			}
		}
		
		if(can==0) {
			visit[v] = 0;
			return;
		}
		for(int i=0; i<n; i++) {
			if(visit[i]==0 && g[v][i]==1) {
				solve(i,1);
				solve(i,2);
			}
		}
	}
}

/*
3
3
0 1
1 2
2 0
IMPOSSIBLE

9
8
0 1
0 2
0 3
0 4
0 5
0 6
0 7
0 8
OK
*/
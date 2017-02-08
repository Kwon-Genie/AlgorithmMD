import java.util.Arrays;
import java.util.Scanner;
/**
 * â���� �˰��� 77�� �δ��� ��(S)����
 * �����̴� ������ ���� ��� ����Ǿ� ������ �� ���� �� ������ �δ����� ��� ��
 * �̶�� ����� �߰��Ͽ���.
 * �����̴� �޻꿡 ��� �δ����� ��� �� �������� �ñ�������. �����̴� Ư�� ��
 * �� �̿��Ͽ� �޻��� �δ��� ���� ��� ��Ÿ�� ������ ���� �� �־���.
 * �� ������ ���簢���̰� ���� ���� ������ 0 �Ǵ� 1�� ǥ���Ѵ�. 0�� ���̰� 1��
 * �δ��� ���� ��Ÿ����. 1�� �����¿�� ����Ǿ� ������ �� ������ �δ����� ���
 * ������ ������ �� �ִ�.
 * 
 * �Է�
 * ù ��° �ٿ� ����, ������ ũ�⸦ ��Ÿ���� n�� �Էµȴ�.(n�� 30������ �ڿ���)
 * �� ��° �ٺ��� n�ٿ� ���ļ� n���� 0�� 1�� �������� ���еǾ� �Էµȴ�.
 * ���
 * ù° �ٿ� �δ��� ���� ���� ����Ѵ�. ��° �ٺ��� �� �δ��� ���� ũ�⸦ ����
 * �������� �� �ٿ� �ϳ��� ����Ѵ�.
 * @since jdk1.8
 * @author Genie
 *
 */
public class Page77 {
	public static int n=0;
	public static int[][] matrix;
	public static int count=0;
	public static int[] size;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		n = sc.nextInt();
		matrix = new int[n][n];
		size = new int[n];
		input();
		solve();
		output();
	}
	public static void input() {
		for(int row=0; row<n; row++) {
			for(int col=0; col<n; col++) {
				matrix[row][col] = sc.nextInt();
			}
		}
	}
	
	public static boolean safe(int a, int b) {
		return (0<=a && a<n) && (0<=b && b<n);
	}
	
	
	public static void dfs(int row, int col, int count) {
		matrix[row][col] = count;
		if(safe(row+1, col) && matrix[row+1][col]==1)
			dfs(row+1, col, count);
		if(safe(row-1, col) && matrix[row-1][col]==1)
			dfs(row-1, col, count);
		if(safe(row, col+1) && matrix[row][col+1]==1)
			dfs(row, col+1, count);
		if(safe(row, col-1) && matrix[row][col-1]==1)
			dfs(row, col-1, count);
	}
	
	public static void solve() {
		for(int row=0; row<n; row++) {
			for(int col=0; col<n; col++) {
				if(matrix[row][col]==1) {
					count++;
					dfs(row, col,count+1);
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(matrix[i][j]>1)
					size[matrix[i][j]-2]++;
			}
		}
		Arrays.sort(size);
	}
	
	public static void output() {
		System.out.println(count);
		for(int i=size.length-1; i>=0; i--) {
			if(size[i]>0)
				System.out.println(size[i]);
		}
	}
}

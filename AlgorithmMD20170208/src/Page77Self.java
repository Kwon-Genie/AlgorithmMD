import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
public class Page77Self {
	public static int n=0;
	public static int[][] matrix;
	public static int count=0;
	public static ArrayList<Integer> size = new ArrayList<Integer>();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		n = sc.nextInt();
		matrix = new int[n][n];
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
	
	public static int dfs(int row, int col) {
		matrix[row][col] = -1;
		int subSize = 0;
		if(safe(row+1, col) && matrix[row+1][col]==1){
			subSize++;
			subSize += dfs(row+1, col);
		}
		if(safe(row-1, col) && matrix[row-1][col]==1) {
			subSize++;
			subSize += dfs(row-1, col);
		}
		if(safe(row, col+1) && matrix[row][col+1]==1) {
			subSize++;
			subSize += dfs(row, col+1);
		}
		if(safe(row, col-1) && matrix[row][col-1]==1) {
			subSize++;
			subSize += dfs(row, col-1);
		}
		return subSize;
	}
	
	public static void solve() {
		for(int row=0; row<n; row++) {
			for(int col=0; col<n; col++) {
				if(matrix[row][col]==1) {
					count++;
					size.add(dfs(row, col)+1);
				}
			}
		}
		Collections.sort(size);
		Collections.reverse(size);
		
	}
	
	public static void output() {
		System.out.println(count);
		for(int value: size) {
		System.out.println(value);	
		}
	}
}

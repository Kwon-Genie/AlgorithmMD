import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/**
 * 창의적 알고리즘 77쪽 두더지 굴(S)문제
 * 정올이는 땅속의 굴이 모두 연결되어 있으면 이 굴은 한 마리의 두더지가 사는 집
 * 이라는 사실을 발견하였다.
 * 정올이는 뒷산에 사는 두더지가 모두 몇 마리인지 궁금해졌다. 정올이는 특수 장
 * 비를 이용하여 뒷산의 두더지 굴을 모두 나타낸 지도를 만들 수 있었다.
 * 이 지도는 직사각형이고 가로 세로 영역을 0 또는 1로 표현한다. 0은 땅이고 1은
 * 두더지 굴을 나타낸다. 1이 상하좌우로 연결되어 있으면 한 마리의 두더지가 사는
 * 집으로 정의할 수 있다.
 * 
 * 입력
 * 첫 번째 줄에 가로, 세로의 크기를 나타내는 n이 입력된다.(n은 30이하의 자연수)
 * 두 번째 줄부터 n줄에 걸쳐서 n개의 0과 1이 공백으로 구분되어 입력된다.
 * 출력
 * 첫째 줄에 두더지 굴의 수를 출력한다. 둘째 줄부터 각 두더지 굴의 크기를 내림
 * 차순으로 한 줄에 하나씩 출력한다.
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

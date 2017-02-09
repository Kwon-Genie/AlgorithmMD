import java.util.Scanner;
/**
 * 같이 9×9 격자판에 쓰여진 81개의 자연수가 주어질 때, 이들 중 최댓값을 찾고
 * 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
 * @since jdk1.8
 * @author Genie
 */
public class Page110 {
	/**
	 * sc: 사용자의 입력을 받는데 사용되는 변수
	 * board: 사용자의 입력을 받아 저장하는 이중 배열 크기는 9X9이다.
	 * row: 최댓값의 행을 저장하는 변수
	 * col: 최댓값의 열을 저장하는 변수
	 * max: 최댓값을 저장하는 변수
	 */
	public static Scanner sc = new Scanner(System.in);
	public static int[][] board = new int[9][9];
	public static int row, col, max;
	public static void main(String[] args) {
		input();
		solve();
		printAnswer();
	}
	
	/**
	 * 결과값을 출력하는 메서드
	 */
	public static void printAnswer() {
		System.out.println(max);
		System.out.println(row + " " + col);
	}
	
	/**
	 * board 이중배열에서 최댓값을 찾는 메서드
	 */
	public static void solve() {
		for(int i=0; i<9; i++) 
			for(int j=0; j<9; j++)
				if(board[i][j]>max) {
					max = board[i][j];
					row = i+1;
					col = j+1;
				}
	}
	
	/**
	 * 사용자로부터 9X9행렬의 값들을 받아서 저장하는 메서드
	 */
	public static void input() {
		for(int i=0; i<9; i++) 
			for(int j=0; j<9; j++) 
				board[i][j] = sc.nextInt();
	}
}

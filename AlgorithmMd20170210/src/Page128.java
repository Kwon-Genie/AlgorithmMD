import java.util.Scanner;
/**
 * 오목은 바둑판에 검은 바둑알과 흰 바둑알을 교대로 놓아서 겨루는 게임이다. 바
 * 둑판에는 가로, 세로 19개의 선으로 이루어져 있다.
 * 바둑알이 연속적으로 다섯 알이 놓이면
 * 그 색이 이기게 된다. 여기서 연속적이란 가로, 세로 또는 대각선 방향 모두를 뜻한다.
 * 즉, 위의 그림은 검은색이 이긴 경우이다. 하지만 여섯 알 이상이 연속적으로 놓인
 * 경우에는 이긴 것이 아니다. 입력으로 바둑판의 어떤 상태가 주어졌을 때, 검은색이
 * 이겼는지, 흰색이 이겼는지 또는 아직 승부가 결정되지 않았는지를 판단하는 프로그
 * 램을 작성하시오.
 * 단, 검은색과 흰색이 동시에 이기거나 검은색 또는 흰색이 두 군데 이상에서 동시
 * 에 이기는 경우는 입력으로 들어오지 않는다.
 * 입력
 * 입력 파일은 19줄에 각 줄마다 19개의 숫자로 표현되는데, 검은 바둑알은 1, 흰 바
 * 둑알은 2, 알이 놓이지 않은 자리는 0으로 표시되며, 숫자는 한 칸씩 띄어서 표시된다.
 * 출력
 * 첫 번째 줄에 검은색이 이겼을 경우에는 1을, 흰색이 이겼을 경우에는 2를, 아직
 * 승부가 결정되지 않았을 경우에는 0을 출력한다. 검은색 또는 흰색이 이겼을 경우에
 * 는 둘째 줄에 연속된 다섯 개의 바둑알 중에서 가장 왼쪽에 있는 바둑알(연속된 다
 * 섯 개의 바둑알이 세로로 놓인 경우, 그중 가장 위에 있는 것)의 가로줄 번호와 세로
 * 줄 번호를 순서대로 출력한다.
 * @since jdk1.8
 * @author Genie
 */
public class Page128 {
	public static Scanner sc = new Scanner(System.in);
	public static int[][] board = new int[19][19];
	public static int row, col, result;
	public static void main(String[] args) {
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		if(search(1)) 
			output(1);
		else if(search(2))
			output(2);
		else
			output(0);
	}
	
	/**
	 * 해당 type이 오목을 이겼는지 아닌지 찾는 메서드
	 * @param type
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean search(int type) {
		for(int j=0; j<19; j++) 
			for(int i=0; i<19; i++) 
				if(board[i][j]==type)
					if(check(type, i, j)) {
						row = i+1;
						col = j+1;
						return true;
					}
		return false;
	}
	
	public static boolean check(int type, int i, int j) {
		if(safe(i, j+4)) 
			for(int c=j; c<j+5; c++)
				if(board[i][c]!=type)
					return false;
		else if(safe(i+4, j)) 
			for(int r=i; r<i+5; r++) 
				if(board[r][j]!=type)
					return false;
		else if(safe(i+4, j+4))
			for(r=i, c=j; r<i+5 && c<j+5; r++,c++)
				if(board[r][c]!=type)
					return false;
		else if(safe (i-4, j+4))
			for(r=i, c=j; r>i-5 && c<j+5; r--,c++)
				if(board[r][c]!=type)
					return false;
		else
			return false;
		return true;
	}
	
	public static boolean safe(int i, int j) {
		return (0<=i && i<19) && (0<=j && j<19);
	}
	
	/**
	 * 결과를 출력하는 메서드
	 * @param type
	 */
	public static void output(int type) {
		System.out.println(type);
		if(type!=0)
			System.out.print(row+" "+col);
	}
}

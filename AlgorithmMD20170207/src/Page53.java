import java.util.Scanner;

/**
 * n개로 이루어진 정수 집합에서 원하는 수의 위치를 찾는 클래스
 * @since jdk1.8
 * @author Genie
 */
public class Page53 {
	public static void main(String[] args) {
		/**
		 * sc 사용자의 입력을 받기 위한 변수
		 * n 배열의 크기를 저장하기 위한 변수
		 * list n크기 만큼의 int형 배열 변수
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0; i<list.length; i++) {
			list[i] = sc.nextInt();
		}
		int searchNum = sc.nextInt();
		System.out.println(search(list, 0, list.length-1, searchNum));
	}
	
	/**
	 * 정렬된 배열이 주어지기 때문에 binary search를 진행
	 * @param list
	 * @param start 시작위치
	 * @param end 끝 위치
	 * @param searchNum 찾고자 하는 수
	 * @return
	 */
	public static int search(int[] list, int start, int end, int searchNum) {
		while(start<=end) {
			int m = (start+end)/2;
			if(list[m]==searchNum)
				return m+1;
			else if(list[m]>searchNum)
				end = m-1;
			else if(list[m]<searchNum)
				start = m+1;
		}
		return -1;
	}

}

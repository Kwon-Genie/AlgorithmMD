import java.util.Scanner;

/**
 * Upper bound 
 * n개로 이루어진 정수 집합에서 원하는 수 k 보다 큰 수가 처음으로 등장하는 위치를 찾으시오
 * @since jdk1.8
 * @author Genie
 *
 */
public class Page62 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int index=0; index<list.length; index++) {
			list[index] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(upperBound(list, 0, list.length, k));
		
	}
	
	/**
	 * upper bound를 찾는 메서드
	 * list에서 k를 초과하는 가장 첫 번째 원소의 위치를 구하는 메서드
	 * 모든 원소가 k보다 작으면 list길이 +1을 출력한다.
	 * 그렇기 떄문에 end는 list의 length-1이 아닌 list의 length를 넣어준다. 
	 * @param list
	 * @param start
	 * @param end
	 * @param k
	 * @return
	 */
	public static int upperBound(int[] list, int start, int end, int k) {
		int middle;
		while(end>start) {
			middle = (start+end)/2;
			if(list[middle]<=k) start = middle+1;
			else end = middle;
		}
		return end+1;
	}
}

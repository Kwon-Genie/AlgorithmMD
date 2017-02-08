import java.util.Scanner;

/**
 * Upper bound 
 * n���� �̷���� ���� ���տ��� ���ϴ� �� k ���� ū ���� ó������ �����ϴ� ��ġ�� ã���ÿ�
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
	 * upper bound�� ã�� �޼���
	 * list���� k�� �ʰ��ϴ� ���� ù ��° ������ ��ġ�� ���ϴ� �޼���
	 * ��� ���Ұ� k���� ������ list���� +1�� ����Ѵ�.
	 * �׷��� ������ end�� list�� length-1�� �ƴ� list�� length�� �־��ش�. 
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

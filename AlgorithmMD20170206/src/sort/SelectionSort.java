package sort;

import java.util.Scanner;

/**
 * 삽입정렬 구현 소스코드
 * @since jdk 1.8
 * @author Genie
 */
public class SelectionSort {
	public static void main(String[] args) {
		/**
		 * sc Scanner 클래스를 이용하여 사용자의 입력을 받을 객체 생성
		 * testCaseNum 정렬할 배열의 크기를 입력받을 변수
		 * arr 정렬할 배열의 값들이 저장될 배열 변수 
		 */
		Scanner sc = new Scanner(System.in);
		int testCaseNum = 0;
		
		System.out.print("배열의 길이를 입력하세요: ");
		testCaseNum = sc.nextInt();
		int[] arr = new int[testCaseNum];
		System.out.print("배열의 값을 입력해주세요: ");
		for(int index=0; index<testCaseNum; index++) {
			arr[index] = sc.nextInt();
		}
		selectionSort(arr);
		printArray(arr);
	}
	
	/**
	 * 파라미터로 받은 int 배열 삽입정렬하는 함수 
	 * @param arr
	 */
	public static void selectionSort(int[] arr) {
		for(int index=0; index<arr.length; index++) {
			for(int jIndex=index+1; jIndex<arr.length; jIndex++) {
				if(arr[index]>arr[jIndex]) {
					arr[index] = arr[index]+arr[jIndex];
					arr[jIndex] = arr[index]-arr[jIndex];
					arr[index] = arr[index]-arr[jIndex];
				}
			}
		}
	}
	
	/**
	 * 파라미터로 받은 int 배열 arr 출력하기
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
}
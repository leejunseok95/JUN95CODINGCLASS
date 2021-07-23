package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 5명의 별명을 입력받아서 사용하는데, 각, 별명의 길이가 같은 것을 입력 받을 수 있다.
 */

public class ArrayListTest04 {
	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("문제 1번");
		System.out.println("5명의 별명을 입력하세요(단, 별명의 길이는 다르게)");
		for (int i = 0; i < 5; i++) {
			System.out.print((i+1) + "번째 별명 : ");
			String inputName = scanner.next();
			nameList.add(inputName);
		}
		System.out.println();
		
		//제일 긴 별명의 길이가 저장될 변수를 선언하고
		//이 변수에 첫번째 데이터의 길이를 저장한다.
		int maxLen = nameList.get(0).length();
		
		for (int i = 0; i < nameList.size(); i++) {
			if (maxLen < nameList.get(i).length()) {
				maxLen = nameList.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for (String alias : nameList) {
			System.out.println(alias);
		}
	}
}

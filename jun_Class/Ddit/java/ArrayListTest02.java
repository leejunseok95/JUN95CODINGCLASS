package kr.or.ddit.basic;
/*
 * 문제 5명의 이름을 입력받아 ArrayList에 저장한 후에 
 * 이들 중 '김'시 성의 이름을 모두 출력하시오.
 * (입력은 Scanner를 이용한다.)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
	public static void main(String[] args) {
		ArrayList<String> nameList = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("5명의 이름을 입력하시오");
		
		for (int i = 0; i < 5; i++) {
			System.out.print("이름을 : ");
			String inputName = scanner.next();
			nameList.add(inputName);
		}
		System.out.println();
		
		System.out.println("김씨성을 가지신 분(substring)");
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).substring(0,1).equals("김")) {
				System.out.println(nameList.get(i));
			}
		}
		
		System.out.println("김씨성을 가지신 분(charAt)");
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).charAt(0) == '김') {
				
				System.out.println(nameList.get(i));
			}
		}
		
		System.out.println("김씨성을 가지신 분(indexOf)");
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).indexOf("김") == 0) {
				System.out.println(nameList.get(i));
			}
		}
		
		System.out.println("김씨성을 가지신 분(startsWith)");
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(i).startsWith("김")) {
				System.out.println(nameList.get(i));
			}
		}
		
		scanner.close();
	}
}

package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-2222"));
		memList.add(new Member(6, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "강감찬", "010-4444-4444"));
		memList.add(new Member(4, "일지매", "010-5555-5555"));
		memList.add(new Member(2, "변학도", "010-6666-6666"));

		System.out.println("정렬전...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");

		Collections.sort(memList);
		System.out.println("회원 이름의 내림차순 (내부 정렬)후...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		
		//Member의 값을 오름차순 정렬을 하는 외부 정렬 기준을 이용
		System.out.println("------------------------------------------------");
		Collections.sort(memList, new SortName());
		System.out.println("회원 이름의 오름차순 정렬(외부 정렬)후...");
		for (Member mem : memList) {
			System.out.println(mem);
		}
	}
}

// Member의 num값의 내림차순으로 정렬할 수 있는 (내부 정렬 기준 설정)
class Member implements Comparable<Member> {
	private int num;
	private String name;
	private String tel;

	// num값의 내림차순으로 설정
	@Override
	public int compareTo(Member mem) {
//		if (this.getNum() > mem.getNum()) {
//			return -1;
//		} else if (this.getNum() < mem.getNum()) {
//			return 1; //양수를 반환하면 두 값의 순서가 바뀐다.
//		} else {
//			return 0;
//		}
		// wrapper 클래스를 이용하는 방법1
		// 내림 차순 방법
//		return new Integer(this.getNum()).compareTo(mem.getNum()) * -1;

//		wrapper 클래스를 이용하는 방법2
		return Integer.compare(this.getNum(), mem.getNum()) * -1;
	}

	// 생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
}

// 외부 정렬 기준 ==> 회원 이름의 오름차순 정렬이 될수 있는 (외부 정렬 기준 만들기)
class SortName implements Comparator<Member>{
	@Override
	public int compare(Member mem1, Member mem2) {
//		if (mem1.compareTo(mem2) > 0) {
//			return -1;
//		} else if (mem1.compareTo(mem2) < 0) {
//			return 1;
//		} else {			
//			return 0;
//		}
		return mem1.compareTo(mem2);
	}
}

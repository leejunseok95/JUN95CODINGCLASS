package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
 * Student클래스를 만든다.
 * 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만
 * 매개변수로 설정해서 데이터를 초기화 처리 한다.
 * 
 * 이 Student 객체는 List에 저장하여 관리한다.
 * 
 * List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현
 * 총점의 역순으로 정렬하는데, 총점이 같으면 이름의 오름차순으로 정렬이 되는 
 * 외부 정렬 기준 클래스를 작성하여 정렬한 결과를 출력하시오.
 * (등수는 List에 전체 데이터가 추가된 후에 구한다.)
 */
public class StudentTest {
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "이준석", 100, 100, 100));
		studentList.add(new Student(3, "이인환", 88, 34, 56));
		studentList.add(new Student(2, "권영채", 78, 56, 77));
		studentList.add(new Student(4, "임창균", 80, 99, 44));
		studentList.add(new Student(5, "강주휘", 90, 63, 70));
		studentList.add(new Student(9, "박수정", 67, 48, 97));
		studentList.add(new Student(8, "서유리", 54, 87, 56));
		studentList.add(new Student(6, "김다윤", 75, 34, 19));
		studentList.add(new Student(7, "이나영", 100, 100, 100));

		System.out.println("정렬전...");
		for (Student student : studentList) {
			System.out.println(student);
		}

		System.out.println("------------------------------------------------");
		Collections.sort(studentList);
		System.out.println("학생 학번 순");
		for (Student student : studentList) {
			System.out.println(student);
		}

		System.out.println("------------------------------------------------");
		int rank = 1;
		Collections.sort(studentList, new SortStudent());
		System.out.println("학생 총점 순");
		for (Student student : studentList) {
			System.out.println(rank + "등:\t" + student);
			rank++;
		}

	}
}

class Student implements Comparable<Student> {
	private int studentClassNum;
	private String studentName;
	private int koreanScore;
	private int englishScore;
	private int mathScore;

	public Student(int studentClassNum, String studentName, int koreanScore, int englishScore, int mathScore) {
		super();
		this.studentClassNum = studentClassNum;
		this.studentName = studentName;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	@Override
	public int compareTo(Student studentInfo) {
		return Integer.compare(this.getStudentClassNum(), studentInfo.getStudentClassNum());
	}

	public int getStudentClassNum() {
		return studentClassNum;
	}

	public void setStudentClassNum(int studentClassNum) {
		this.studentClassNum = studentClassNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int totalScore() {
		return this.koreanScore + this.englishScore + this.mathScore;
	}

	@Override
	public String toString() {
		return "[학번: " + studentClassNum + ", 이름: " + studentName + ", 수학점수: " + koreanScore + ", 영어점수: "
				+ englishScore + ", 수학점수: " + mathScore + ", 총점: " + totalScore() +"]";
	}
}

class SortStudent implements Comparator<Student> {
	@Override
	public int compare(Student stu1, Student stu2) {
		if (stu1.totalScore() > stu2.totalScore()) {
			return -1;
		} else if (stu1.totalScore() < stu2.totalScore()) {
			return 1;
		} else {
			return stu1.getStudentName().compareTo(stu2.getStudentName());
		}
	}
}

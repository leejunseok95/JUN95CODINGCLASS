package leveltest2;

public class ClassRoom {
	private int classNumber;
	private Student[] students = new Student[5];
	private Teacher teacher;
	private int totalStudent;
	
	public ClassRoom(int classNumber, Teacher teacher) {
		this.classNumber = classNumber;
		this.teacher = teacher;
	}
	
	public int getClassNumber() {
		return classNumber;
	}
	
	public boolean addStudent(Student student) {
		try {
			if (totalStudent != 5) {
				students[totalStudent] = student;
				totalStudent++;
				System.out.print(totalStudent + "명..");
				return true;
			} else {
				System.out.println();
				throw new ArrayIndexOutOfBoundsException();
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 강의실에는 더 이상 학생을 추가할 수 없습니다.");
			return false;
		}
	}
	
	public void showClassInfo() {
		System.out.println("-------- 대덕인재개발원 "+ classNumber +"호 정보 --------");
		System.out.println("담임교사 : " + teacher.getName());
		System.out.println("총학생수 : " + totalStudent);
		System.out.println("학생명단 : ");
		for (int i = 0; i < students.length; i++) {
			System.out.printf("%s\t",students[i].getName());
		}
		System.out.println();
		System.out.println("------------------------------------");
	}
	
	public void showStudentInfo(Human human, int index) {
		try {
			if (human instanceof Teacher) {
				if (human.hashCode() == this.teacher.hashCode()) {
					System.out.println(students[index].toString());
				} else {
					throw new NotTeacherException();
				}
			} else if(human instanceof Student) {
				if (human.hashCode() == this.students[index].hashCode()) {
					System.out.println(students[index].toString());
				} else {
					throw new NotConfirmException();
				}
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}

		}catch (NotTeacherException e) {
			System.out.println(e.toString());
		}catch (NotConfirmException e) {
			System.out.println(e.toString());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 학생 index입니다.");
		}
	}
}

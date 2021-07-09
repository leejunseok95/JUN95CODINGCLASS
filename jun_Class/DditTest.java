package leveltest2;

public class DditTest {
	public static void main(String[] args) {
		Teacher[] teachers = new Teacher[5];
		teachers[0] = new Teacher("송중호", "남");
		teachers[1] = new Teacher("김승섭", "남");
		teachers[2] = new Teacher("김형민", "남");
		teachers[3] = new Teacher("배미숙", "여");
		teachers[4] = new Teacher("박성룡", "남");
		
		ClassRoom[] classRooms = new ClassRoom[5];
		classRooms[0] = new ClassRoom(401, teachers[0]);
		classRooms[1] = new ClassRoom(402, teachers[1]);
		classRooms[2] = new ClassRoom(403, teachers[2]);
		classRooms[3] = new ClassRoom(404, teachers[3]);
		classRooms[4] = new ClassRoom(406, teachers[4]);
		
		Ddit ddit = new Ddit();
		for(int i = 0; i < classRooms.length; i++) {
			ddit.addClassRoom(classRooms[i]);
		}
		ddit.showClassRoomList();
		System.out.println();
		
		Student[] students = new Student[25];
		students[0] = new Student("강주희", "여", 32);
		students[1] = new Student("구현수", "남", 29);
		students[2] = new Student("권영채", "남", 31);
		students[3] = new Student("김다윤", "여", 27);
		students[4] = new Student("김주현", "여", 25);
		students[5] = new Student("박수정", "여", 27);
		students[6] = new Student("박해성", "남", 28);
		students[7] = new Student("봉현민", "남", 33);
		students[8] = new Student("서유리", "여", 28);
		students[9] = new Student("서혜란", "여", 28);
		students[10] = new Student("안대근", "남", 27);
		students[11] = new Student("유영진", "남", 27);
		students[12] = new Student("유재면", "남", 34);
		students[13] = new Student("유제이", "남", 26);
		students[14] = new Student("윤주원", "남", 29);
		students[15] = new Student("윤효주", "여", 32);
		students[16] = new Student("이나영", "여", 27);
		students[17] = new Student("이인환", "남", 27);
		students[18] = new Student("이준석", "남", 27);
		students[19] = new Student("이희열", "여", 27);
		students[20] = new Student("임창균", "남", 26);
		students[21] = new Student("임태희", "남", 31);
		students[22] = new Student("조원혜", "여", 25);
		students[23] = new Student("최가현", "여", 21);
		students[24] = new Student("한주연", "여", 24);
		
		int cnt = 0;
		for(int i = 0; i < ddit.getTotalClassRoom(); i++) {
			System.out.println(ddit.getClassRoom(i).getClassNumber() + "호에 학생 배치...");
			while(cnt < 25) {
				if(!ddit.getClassRoom(i).addStudent(students[cnt])) break;
				else cnt++;
			}
			System.out.println();
			ddit.getClassRoom(i).showClassInfo();
			System.out.println();
		}
		
		ddit.getClassRoom(0).showStudentInfo(teachers[4], 0);
		System.out.println();
		
		ddit.getClassRoom(4).showStudentInfo(teachers[4], 0);
		System.out.println();
		
		ddit.getClassRoom(4).showStudentInfo(students[4], 0);
		System.out.println();
		
		ddit.getClassRoom(4).showStudentInfo(students[24], 0);
		System.out.println();
		
		ddit.getClassRoom(4).showStudentInfo(students[24], 10);
		System.out.println();
		
		ddit.getClassRoom(4).showStudentInfo(students[24], 4);
	}
}
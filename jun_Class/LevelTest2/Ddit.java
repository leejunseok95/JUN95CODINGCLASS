package leveltest2;

public class Ddit {
	private ClassRoom[] classRooms = new ClassRoom[8];
	private int totalClassRoom;
	
	public void addClassRoom(ClassRoom classRoom) {
		this.classRooms[totalClassRoom++] = classRoom;
	}
	
	public ClassRoom getClassRoom(int index) {
		return classRooms[index];
	}
	
	public int getTotalClassRoom() {
		return totalClassRoom;
	}
	
	public void showClassRoomList() {
		System.out.println("-------- 대덕인재개발원 강의실 목록 --------");
		for (int i = 0; i < totalClassRoom; i++) {
			System.out.print(getClassRoom(i).getClassNumber() + "호\t");
		}
		System.out.println();
		System.out.println("------------------------------------");
	}
}

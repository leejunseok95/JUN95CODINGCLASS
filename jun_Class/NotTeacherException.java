package leveltest2;

@SuppressWarnings("serial")
public class NotTeacherException extends Exception {
	@Override
	public String toString() {
		return "담임이 아닙니다. 담임 혹은 본인만 확인할 수 있습니다.";
	}
}

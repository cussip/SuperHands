package object;

//-----------------------------------------------------------------------------------------------------------
// class Time
//-----------------------------------------------------------------------------------------------------------
class Time {
	private	int	hour;
	private	int minute;
	private	int	second;
	
	Time(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour < 0 || hour > 23) return;
		this.hour	= hour;
	}
	
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0 || minute > 59) return;
		this.minute	= minute;
	}
	
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0 || second > 59) return;
		this.second	= second;
	}
	
	public String toString() {
		return hour + "시 " + minute + "분 " + second + "초";
	}
	
} // End - class Time
//-----------------------------------------------------------------------------------------------------------
// public class TimeExam
//-----------------------------------------------------------------------------------------------------------
public class TimeExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Time t = new Time(12, 35, 27);
		System.out.println(t);
		// t.hour = 14; <== private으로 선언된 변수는 외부에서 접근할 수가 없다.
		t.setHour(t.getHour()+1); // 현재시간보다 1시간을 더한다.
		System.out.println(t);
		// System.out.println(t.hour);

	} // End - public static void main(String[] args)

} // End - public class TimeExam







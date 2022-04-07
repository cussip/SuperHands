package object;

//-----------------------------------------------------------------------------------------------------------
// public class RepairExam
//-----------------------------------------------------------------------------------------------------------
public class RepairExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		Tank		tank		= new Tank();
		DropShip	dropShip	= new DropShip();
		Marine		marine		= new Marine();
		SCV			scv			= new SCV();
		
		scv.repair(dropShip);
		scv.repair(tank);
		
		// scv.repair(marine);
		
	} // End - public static void main(String[] args)

} // End - public class RepairExam

//-----------------------------------------------------------------------------------------------------------
// interface Repairable
//-----------------------------------------------------------------------------------------------------------
interface Repairable {}

//-----------------------------------------------------------------------------------------------------------
// class Unit
//-----------------------------------------------------------------------------------------------------------
class Unit {
	int	hitPoint;
	final int MAX_HP;
	Unit(int hp) {
		MAX_HP = hp; // 생성자를 통해서 상수를 초기화 한다.
	}
} // End - class Unit

//-----------------------------------------------------------------------------------------------------------
// 육군
//-----------------------------------------------------------------------------------------------------------
class GroundUnit extends Unit {
	GroundUnit(int hp) {
		super(hp);
	}
} // End - class GroundUnit extends Unit

//-----------------------------------------------------------------------------------------------------------
// 공군
//-----------------------------------------------------------------------------------------------------------
class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
} // End - class AirUnit extends Unit 

//-----------------------------------------------------------------------------------------------------------
// class Tank extends GroundUnit implements Repairable
//-----------------------------------------------------------------------------------------------------------
class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(200);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "탱크";
	}
} // End - class Tank extends GroundUnit implements Repairable
//-----------------------------------------------------------------------------------------------------------
// class DropShip extends AirUnit implements Repairable
//-----------------------------------------------------------------------------------------------------------
class DropShip extends AirUnit implements Repairable {
	DropShip() {
		super(250);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "수송선";
	}
} // End - class DropShip extends AirUnit implements Repairable
//-----------------------------------------------------------------------------------------------------------
// class Marine extends GroundUnit
//-----------------------------------------------------------------------------------------------------------
class Marine extends GroundUnit {
	Marine() {
		super(50);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "마린";
	}
} // End - class Marine extends GroundUnit
//-----------------------------------------------------------------------------------------------------------
// class SCV extends GroundUnit implements Repairable
//-----------------------------------------------------------------------------------------------------------
class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(50);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "SCV";
	}
	void repair(Repairable r) { // 수리를 하는 기능
		if(r instanceof Unit) {
			Unit u = (Unit) r;
			while(u.hitPoint != u.MAX_HP) {
				/* Unit의 HP를 증가시킨다. */
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		}
		
	}
} // End - class SCV extends GroundUnit implements Repairable












package inheritance.basic;

import java.awt.Frame;
import java.awt.Graphics;

//-----------------------------------------------------------------------------------------------------------
// public class DrawShape
//-----------------------------------------------------------------------------------------------------------
public class DrawShape extends Frame {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		DrawShape win = new DrawShape("도형 그리기");
	} // End - public static void main(String[] args)
	
	public void paint(Graphics g) {
		Circle c = new Circle(new Point(160, 200), 70);
		// 원을 그린다.
		g.drawOval(c.center.x, c.center.y, c.r, c.r);
		
		Point[] p = {
				new Point(100, 100),
				new Point(140,  50),
				new Point(200, 100)
		};
		
		Triangle t = new Triangle(p);
		// 3개의 좌표를 직선으로 그려준다. => 삼각형
		g.drawLine(t.p[0].x, t.p[0].y, t.p[1].x, t.p[1].y);
		g.drawLine(t.p[1].x, t.p[1].y, t.p[2].x, t.p[2].y);
		g.drawLine(t.p[2].x, t.p[2].y, t.p[0].x, t.p[0].y);
	}

	DrawShape(String title) {
		super(title);
		setSize(400, 500);
		setLocation(400, 100);
		setVisible(true);
	}
} // End - public class DrawShape

//-----------------------------------------------------------------------------------------------------------
// class Point
//-----------------------------------------------------------------------------------------------------------
class Point {
	int	x;
	int	y;
	
	Point(int x, int y) {
		this.x	= x;
		this.y	= y;
	}
	
	Point() {
		this(0, 0);
	}
} // End - class Point

//-----------------------------------------------------------------------------------------------------------
// class Circle
//-----------------------------------------------------------------------------------------------------------
class Circle {
	Point 	center;	// 원의 원점 좌표
	int		r;		// 반지름
	
	Circle() {
		this(new Point(0, 0), 100);
	}
	
	Circle(Point center, int r) {
		this.center	= center;
		this.r		= r;
	}
} // End - class Circle
//-----------------------------------------------------------------------------------------------------------
// class Triangle
//-----------------------------------------------------------------------------------------------------------
class Triangle {
	Point[] p	= new Point[3];
	
	Triangle(Point[] p) {
		this.p	 = p;
	}
	
	Triangle(Point p1, Point p2, Point p3) {
		p[0]	= p1;
		p[1]	= p2;
		p[2]	= p3;
	}
	
} // End - class Triangle














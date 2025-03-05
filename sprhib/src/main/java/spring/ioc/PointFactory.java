package spring.ioc;

public class PointFactory {
	static int i;
	public PointFactory() {
		System.out.println("Point Factory....");
	}
	
	public static Point createPoint() {
		return new Point(i++,i);
	}
	
	public static Point createPoint(int x,int y) {
		return new Point(x,y);
	}
	
}


package day2;

public class SimpleArithmetic implements ArithmeticImpl {

	@Override
	public double add(double a, double b) {
		return a+b;
	}

	@Override
	public double sub(double a, double b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double mul(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double div(double a, double b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}
	
	public static void main(String[] args) {
		SimpleArithmetic a= new SimpleArithmetic();
		//ArithmeticImpl b= new ArithmeticImpl();  //Can't make object of interface
		//ArithmeticImpl b= new SimpleArithmetic();
		System.out.println(a.add(10,20));
		System.out.println(a.sub(100,20));
		System.out.println(a.mul(10,20));
		System.out.println(a.div(10,20));
	}

}

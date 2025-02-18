package day2;

public class ControlStatement {
	
	public void testIfElse(int a) {
		if (a%2==0) {
            System.out.println("The number "+a+" is even.");
        } else {
            System.out.println("The number "+a+" is odd.");
        }
	}
	public void testFor(int [] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void testSwitch(int a) {
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("TWO");
		case 3:
			System.out.println("Three");
			break;
		default:
			System.out.println("All others");
			
		}
	}
	
	public int add(int ... a) {
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		System.out.println("Sum= "+sum);
		return sum;
	}

	public static void main(String[] args) {
		ControlStatement cs=new ControlStatement();
		cs.testIfElse(2);
		cs.testIfElse(12);
		cs.testIfElse(23);
		cs.testIfElse(3);
        cs.testFor(new int[] {2,4,56});
        cs.testSwitch(6);
        cs.add(1,2,3);
        cs.add(1,2,3,45,67,8);
    }
}

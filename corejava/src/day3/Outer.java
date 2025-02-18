package day3;

public class Outer {
	private int a;
	public void outerPrint() {
		System.out.println("Outer Print");
	}
	
	public class Inner { 
		private int b;
		public void print() {
			System.out.println("Inner Print A="+ a+" B "+b);
		}
		
		public void addOne() {
			b++;
			a++;

		}
	}
		public static class StaticInner {
			public void print(Outer o) {
				System.out.println("A=" + o.a);
			}
		}
		
		private static abstract class Just{
			abstract void print();
			
		}
		
		public static class JustImpl extends Just{
			@Override
			void print() {
				System.out.println("My Job is to Just Print...");
			}
		}
		
	
	public static void main(String[] args) {
		Outer o=new Outer();
		Outer.Inner i=o.new Inner();
		i.addOne();
		Outer.Inner i1=o.new Inner();
		i1.print();
		i.print();
		
		Outer o1=new Outer();
		Inner i2=o1.new Inner();
		i2.addOne();
		i2.print();
		i.print();
		
		Outer.StaticInner si=new StaticInner();
		si.print(o1);
		
		Just j=new JustImpl();
		j.print();
		
		Just j1=new Just() {
			@Override
			void print() {
				System.out.println("Just Anonymous...");
			}
		};
		j1.print();
		
	}
}


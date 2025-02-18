package day1;

public class Dog implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Bow..");
	}

	@Override
	public void eat() {
		System.out.println("Biscuits..");
	}

	@Override
	public void sleep() {
		System.out.println("Snor..");
	}

}

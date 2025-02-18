package day1;

public interface Animal {  //Contractual obligation: Just hide complexity from customer hide how it works and easy to switch b/w provider
	                       //
	int ZERO=0;     //Automatically make constant: public static final
     void makeSound();   //Automatically make public abstract
     void eat();
     void sleep();
	//single inheritance ,multiple interface
     //No main method
}

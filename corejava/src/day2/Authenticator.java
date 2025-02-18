package day2;
import java.util.Random;

public class Authenticator {

	public long authenticate(String name,String pass) {
		if("scott".equals(name) && "tiger".equals(pass)) {//Opposite name.equals("scott") throw null point exception when name=null
			return new Random().nextLong();
		}
		//throw new Exception("Only Scott is allowed");
		throw new RuntimeException("Only Scott is allowed");   //use when we don't want to solve exception and want to others
		//in RuntimeException and all of its subclass no need to write throws clause
	}
}

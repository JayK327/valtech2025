package day2;

public class ExceptionExample {

	public static void main(String[] args) {
		Authenticator auth=new Authenticator();
		try {
			long code=auth.authenticate("scott", "tiger");
			System.out.println("Auth Code="+code);
		} catch (Exception e) { //if we try to solve exception yourself
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			System.out.println("I will always be executed");
		}
		
	}

}

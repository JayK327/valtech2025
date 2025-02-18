package day4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.Test;

class IOTest {
	
	
	@Test
	public void testBufferedReader() {
		try(BufferedReader br= new BufferedReader(new FileReader(new File("data.txt")))) {
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		}	catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	@Test
	public void testReaders() {
		try(Reader reader=new FileReader(new File("data.txt"))) { 
			try(FileWriter writer=new FileWriter(new File("dataOut.txt")))  {
				char [] buff=new char[4];
				int i=-1;
				while((i=reader.read(buff))!=-1) {
					//System.out.println(new String(buff,0,i));
					writer.write(buff,0,i);
				}
				writer.flush();
			}
		}	catch(Exception ex) {
			
		}
	}
	
	@Test
	public void testChainingStreams() {
		try(InputStream is=new BufferedInputStream(new FileInputStream(new File("data.txt")))){
			try(OutputStream os=new FileOutputStream("dataCopy.txt")) {
				byte [] buff=new byte[4];  
				int i=0;
				while((i=is.read(buff))!=-1) {
					System.out.println(new String(buff,0,i));
					os.write(buff,0,i);
				}
				os.flush();
			}
		}	catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

	@Test
	public void testSecondReadTryWithResourceswithLoop() {  // no need to write close statement

		try(InputStream is = new  FileInputStream(new File("data.txt"))) {
			try(OutputStream os=new FileOutputStream("dataCopy.txt")) {
				byte [] buff=new byte[4];  
				int i=0;
				while((i=is.read(buff))!=-1) {
					System.out.println(new String(buff,0,i));
					os.write(buff,0,i);
				}
				os.flush();
			}
		}  catch(Exception ex) {
			 ex.printStackTrace();
		}
				
	}
	
	
	
	@Test
	public void testSecondReadTryWithResources() {  // no need to write close statement
		try(InputStream is = new  FileInputStream(new File("data.txt"))) {
			byte [] buff=new byte[4];    // generally 8192 or 16782
			int bytesRead= is.read(buff);
			assertEquals(4,bytesRead);
			System.out.println(new String(buff));
			assertEquals(4,is.read(buff));
			System.out.println(new String(buff));
			assertEquals(3,is.read(buff,0,3));
			System.out.println(new String(buff));
//		
			assertEquals(1,is.read(buff));
			assertEquals(-1,is.read(buff));
			System.out.println(new String(buff));
		}  catch(Exception ex) {
			 ex.printStackTrace();
		}
				
	}
	

	@Test
	public void testReadTryWithResources() {  // no need to write close statement
		try(InputStream is = new  FileInputStream(new File("data.txt"))) {
			assertEquals('H',((byte)is.read()));
			assertEquals('e',((byte)is.read()));
			assertEquals('l',((byte)is.read()));
		}  catch(Exception ex) {
			 ex.printStackTrace();
		}
				
	}
	
	@Test
	public void testRead() {
		InputStream is=null;
		try {
			is = new FileInputStream(new File("data.txt"));
			assertEquals('H',((byte)is.read()));
			assertEquals('e',((byte)is.read()));
			assertEquals('l',((byte)is.read()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}



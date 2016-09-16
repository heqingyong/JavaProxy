/** 
 * @projectName:JavaProxy 
 * @fileName:SelfTest.java 
 * @packageName:club.younge.test 
 * @date:2016年9月4日上午11:44:37 
 * @copyright (c) 2016, heqy@finansir.nt All Rights Reserved. 
 * 
 */  
  
package club.younge.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import club.younge.proxy.Jason;
import club.younge.proxy.People;
import club.younge.proxy.jdk.ProxyHandler;
import sun.misc.ProxyGenerator;

/** 
 * @className:SelfTest 
 * @function: TODO ADD FUNCTION.  
 * @reason:   TODO ADD REASON. 
 * @date:     2016年9月4日 上午11:44:37
 * @author   Younge 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class JdkTest {

	public static void main(String[] args) throws Throwable {
		People people = (People) Proxy.newProxyInstance(People.class.getClassLoader(), new Class[]{People.class}, new ProxyHandler(new Jason()));
		people.eat();
		System.out.println("People's actual class:" + people.getClass().getName());
		System.out.println("Game over!");
		//createProxyFile();
	}
	
	public static void createProxyFile() throws IOException{
		String proxyName = "ProxyPeople";
		byte[] data = ProxyGenerator.generateProxyClass(proxyName, new Class[]{People.class}); //调试时的名称为$Proxy0
		FileOutputStream fos = new FileOutputStream(proxyName + ".class");
		fos.write(data);
		fos.close();
	}
	

}

